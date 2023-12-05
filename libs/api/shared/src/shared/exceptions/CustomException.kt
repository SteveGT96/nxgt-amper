package shared.exceptions

import org.springframework.graphql.execution.ErrorType


class CustomException(
	val type: ErrorType = ErrorType.BAD_REQUEST,
	override val message: String = "errors.something_went_wrong",
	val debugMessage: String? = null,
	val args: Array<Any> = arrayOf()
) : RuntimeException(message)