package room.model

import androidx.room.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.isDistantPast
import kotlin.time.Duration

@Entity("tokens")
data class Token(
    val username: String,
    val access: String,
    val refresh: String,
    @ColumnInfo("expires_at") val expiresAt: String,
    @ColumnInfo("issued_at") val issuedAt: String? = null,
    @PrimaryKey
    val id: Int = 0
) {
    companion object {
    }
}

fun Token.isExpired() = Instant.parse(expiresAt).minus(Duration.parse("30s")) < Clock.System.now()