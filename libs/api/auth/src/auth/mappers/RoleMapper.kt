package auth.mappers

import auth.dtos.*
import auth.entities.Permission
import auth.entities.Role
import shared.exceptions.CustomException
import shared.helpers.findByKeyIn
import shared.helpers.patch
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class RoleMapper(private val template: MongoTemplate) {
	suspend fun from(input: CreateRoleInput): Role {
		val permissions = template.findByKeyIn<Permission>(Permission::id.name, input.permissions.orEmpty()).toSet()
		return Role(name = input.name, description = input.description, permissions = permissions)
	}

	suspend fun from(input: UpdateRoleInput): Role {
		val permissions = template.findByKeyIn<Permission>(Permission::id.name, input.permissions.orEmpty()).toSet()
		return template.findById<Role>(input.id)
			?.copy(name = input.name, description = input.description, permissions = permissions)
			?: throw CustomException(ErrorType.NOT_FOUND, "${Role.COLLECTION}.not_found")
	}

	suspend fun from(input: PatchRoleInput): Role {
		val doc = template.findById<Role>(input.id) ?: throw CustomException(
			ErrorType.NOT_FOUND, "${Role.COLLECTION}.not_found"
		)
		val permissions = input.permissions?.let {
			template.findByKeyIn<Permission>(Permission::id.name, doc.permissions.mapNotNull { e -> e.id }.patch(it))
		}?.toSet()

		return doc.copy(
			name = input.name ?: doc.name,
			description = input.description ?: doc.description,
			permissions = permissions ?: doc.permissions
		)
	}
}
