package auth.mappers

import auth.dtos.*
import auth.entities.*
import shared.exceptions.CustomException
import shared.helpers.findByKeyIn
import shared.helpers.patch
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.graphql.execution.ErrorType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(private val template: MongoTemplate, private val passwordEncoder: BCryptPasswordEncoder) {
	suspend fun from(input: CreateUserInput): User {
		val roles = template.findByKeyIn<Role>(Role::id.name, input.roles.orEmpty()).toSet()
		val permissions = template.findByKeyIn<Permission>(Permission::id.name, input.permissions.orEmpty()).toSet()
		return User(
			username = input.username,
			email = input.email,
			password = passwordEncoder.encode(input.password),
			avatar = input.avatar,
			roles = roles,
			permissions = permissions
		)
	}

	suspend fun from(input: UpdateUserInput): User {
		val roles = template.findByKeyIn<Role>(Role::id.name, input.roles.orEmpty()).toSet()
		val permissions = template.findByKeyIn<Permission>(Permission::id.name, input.permissions.orEmpty()).toSet()
		return template.findById<User>(input.id)?.copy(
			username = input.username,
			email = input.email,
			password = passwordEncoder.encode(input.password),
			avatar = input.avatar,
			roles = roles,
			permissions = permissions
		) ?: throw CustomException(ErrorType.NOT_FOUND, "${User.COLLECTION}.not_found")
	}

	suspend fun from(input: PatchUserInput): User {
		val doc = template.findById<User>(input.id) ?: throw CustomException(
			ErrorType.NOT_FOUND, "${User.COLLECTION}.not_found"
		)
		val roles = input.roles?.let {
			template.findByKeyIn<Role>(Role::id.name, doc.roles.mapNotNull { e -> e.id }.patch(it))
		}?.toSet()
		val permissions = input.permissions?.let {
			template.findByKeyIn<Permission>(Permission::id.name, doc.permissions.mapNotNull { e -> e.id }.patch(it))
		}?.toSet()

		return doc.copy(username = input.username ?: doc.username,
			email = input.email ?: doc.email,
			password = input.password?.let { passwordEncoder.encode(it) } ?: doc.password,
			avatar = input.avatar ?: doc.avatar,
			roles = roles ?: doc.roles,
			permissions = permissions ?: doc.permissions)
	}
}
