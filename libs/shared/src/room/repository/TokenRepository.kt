package room.repository

import room.SharedDatabase
import room.interfaces.ITokenRepository
import room.model.Token
import kotlinx.coroutines.flow.first

class TokenRepository(val database: SharedDatabase): ITokenRepository {
    val dao
        get() = database.tokenDao()

    override suspend fun delete(token: Token) = dao.delete(token)
    override suspend fun deleteAll() = dao.deleteAll()
    override suspend fun insert(token: Token) = dao.insert(token)
    override suspend fun update(token: Token) = dao.update(token)
    override suspend fun findById(id: Int) = dao.findById(id).first()
    override suspend fun findAll() = dao.findAll().first().orEmpty()
}