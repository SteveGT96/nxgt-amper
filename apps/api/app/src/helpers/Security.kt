package helpers

import types.CustomUserDetails
import exceptions.CustomException
import org.springframework.graphql.execution.ErrorType
import org.springframework.security.core.context.SecurityContextHolder

val currentUser
	get() = SecurityContextHolder.getContext().authentication?.principal as? CustomUserDetails

val CustomUserDetails?.requiredValue
	get() = this ?: throw CustomException(ErrorType.UNAUTHORIZED, "errors.unauthenticated")