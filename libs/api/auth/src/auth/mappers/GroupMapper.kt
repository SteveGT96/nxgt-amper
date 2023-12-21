package auth.mappers

import auth.dtos.*
import auth.entities.*
import shared.exceptions.CustomException
import shared.helpers.findByKeyIn
import shared.helpers.patch
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class GroupMapper(private val template: MongoTemplate) {
	suspend fun from(input: CreateGroupInput): Group {
		val users = template.findByKeyIn<User>(User::id.name, input.users.orEmpty()).toSet()
		val roles = template.findByKeyIn<Role>(Role::id.name, input.roles.orEmpty()).toSet()
		val permissions = template.findByKeyIn<Permission>(Permission::id.name, input.permissions.orEmpty()).toSet()
		return Group(
			name = input.name, description = input.description, users = users, roles = roles, permissions = permissions
		)
	}

	suspend fun from(input: UpdateGroupInput): Group {
		val users = template.findByKeyIn<User>(User::id.name, input.users.orEmpty()).toSet()
		val roles = template.findByKeyIn<Role>(Role::id.name, input.roles.orEmpty()).toSet()
		val permissions = template.findByKeyIn<Permission>(Permission::id.name, input.permissions.orEmpty()).toSet()
		return template.findById<Group>(input.id)?.copy(
			name = input.name, description = input.description, users = users, roles = roles, permissions = permissions
		) ?: throw CustomException(ErrorType.NOT_FOUND, "${Group.COLLECTION}.not_found")
	}

	suspend fun from(input: PatchGroupInput): Group {

		val doc = template.findById<Group>(input.id) ?: throw CustomException(
			ErrorType.NOT_FOUND, "${Group.COLLECTION}.not_found"
		)
		val users = input.users?.let {
			template.findByKeyIn<User>(User::id.name, doc.users.mapNotNull { e -> e.id }.patch(it))
		}?.toSet()
		val roles = input.roles?.let {
			template.findByKeyIn<Role>(Role::id.name, doc.roles.mapNotNull { e -> e.id }.patch(it))
		}?.toSet()
		val permissions = input.permissions?.let {
			template.findByKeyIn<Permission>(Permission::id.name, doc.permissions.mapNotNull { e -> e.id }.patch(it))
		}?.toSet()

		return doc.copy(
			name = input.name ?: doc.name,
			description = input.description ?: doc.description,
			users = users ?: doc.users,
			roles = roles ?: doc.roles,
			permissions = permissions ?: doc.permissions
		)
	}
}
