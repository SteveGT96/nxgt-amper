package auth.interfaces

import auth.dtos.*
import auth.entities.Group

interface IGroupService {
	suspend fun findAll(): List<Group>

	suspend fun findById(id: String): Group

	suspend fun create(input: CreateGroupInput): Group

	suspend fun update(input: UpdateGroupInput): Group

	suspend fun patch(input: PatchGroupInput): Group

	suspend fun deleteById(id: String): Group
}