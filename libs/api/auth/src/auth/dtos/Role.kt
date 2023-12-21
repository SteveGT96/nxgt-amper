package auth.dtos

import shared.helpers.Regexp
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.UniqueElements

data class CreateRoleInput(
	@field:Pattern(regexp = Regexp.ROLE_NAME) val name: String, val description: String?, val permissions: Set<String>?
)

data class UpdateRoleInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.ROLE_NAME) val name: String,
	val description: String?,
	@field:UniqueElements val permissions: Set<String>?
)

data class PatchRoleInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.ROLE_NAME) val name: String?,
	val description: String?,
	@field:UniqueElements val permissions: Set<String>?
)
