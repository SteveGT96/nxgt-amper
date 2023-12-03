package room.interfaces

import room.model.Token
import kotlinx.coroutines.flow.Flow

interface ITokenRepository {
    suspend fun delete(token: Token)
    suspend fun deleteAll()
    suspend fun insert(token: Token)
    suspend fun update(token: Token)
    suspend fun findById(id: Int): Token?
    suspend fun findAll(): List<Token>
}