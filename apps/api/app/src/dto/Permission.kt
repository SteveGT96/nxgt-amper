package dto

import helpers.Regexp
import jakarta.validation.constraints.Pattern

data class CreatePermissionInput(
	@field:Pattern(regexp = Regexp.PERMISSION_NAME) val name: String,
	val description: String?,
)

data class UpdatePermissionInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.PERMISSION_NAME) val name: String,
	val description: String?,
)

data class PatchPermissionInput(
	@field:Pattern(regexp = Regexp.HEXA) val id: String,
	@field:Pattern(regexp = Regexp.PERMISSION_NAME) val name: String?,
	val description: String?,
)
