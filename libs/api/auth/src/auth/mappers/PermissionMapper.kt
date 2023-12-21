package auth.mappers

import auth.dtos.*
import auth.entities.Permission
import shared.exceptions.CustomException
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class PermissionMapper(private val template: MongoTemplate) {
	suspend fun from(input: CreatePermissionInput): Permission {
		return Permission(name = input.name, description = input.description)
	}

	suspend fun from(input: UpdatePermissionInput): Permission {
		return template.findById<Permission>(input.id)?.copy(name = input.name, description = input.description)
			?: throw CustomException(ErrorType.NOT_FOUND, "${Permission.COLLECTION}.not_found")
	}

	suspend fun from(input: PatchPermissionInput): Permission {
		val doc = template.findById<Permission>(input.id) ?: throw CustomException(
			ErrorType.NOT_FOUND, "${Permission.COLLECTION}.not_found"
		)

		return doc.copy(
			name = input.name ?: doc.name, description = input.description ?: doc.description
		)
	}
}
