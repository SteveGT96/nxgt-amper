package models

import types.AuditMetadata
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.data.mongodb.core.mapping.Unwrapped

@TypeAlias("Group")
@Document(Group.COLLECTION)
data class Group(
	var id: String? = null,
	val name: String,
	val description: String? = null,
	@DocumentReference(lazy = true, lookup = "{ 'username' : ?#{#target} }") val users: Set<User> = setOf(),
	@DocumentReference(lazy = true, lookup = "{ 'name' : ?#{#target} }") val roles: Set<Role> = setOf(),
	@DocumentReference(lazy = true, lookup = "{ 'name' : ?#{#target} }") val permissions: Set<Permission> = setOf(),
	@Unwrapped(onEmpty = Unwrapped.OnEmpty.USE_NULL) val metadata: AuditMetadata = AuditMetadata(),
) {
	companion object {
		const val COLLECTION = "groups"
	}
}