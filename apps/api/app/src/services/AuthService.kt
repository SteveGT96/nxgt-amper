package services

import dto.LoginInput
import helpers.*
import models.Token
import types.CustomUserDetails
import exceptions.CustomException
import i18n.Messages
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.security.authentication.*
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val jwtService: JwtService,
	private val service: UserService,
	private val template: MongoTemplate,
	private val authenticationManager: AuthenticationManager,
	private val ds: UserDataSource
) {
	suspend fun login(input: LoginInput): Token {
		val authRequest = UsernamePasswordAuthenticationToken.unauthenticated(input.username, input.password)
		service.findById(input.username)
		with(Messages) {
			try {
				val user = (authenticationManager.authenticate(authRequest).principal as CustomUserDetails).user
				return jwtService.createToken(user)
			} catch(e: BadCredentialsException) {
				throw CustomException(message = ERRORS_BAD_CREDENTIALS, debugMessage = e.message)
			} catch(e: LockedException) {
				throw CustomException(message = USERS_ACCOUNT_LOCKED, debugMessage = e.message)
			} catch(e: DisabledException) {
				throw CustomException(message = USERS_ACCOUNT_DISABLED, debugMessage = e.message)
			} catch(e: AccountExpiredException) {
				throw CustomException(message = USERS_ACCOUNT_EXPIRED, debugMessage = e.message)
			} catch(e: CredentialsExpiredException) {
				throw CustomException(message = USERS_CREDENTIALS_EXPIRED, debugMessage = e.message)
			} catch(e: Exception) {
				throw CustomException(message = ERRORS_AUTHENTICATION_FAILED, debugMessage = e.message)
			}
		}
	}

	suspend fun refreshToken(token: String): Token {
		jwtService.validateRefreshToken(token)
		val user = service.findById(jwtService.getUserName(token))

		return jwtService.createToken(user)
	}

	suspend fun logout(username: String) {
		ds.ds.removeKeys(
			username.accessTokenKey,
			username.refreshTokenKey,
			username.groupsKey,
			username.rolesKey,
			username.permissionsKey
		)
	}
}