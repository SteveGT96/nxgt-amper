package auth.services

import auth.dtos.*
import auth.interfaces.IPermissionService
import auth.mappers.PermissionMapper
import auth.entities.Permission
import auth.repositories.PermissionRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.stereotype.Service

@Service
class PermissionService(
	private val repository: PermissionRepository,
	private val template: MongoTemplate,
	private val mapper: PermissionMapper
) : IPermissionService {

	override suspend fun findAll(): List<Permission> {
		return repository.findAll().toList()
	}

	override suspend fun findById(id: String): Permission {
		return template.findById(id) ?: throw NotFoundException()
	}

	override suspend fun create(input: CreatePermissionInput): Permission {
		return template.save(mapper.from(input))
	}

	override suspend fun update(input: UpdatePermissionInput): Permission {
		return template.save(mapper.from(input))
	}

	override suspend fun patch(input: PatchPermissionInput): Permission {
		return template.save(mapper.from(input))
	}

	override suspend fun deleteById(id: String): Permission {
		val entity = findById(id)
		return template.remove(entity).let { entity }
	}
}