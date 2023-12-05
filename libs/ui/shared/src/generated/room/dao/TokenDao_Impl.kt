package room.dao

import android.database.Cursor
import androidx.room.CoroutinesRoom
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.EntityInsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.SharedSQLiteStatement
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import java.lang.Class
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import room.model.Token

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class TokenDao_Impl(
  __db: RoomDatabase,
) : TokenDao {
  private val __db: RoomDatabase

  private val __insertionAdapterOfToken: EntityInsertionAdapter<Token>

  private val __deletionAdapterOfToken: EntityDeletionOrUpdateAdapter<Token>

  private val __updateAdapterOfToken: EntityDeletionOrUpdateAdapter<Token>

  private val __preparedStmtOfDeleteAll: SharedSQLiteStatement
  init {
    this.__db = __db
    this.__insertionAdapterOfToken = object : EntityInsertionAdapter<Token>(__db) {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `tokens` (`username`,`access`,`refresh`,`expires_at`,`issued_at`,`id`) VALUES (?,?,?,?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Token) {
        statement.bindString(1, entity.username)
        statement.bindString(2, entity.access)
        statement.bindString(3, entity.refresh)
        statement.bindString(4, entity.expiresAt)
        val _tmpIssuedAt: String? = entity.issuedAt
        if (_tmpIssuedAt == null) {
          statement.bindNull(5)
        } else {
          statement.bindString(5, _tmpIssuedAt)
        }
        statement.bindLong(6, entity.id.toLong())
      }
    }
    this.__deletionAdapterOfToken = object : EntityDeletionOrUpdateAdapter<Token>(__db) {
      protected override fun createQuery(): String = "DELETE FROM `tokens` WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Token) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
    this.__updateAdapterOfToken = object : EntityDeletionOrUpdateAdapter<Token>(__db) {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `tokens` SET `username` = ?,`access` = ?,`refresh` = ?,`expires_at` = ?,`issued_at` = ?,`id` = ? WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: Token) {
        statement.bindString(1, entity.username)
        statement.bindString(2, entity.access)
        statement.bindString(3, entity.refresh)
        statement.bindString(4, entity.expiresAt)
        val _tmpIssuedAt: String? = entity.issuedAt
        if (_tmpIssuedAt == null) {
          statement.bindNull(5)
        } else {
          statement.bindString(5, _tmpIssuedAt)
        }
        statement.bindLong(6, entity.id.toLong())
        statement.bindLong(7, entity.id.toLong())
      }
    }
    this.__preparedStmtOfDeleteAll = object : SharedSQLiteStatement(__db) {
      public override fun createQuery(): String {
        val _query: String = "DELETE from tokens"
        return _query
      }
    }
  }

  public override suspend fun insert(token: Token): Unit = CoroutinesRoom.execute(__db, true, object
      : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __insertionAdapterOfToken.insert(token)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun delete(token: Token): Unit = CoroutinesRoom.execute(__db, true, object
      : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __deletionAdapterOfToken.handle(token)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun update(token: Token): Unit = CoroutinesRoom.execute(__db, true, object
      : Callable<Unit> {
    public override fun call() {
      __db.beginTransaction()
      try {
        __updateAdapterOfToken.handle(token)
        __db.setTransactionSuccessful()
      } finally {
        __db.endTransaction()
      }
    }
  })

  public override suspend fun deleteAll(): Unit = CoroutinesRoom.execute(__db, true, object :
      Callable<Unit> {
    public override fun call() {
      val _stmt: SupportSQLiteStatement = __preparedStmtOfDeleteAll.acquire()
      try {
        __db.beginTransaction()
        try {
          _stmt.executeUpdateDelete()
          __db.setTransactionSuccessful()
        } finally {
          __db.endTransaction()
        }
      } finally {
        __preparedStmtOfDeleteAll.release(_stmt)
      }
    }
  })

  public override fun findById(id: Int): Flow<Token?> {
    val _sql: String = "SELECT * from tokens WHERE id = ? LIMIT 1"
    val _statement: RoomSQLiteQuery = acquire(_sql, 1)
    var _argIndex: Int = 1
    _statement.bindLong(_argIndex, id.toLong())
    return CoroutinesRoom.createFlow(__db, false, arrayOf("tokens"), object : Callable<Token?> {
      public override fun call(): Token? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfUsername: Int = getColumnIndexOrThrow(_cursor, "username")
          val _cursorIndexOfAccess: Int = getColumnIndexOrThrow(_cursor, "access")
          val _cursorIndexOfRefresh: Int = getColumnIndexOrThrow(_cursor, "refresh")
          val _cursorIndexOfExpiresAt: Int = getColumnIndexOrThrow(_cursor, "expires_at")
          val _cursorIndexOfIssuedAt: Int = getColumnIndexOrThrow(_cursor, "issued_at")
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _result: Token?
          if (_cursor.moveToFirst()) {
            val _tmpUsername: String
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername)
            val _tmpAccess: String
            _tmpAccess = _cursor.getString(_cursorIndexOfAccess)
            val _tmpRefresh: String
            _tmpRefresh = _cursor.getString(_cursorIndexOfRefresh)
            val _tmpExpiresAt: String
            _tmpExpiresAt = _cursor.getString(_cursorIndexOfExpiresAt)
            val _tmpIssuedAt: String?
            if (_cursor.isNull(_cursorIndexOfIssuedAt)) {
              _tmpIssuedAt = null
            } else {
              _tmpIssuedAt = _cursor.getString(_cursorIndexOfIssuedAt)
            }
            val _tmpId: Int
            _tmpId = _cursor.getInt(_cursorIndexOfId)
            _result = Token(_tmpUsername,_tmpAccess,_tmpRefresh,_tmpExpiresAt,_tmpIssuedAt,_tmpId)
          } else {
            _result = null
          }
          return _result
        } finally {
          _cursor.close()
        }
      }

      protected fun finalize() {
        _statement.release()
      }
    })
  }

  public override fun findAll(): Flow<List<Token>?> {
    val _sql: String = "SELECT * from tokens"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return CoroutinesRoom.createFlow(__db, false, arrayOf("tokens"), object : Callable<List<Token>?>
        {
      public override fun call(): List<Token>? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfUsername: Int = getColumnIndexOrThrow(_cursor, "username")
          val _cursorIndexOfAccess: Int = getColumnIndexOrThrow(_cursor, "access")
          val _cursorIndexOfRefresh: Int = getColumnIndexOrThrow(_cursor, "refresh")
          val _cursorIndexOfExpiresAt: Int = getColumnIndexOrThrow(_cursor, "expires_at")
          val _cursorIndexOfIssuedAt: Int = getColumnIndexOrThrow(_cursor, "issued_at")
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _result: MutableList<Token> = ArrayList<Token>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item: Token
            val _tmpUsername: String
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername)
            val _tmpAccess: String
            _tmpAccess = _cursor.getString(_cursorIndexOfAccess)
            val _tmpRefresh: String
            _tmpRefresh = _cursor.getString(_cursorIndexOfRefresh)
            val _tmpExpiresAt: String
            _tmpExpiresAt = _cursor.getString(_cursorIndexOfExpiresAt)
            val _tmpIssuedAt: String?
            if (_cursor.isNull(_cursorIndexOfIssuedAt)) {
              _tmpIssuedAt = null
            } else {
              _tmpIssuedAt = _cursor.getString(_cursorIndexOfIssuedAt)
            }
            val _tmpId: Int
            _tmpId = _cursor.getInt(_cursorIndexOfId)
            _item = Token(_tmpUsername,_tmpAccess,_tmpRefresh,_tmpExpiresAt,_tmpIssuedAt,_tmpId)
            _result.add(_item)
          }
          return _result
        } finally {
          _cursor.close()
        }
      }

      protected fun finalize() {
        _statement.release()
      }
    })
  }

  public companion object {
    @JvmStatic
    public fun getRequiredConverters(): List<Class<*>> = emptyList()
  }
}
