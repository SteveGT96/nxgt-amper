package shared.types

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant
data class AuditMetadata(
	@CreatedBy @Field("created_by") val createdBy: String? = null,
	@LastModifiedBy @Field("last_modified_by") val lastModifiedBy: String? = null,
	@CreatedDate @Field("created_date") val createdDate: Instant? = null,
	@LastModifiedDate @Field("last_modified_date") val lastModifiedDate: Instant? = null,
)
