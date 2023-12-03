package room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import room.model.Token
import kotlinx.coroutines.flow.Flow

@Dao
interface TokenDao {
    @Delete
    suspend fun delete(token: Token)
    @Query("DELETE from tokens")
    suspend fun deleteAll()
    @Insert
    suspend fun insert(token: Token)
    @Update
    suspend fun update(token: Token)
    @Query("SELECT * from tokens WHERE id = :id LIMIT 1")
    fun findById(id: Int): Flow<Token?>
    @Query("SELECT * from tokens")
    fun findAll(): Flow<List<Token>?>
}