package auth.helpers

import auth.models.*
import shared.helpers.`is`
import shared.helpers.query
import kotlinx.coroutines.delay
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import java.time.Instant

fun User.loadPermissions(template: MongoTemplate): Set<Permission> {
	val groups = template.find<Group>((Group::users `is` username).query)
	return groups.flatMap { it.roles }.flatMap { it.permissions }.plus(roles.flatMap { it.permissions })
		.plus(permissions).distinctBy { it.id }.toSet()
}

fun User.loadRoles(template: MongoTemplate): Set<Role> {
	val groups = template.find<Group>((Group::users `is` username).query)
	return groups.flatMap { it.roles }.plus(roles).distinctBy { it.id }.toSet()
}

fun User.loadGroups(template: MongoTemplate): Set<Group> {
	return template.find<Group>((Group::users `is` username).query).toSet()
}

@Component
class UserDataSource(val ds: StringRedisTemplate, private val template: MongoTemplate) {
	suspend fun loadAuthorities(user: User, expiration: Instant) {
		with(user) {
			mapOf(username.groupsKey to loadGroups(template).map { it.name },
				username.rolesKey to loadRoles(template).map { it.name },
				username.permissionsKey to loadPermissions(template).map { it.name }).filter { it.value.isNotEmpty() }
				.forEach { (key, value) ->
					ds.removeKeys(key)
					delay(1)
					ds.boundSetOps(key).add(*value.toTypedArray())
					ds.expireAt(key, expiration)
				}
		}
	}

	suspend fun loadTokens(token: Token) {
		with(token) {
			mapOf(
				username.accessTokenKey to token.access, username.refreshTokenKey to refresh
			).forEach { (key, value) ->
				ds.boundValueOps(key).set(value)
				ds.boundValueOps(key).expireAt(token.expiration)
			}
		}
	}
}

val String.rolesKey
	get() = "users:${this}:roles"
val String.groupsKey
	get() = "users:${this}:groups"
val String.permissionsKey
	get() = "users:${this}:permissions"
val String.accessTokenKey
	get() = "tokens:${this}:access"
val String.refreshTokenKey
	get() = "tokens:${this}:refresh"