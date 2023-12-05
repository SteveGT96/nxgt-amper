package dto

import helpers.Regexp
import jakarta.validation.constraints.Pattern

data class CreateGroupInput(
	@field:Pattern(regexp = Regexp.GROUP_NAME) val name: String,
	val description: String?,
	val users: Set<String>?,
	val roles: Set<String>?,
	val permissions: Set<String>?
)

data class UpdateGroupInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.GROUP_NAME) val name: String,
	val description: String?,
	val users: Set<String>?,
	val roles: Set<String>?,
	val permissions: Set<String>?
)

data class PatchGroupInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.HEXA) val name: String?,
	val description: String?,
	val users: Set<String>?,
	val roles: Set<String>?,
	val permissions: Set<String>?
)
