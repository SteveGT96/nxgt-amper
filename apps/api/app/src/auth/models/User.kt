package auth.models

import shared.types.AuditMetadata
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.*

@TypeAlias("User")
@Document(User.COLLECTION)
data class User(
	var id: String? = null,
	@Indexed(unique = true) val username: String,
	val password: String,
	@Indexed(unique = true) val email: String,
	val avatar: String? = null,
	@DocumentReference(lazy = true, lookup = "{ 'name' : ?#{#target} }") val roles: Set<Role> = setOf(),
	@DocumentReference(lazy = true, lookup = "{ 'name' : ?#{#target} }") val permissions: Set<Permission> = setOf(),
	val locked: Boolean = false,
	val disabled: Boolean = false,
	@Unwrapped(onEmpty = Unwrapped.OnEmpty.USE_NULL) val metadata: AuditMetadata = AuditMetadata(),
) {
	companion object {
		const val COLLECTION = "users"
	}
}