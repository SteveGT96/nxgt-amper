package room.dao

import androidx.room.*
import room.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun findAll(): Flow<List<User>?>

    @Query("SELECT * FROM users WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): Flow<List<User>?>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}