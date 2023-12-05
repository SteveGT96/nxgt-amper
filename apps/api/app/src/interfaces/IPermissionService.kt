package interfaces

import dto.*
import models.Permission

interface IPermissionService {

	suspend fun findAll(): List<Permission>

	suspend fun findById(id: String): Permission

	suspend fun create(input: CreatePermissionInput): Permission

	suspend fun update(input: UpdatePermissionInput): Permission

	suspend fun patch(input: PatchPermissionInput): Permission

	suspend fun deleteById(id: String): Permission
}