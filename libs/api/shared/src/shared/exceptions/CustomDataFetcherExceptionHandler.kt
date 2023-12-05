package shared.exceptions

import shared.config.translate
import shared.helpers.Regexp
import shared.i18n.Messages
import graphql.GraphQLError
import graphql.execution.*
import jakarta.validation.ConstraintViolationException
import org.springframework.context.MessageSource
import org.springframework.dao.DuplicateKeyException
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.graphql.execution.ErrorType
import java.util.concurrent.CompletableFuture


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