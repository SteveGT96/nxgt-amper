package auth.models

import shared.types.AuditMetadata
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.*

@TypeAlias("Role")
@Document(Role.COLLECTION)
data class Role(
	var id: String? = null,
	val name: String,
	val description: String? = null,
	@DocumentReference(lazy = true, lookup = "{ 'name' : ?#{#target} }") val permissions: Set<Permission> = setOf(),
	@Unwrapped(onEmpty = Unwrapped.OnEmpty.USE_NULL) val metadata: AuditMetadata = AuditMetadata(),
) {
	companion object {
		const val COLLECTION = "roles"
	}
}