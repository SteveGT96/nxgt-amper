package auth.models

import shared.types.AuditMetadata
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Unwrapped

@TypeAlias("Permission")
@Document(Permission.COLLECTION)
data class Permission(
	var id: String? = null,
	@Indexed(unique = true) val name: String,
	val description: String? = null,
	@Unwrapped(onEmpty = Unwrapped.OnEmpty.USE_NULL) val metadata: AuditMetadata = AuditMetadata(),
) {
	companion object {
		const val COLLECTION = "permissions"
	}
}