package room.dao

import android.database.Cursor
import androidx.room.CoroutinesRoom
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.EntityInsertionAdapter
import androidx.room.RoomDatabase
import androidx.room.RoomSQLiteQuery
import androidx.room.RoomSQLiteQuery.Companion.acquire
import androidx.room.util.appendPlaceholders
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.newStringBuilder
import androidx.room.util.query
import androidx.sqlite.db.SupportSQLiteStatement
import java.lang.Class
import java.lang.StringBuilder
import java.util.ArrayList
import java.util.concurrent.Callable
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.IntArray
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import room.model.User

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class UserDao_Impl(
  __db: RoomDatabase,
) : UserDao {
  private val __db: RoomDatabase

  private val __insertionAdapterOfUser: EntityInsertionAdapter<User>

  private val __deletionAdapterOfUser: EntityDeletionOrUpdateAdapter<User>
  init {
    this.__db = __db
    this.__insertionAdapterOfUser = object : EntityInsertionAdapter<User>(__db) {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `users` (`id`,`username`,`email`) VALUES (?,?,?)"

      protected override fun bind(statement: SupportSQLiteStatement, entity: User) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindString(2, entity.username)
        statement.bindString(3, entity.email)
      }
    }
    this.__deletionAdapterOfUser = object : EntityDeletionOrUpdateAdapter<User>(__db) {
      protected override fun createQuery(): String = "DELETE FROM `users` WHERE `id` = ?"

      protected override fun bind(statement: SupportSQLiteStatement, entity: User) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
  }

  public override fun insertAll(vararg users: User) {
    __db.assertNotSuspendingTransaction()
    __db.beginTransaction()
    try {
      __insertionAdapterOfUser.insert(users)
      __db.setTransactionSuccessful()
    } finally {
      __db.endTransaction()
    }
  }

  public override fun delete(user: User) {
    __db.assertNotSuspendingTransaction()
    __db.beginTransaction()
    try {
      __deletionAdapterOfUser.handle(user)
      __db.setTransactionSuccessful()
    } finally {
      __db.endTransaction()
    }
  }

  public override fun findAll(): Flow<List<User>?> {
    val _sql: String = "SELECT * FROM users"
    val _statement: RoomSQLiteQuery = acquire(_sql, 0)
    return CoroutinesRoom.createFlow(__db, false, arrayOf("users"), object : Callable<List<User>?> {
      public override fun call(): List<User>? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _cursorIndexOfUsername: Int = getColumnIndexOrThrow(_cursor, "username")
          val _cursorIndexOfEmail: Int = getColumnIndexOrThrow(_cursor, "email")
          val _result: MutableList<User> = ArrayList<User>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item: User
            val _tmpId: Int
            _tmpId = _cursor.getInt(_cursorIndexOfId)
            val _tmpUsername: String
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername)
            val _tmpEmail: String
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail)
            _item = User(_tmpId,_tmpUsername,_tmpEmail)
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

  public override fun loadAllByIds(ids: IntArray): Flow<List<User>?> {
    val _stringBuilder: StringBuilder = newStringBuilder()
    _stringBuilder.append("SELECT * FROM users WHERE id IN (")
    val _inputSize: Int = ids.size
    appendPlaceholders(_stringBuilder, _inputSize)
    _stringBuilder.append(")")
    val _sql: String = _stringBuilder.toString()
    val _argCount: Int = 0 + _inputSize
    val _statement: RoomSQLiteQuery = acquire(_sql, _argCount)
    var _argIndex: Int = 1
    for (_item: Int in ids) {
      _statement.bindLong(_argIndex, _item.toLong())
      _argIndex++
    }
    return CoroutinesRoom.createFlow(__db, false, arrayOf("users"), object : Callable<List<User>?> {
      public override fun call(): List<User>? {
        val _cursor: Cursor = query(__db, _statement, false, null)
        try {
          val _cursorIndexOfId: Int = getColumnIndexOrThrow(_cursor, "id")
          val _cursorIndexOfUsername: Int = getColumnIndexOrThrow(_cursor, "username")
          val _cursorIndexOfEmail: Int = getColumnIndexOrThrow(_cursor, "email")
          val _result: MutableList<User> = ArrayList<User>(_cursor.getCount())
          while (_cursor.moveToNext()) {
            val _item_1: User
            val _tmpId: Int
            _tmpId = _cursor.getInt(_cursorIndexOfId)
            val _tmpUsername: String
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername)
            val _tmpEmail: String
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail)
            _item_1 = User(_tmpId,_tmpUsername,_tmpEmail)
            _result.add(_item_1)
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
