package auth.repositories

import auth.models.Group
import org.springframework.data.mongodb.repository.MongoRepository

interface GroupRepository : MongoRepository<Group, String>