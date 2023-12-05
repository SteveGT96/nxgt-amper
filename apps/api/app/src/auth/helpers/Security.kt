package auth.helpers

import auth.types.CustomUserDetails
import shared.exceptions.CustomException
import org.springframework.graphql.execution.ErrorType
import org.springframework.security.core.context.SecurityContextHolder

val currentUser
	get() = SecurityContextHolder.getContext().authentication?.principal as? CustomUserDetails

val CustomUserDetails?.requiredValue
	get() = this ?: throw CustomException(ErrorType.UNAUTHORIZED, "errors.unauthenticated")