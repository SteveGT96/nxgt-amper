package services

import helpers.*
import models.Token
import models.User
import exceptions.CustomException
import i18n.Messages
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.execution.ErrorType
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.jwt.*
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.Instant

@Service
class JwtService @Autowired constructor(
	private val userService: UserService,
	private val jwtProperties: JwtProperties,
	private val encoder: JwtEncoder,
	private val decoder: JwtDecoder,
	private val rsa: RsaKeyProperties,
	private val ds: UserDataSource
) {

	suspend fun createToken(user: User): Token {
		val claims: JwtClaimsSet.Builder = JwtClaimsSet.builder().subject(user.username)
		val expiration = Instant.now(Clock.systemUTC()).plusMillis(jwtProperties.refreshValidity)
		val access = encoder.encode(
			JwtEncoderParameters.from(
				claims.expiresAt(
					Instant.now(Clock.systemUTC()).plusMillis(jwtProperties.validity)
				).build()
			)
		).tokenValue
		val refresh = encoder.encode(JwtEncoderParameters.from(claims.expiresAt(expiration).build())).tokenValue

		return Token(
			username = user.username, access = access, refresh = refresh, expiration = expiration
		).also {
			ds.loadAuthorities(user, expiration)
			ds.loadTokens(it)
		}
	}

	fun getAuthentication(token: String): Authentication {
		val userDetails: UserDetails = userService.loadUserByUsername(getUserName(token))
		return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
	}

	fun getUserName(token: String): String {
		return decoder.decode(token).subject
	}

	fun resolveToken(req: HttpServletRequest): String? {
		val bearerToken: String? = req.getHeader("Authorization")

		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7)
		}
		return null
	}

	fun validateToken(token: String): String? {
		return try {
			decoder.decode(token).subject
		} catch(e: JwtException) {
			throw CustomException(ErrorType.UNAUTHORIZED, Messages.ERRORS_UNAUTHORIZED, e.message)
		}
	}

	fun validateAccessToken(value: String) {
		try {
			if(ds.ds.loadValue(
					validateToken(value)?.accessTokenKey ?: ""
				) != value
			) throw CustomException(ErrorType.UNAUTHORIZED)
		} catch(e: Exception) {
			throw e
		}
	}

	suspend fun validateRefreshToken(value: String) {
		try {
			if(ds.ds.loadValue(
					validateToken(value)?.refreshTokenKey ?: ""
				) != value
			) throw CustomException(ErrorType.UNAUTHORIZED)
		} catch(e: Exception) {
			throw e
		}
	}
}