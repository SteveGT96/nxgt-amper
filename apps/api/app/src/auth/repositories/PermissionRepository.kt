package auth.repositories

import auth.models.Permission
import org.springframework.data.mongodb.repository.MongoRepository

interface PermissionRepository : MongoRepository<Permission, String>