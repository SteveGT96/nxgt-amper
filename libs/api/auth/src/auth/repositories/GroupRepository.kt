package auth.repositories

import auth.entities.Group
import org.springframework.data.mongodb.repository.MongoRepository

interface GroupRepository : MongoRepository<Group, String>