package auth.interfaces

import auth.dto.*
import auth.models.Role

interface IRoleService {

	suspend fun findAll(): List<Role>

	suspend fun findById(id: String): Role

	suspend fun create(input: CreateRoleInput): Role

	suspend fun update(input: UpdateRoleInput): Role

	suspend fun patch(input: PatchRoleInput): Role

	suspend fun deleteById(id: String): Role
}