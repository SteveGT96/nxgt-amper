package auth.services

import auth.dto.*
import auth.interfaces.IGroupService
import auth.mappers.GroupMapper
import auth.models.Group
import auth.repositories.GroupRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.stereotype.Service

@Service
class GroupService(
	private val repository: GroupRepository, private val template: MongoTemplate, private val mapper: GroupMapper
) : IGroupService {

	override suspend fun findAll(): List<Group> {
		return repository.findAll().toList()
	}

	override suspend fun findById(id: String): Group {
		return template.findById(id) ?: throw NotFoundException()
	}

	override suspend fun create(input: CreateGroupInput): Group {
		return template.save(mapper.from(input))
	}

	override suspend fun update(input: UpdateGroupInput): Group {
		return template.save(mapper.from(input))
	}

	override suspend fun patch(input: PatchGroupInput): Group {
		return template.save(mapper.from(input))
	}

	override suspend fun deleteById(id: String): Group {
		val entity = findById(id)
		return template.remove(entity).let { entity }
	}
}