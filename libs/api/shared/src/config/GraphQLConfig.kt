package config

import exceptions.CustomDataFetcherExceptionHandler
import graphql.scalars.InstantScalar
import graphql.GraphQL
import graphql.Scalars
import graphql.schema.GraphQLScalarType
import graphql.schema.idl.RuntimeWiring
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.GraphQlSource.SchemaResourceBuilder
import org.springframework.graphql.execution.RuntimeWiringConfigurer


@Configuration(proxyBeanMethods = false)
class GraphQlConfig {
	@Bean
	fun runtimeWiringConfigurer(): RuntimeWiringConfigurer {
		return RuntimeWiringConfigurer { builder: RuntimeWiring.Builder ->
			builder.scalar(InstantScalar)
				.scalar(GraphQLScalarType.newScalar().name("Long").coercing(Scalars.GraphQLInt.coercing).build())
		}
	}

	@Bean
	fun sourceBuilderCustomizer(i18n: MessageSource): GraphQlSourceBuilderCustomizer {
		return GraphQlSourceBuilderCustomizer { builder: SchemaResourceBuilder ->
			builder.configureGraphQl { graphQlBuilder: GraphQL.Builder ->
				graphQlBuilder.defaultDataFetcherExceptionHandler(CustomDataFetcherExceptionHandler(i18n))
			}
		}
	}
}