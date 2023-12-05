package services

import dto.*
import interfaces.IUserService
import mappers.UserMapper
import models.Group
import models.User
import repositories.UserRepository
import types.CustomUserDetails
import exceptions.CustomException
import helpers.*
import org.springframework.data.mongodb.core.*
import org.springframework.graphql.execution.ErrorType
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
	private val repository: UserRepository, private val template: MongoTemplate, private val mapper: UserMapper
) : IUserService, UserDetailsService {

	override suspend fun findAll(): List<User> {
		return repository.findAll().toList()
	}

	override suspend fun findById(id: String): User {
		return template.findOne(or(User::id `is` id, User::username `is` id, User::email `is` id).query)
			?: throw CustomException(ErrorType.NOT_FOUND, "users.not_found")
	}

	override suspend fun create(input: CreateUserInput): User {
		return template.save(mapper.from(input))
	}

	override suspend fun createAccount(input: CreateAccountInput): User {
		return template.save(
			mapper.from(
				CreateUserInput(
					input.username, input.password, input.email, null, setOf(), setOf(), setOf()
				)
			)
		)
	}

	override suspend fun update(input: UpdateUserInput): User {
		return template.save(mapper.from(input))
	}

	override suspend fun patch(input: PatchUserInput): User {
		return template.save(mapper.from(input))
	}

	override suspend fun deleteById(id: String): User {
		val entity = findById(id)
		return template.remove(entity).let { entity }
	}

	override fun loadUserByUsername(username: String?): UserDetails {
		val user = template.findOne<User>(or(User::username `is` username, User::email `is` username).query)
			?: throw CustomException(ErrorType.NOT_FOUND, "users.not_found")
		val groups = template.find<Group>(or(Group::users `is` user.username, Group::users `is` user.id).query)

		return CustomUserDetails(user, groups.toSet())
	}
}