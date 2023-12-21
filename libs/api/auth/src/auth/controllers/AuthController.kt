package auth.controllers

import auth.dtos.LoginInput
import auth.helpers.currentUser
import auth.helpers.requiredValue
import auth.entities.Token
import auth.services.AuthService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class AuthController(
	private val service: AuthService
) {
	@MutationMapping
	suspend fun login(@Argument input: LoginInput): Token = service.login(input)

	@MutationMapping
	suspend fun logout() = service.logout(currentUser.requiredValue.username).run { currentUser.requiredValue.username }

	@MutationMapping
	suspend fun refreshToken(@Argument token: String): Token = service.refreshToken(token)
}