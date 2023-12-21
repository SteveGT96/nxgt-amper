package shared.exceptions

import graphql.GraphQLError
import graphql.execution.*
import jakarta.validation.ConstraintViolationException
import org.springframework.context.MessageSource
import org.springframework.dao.DuplicateKeyException
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.graphql.execution.ErrorType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import shared.config.translate
import shared.helpers.Regexp
import shared.i18n.Messages
import java.util.concurrent.CompletableFuture


@ControllerAdvice
class GlobalExceptionHandler(val i18n: MessageSource): ResponseEntityExceptionHandler() {
	@ExceptionHandler(CustomException::class)
	fun handleException(
		ex: CustomException
	): ResponseEntity<Any> {
		val body: Map<String, String> = mapOf("message" to i18n.translate(ex.message, *ex.args))

		return ResponseEntity(body, HttpStatus.valueOf(ex.type.name))
	}
}

class CustomDataFetcherExceptionHandler(private val i18n: MessageSource) : DataFetcherExceptionHandler {
	override fun handleException(handlerParameters: DataFetcherExceptionHandlerParameters): CompletableFuture<DataFetcherExceptionHandlerResult> {
		var errorType = ErrorType.INTERNAL_ERROR
		var message = handlerParameters.exception.message
		when(val exception = handlerParameters.exception) {
			is CustomException -> {
				errorType = exception.type
				message = i18n.translate(exception.message, *exception.args)
			}

			is ConstraintViolationException -> {
				errorType = ErrorType.BAD_REQUEST
				message = exception.constraintViolations.joinToString(", ") { it.message }
			}

			is DuplicateKeyException -> {
				val (name, value) = Regex(Regexp.DUPLICATE_KEY).find(exception.message!!)!!.destructured
				errorType = ErrorType.BAD_REQUEST
				message = i18n.translate(Messages.ERRORS_DUPLICATE_KEY, name, value)
			}

			is OptimisticLockingFailureException -> {
				errorType = ErrorType.BAD_REQUEST
				message = i18n.translate(Messages.ERRORS_LOCKING_FAILURE)
			}

			else -> {}
		}

		val result = DataFetcherExceptionHandlerResult.newResult().error(
			GraphQLError.newError().errorType(errorType).message(message).path(handlerParameters.path)
				.location(handlerParameters.sourceLocation).build()
		).build()

		return CompletableFuture.completedFuture(result)
	}
}