package shared.graphql.scalars

import shared.exceptions.CustomException
import graphql.GraphQLContext
import graphql.execution.CoercedVariables
import graphql.language.StringValue
import graphql.language.Value
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class InstantCoercing : Coercing<Instant, String> {

	override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String? {
		return try {
			(dataFetcherResult as Instant).toString()
		} catch(e: Exception) {
			throw CustomException(message = "errors.date_serialization_failed", debugMessage = e.localizedMessage)
		}
	}

	override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): Instant? {
		return try {
			Instant.parse(input.toString())
		} catch(e: Exception) {
			throw CustomException(message = "errors.date_parsing_failed", debugMessage = e.localizedMessage)
		}
	}

	override fun parseLiteral(
		input: Value<*>, variables: CoercedVariables, graphQLContext: GraphQLContext, locale: Locale
	): Instant? {
		return try {
			Instant.parse((input as StringValue).value)
		} catch(e: Exception) {
			throw CustomException(message = "errors.date_parsing_failed", debugMessage = e.localizedMessage)
		}
	}
}

class LocalDateCoercing : Coercing<LocalDate, String> {
	override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String? {
		return try {
			(dataFetcherResult as LocalDate).format(DateTimeFormatter.ISO_DATE)
		} catch(e: Exception) {
			throw CustomException(message = "errors.date_serialization_failed", debugMessage = e.localizedMessage)
		}
	}

	override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): LocalDate? {
		return try {
			LocalDate.parse(input.toString(), DateTimeFormatter.ISO_DATE)
		} catch(e: Exception) {
			throw CustomException(message = "errors.date_parsing_failed", debugMessage = e.localizedMessage)
		}
	}

	override fun parseLiteral(
		input: Value<*>, variables: CoercedVariables, graphQLContext: GraphQLContext, locale: Locale
	): LocalDate? {
		return try {
			LocalDate.parse((input as StringValue).value, DateTimeFormatter.ISO_DATE)
		} catch(e: Exception) {
			throw CustomException(message = "errors.date_parsing_failed", debugMessage = e.localizedMessage)
		}
	}
}

val InstantScalar: GraphQLScalarType =
	GraphQLScalarType.newScalar().coercing(InstantCoercing()).name("DateTime").build()
val LocalDateScalar = GraphQLScalarType.newScalar().coercing(LocalDateCoercing()).name("Date").build()
