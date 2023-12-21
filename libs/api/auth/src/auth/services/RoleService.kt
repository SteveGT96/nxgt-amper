package auth.services

import auth.dtos.*
import auth.interfaces.IRoleService
import auth.mappers.RoleMapper
import auth.entities.Role
import auth.repositories.RoleRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.stereotype.Service

@Service
class RoleService(
	private val repository: RoleRepository, private val template: MongoTemplate, private val mapper: RoleMapper
) : IRoleService {

	override suspend fun findAll(): List<Role> {
		return repository.findAll().toList()
	}

	override suspend fun findById(id: String): Role {
		return template.findById(id) ?: throw NotFoundException()
	}

	override suspend fun create(input: CreateRoleInput): Role {
		return template.save(mapper.from(input))
	}

	override suspend fun update(input: UpdateRoleInput): Role {
		return template.save(mapper.from(input))
	}

	override suspend fun patch(input: PatchRoleInput): Role {
		return template.save(mapper.from(input))
	}

	override suspend fun deleteById(id: String): Role {
		val entity = findById(id)
		return template.remove(entity).let { entity }
	}
}