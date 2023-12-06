package auth.dto

import shared.helpers.Regexp
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern

data class CreateUserInput(
	@field:Pattern(regexp = Regexp.USERNAME) val username: String,
	@field:Pattern(regexp = Regexp.PASSWORD) val password: String,
	@field:Email val email: String,
	val avatar: String?,
	val groups: Set<String>?,
	val roles: Set<String>?,
	val permissions: Set<String>?
)

data class UpdateUserInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.USERNAME) val username: String,
	@field:Pattern(regexp = Regexp.PASSWORD) val password: String,
	@field:Email val email: String,
	val avatar: String?,
	val groups: Set<String>?,
	val roles: Set<String>?,
	val permissions: Set<String>?
)

data class CreateAccountInput(
	@field:Pattern(regexp = Regexp.USERNAME) val username: String,
	@field:Pattern(regexp = Regexp.PASSWORD) val password: String,
	@field:Email val email: String,
)

data class PatchUserInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.USERNAME) val username: String?,
	@field:Pattern(regexp = Regexp.PASSWORD) val password: String?,
	@field:Email val email: String?,
	val avatar: String?,
	val groups: Set<String>?,
	val roles: Set<String>?,
	val permissions: Set<String>?
)
