package repositories

import models.Group
import org.springframework.data.mongodb.repository.MongoRepository

interface GroupRepository : MongoRepository<Group, String>