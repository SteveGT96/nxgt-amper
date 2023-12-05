package repositories

import models.Permission
import org.springframework.data.mongodb.repository.MongoRepository

interface PermissionRepository : MongoRepository<Permission, String>