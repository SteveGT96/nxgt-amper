package auth.repositories

import auth.entities.Permission
import org.springframework.data.mongodb.repository.MongoRepository

interface PermissionRepository : MongoRepository<Permission, String>