package auth.interfaces

import auth.dtos.*
import auth.entities.User

interface IUserService {
	suspend fun findAll(): List<User>

	suspend fun findById(id: String): User

	suspend fun create(input: CreateUserInput): User

	suspend fun createAccount(input: CreateAccountInput): User

	suspend fun update(input: UpdateUserInput): User

	suspend fun patch(input: PatchUserInput): User

	suspend fun deleteById(id: String): User
}