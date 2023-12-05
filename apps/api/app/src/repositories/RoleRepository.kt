package repositories

import models.Role
import org.springframework.data.mongodb.repository.MongoRepository

interface RoleRepository : MongoRepository<Role, String>