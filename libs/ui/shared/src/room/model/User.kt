package room.model

import androidx.room.*

@Entity("users")
data class User(
    @PrimaryKey val id: Int,
    val username: String,
    val email: String
)
