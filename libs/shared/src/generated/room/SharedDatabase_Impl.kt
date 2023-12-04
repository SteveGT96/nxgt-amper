package room

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.room.RoomOpenHelper
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import java.lang.Class
import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import javax.`annotation`.processing.Generated
import kotlin.Any
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.Set
import room.dao.TokenDao
import room.dao.TokenDao_Impl
import room.dao.UserDao
import room.dao.UserDao_Impl

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION"])
public class SharedDatabase_Impl : SharedDatabase() {
  private val _userDao: Lazy<UserDao> = lazy {
    UserDao_Impl(this)
  }


  private val _tokenDao: Lazy<TokenDao> = lazy {
    TokenDao_Impl(this)
  }


  protected override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
    val _openCallback: SupportSQLiteOpenHelper.Callback = RoomOpenHelper(config, object :
        RoomOpenHelper.Delegate(1) {
      public override fun createAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER NOT NULL, `username` TEXT NOT NULL, `email` TEXT NOT NULL, PRIMARY KEY(`id`))")
        db.execSQL("CREATE TABLE IF NOT EXISTS `tokens` (`username` TEXT NOT NULL, `access` TEXT NOT NULL, `refresh` TEXT NOT NULL, `expires_at` TEXT NOT NULL, `issued_at` TEXT, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7a54192a87c7d96853cfc931e683414b')")
      }

      public override fun dropAllTables(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE IF EXISTS `users`")
        db.execSQL("DROP TABLE IF EXISTS `tokens`")
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onDestructiveMigration(db)
          }
        }
      }

      public override fun onCreate(db: SupportSQLiteDatabase) {
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onCreate(db)
          }
        }
      }

      public override fun onOpen(db: SupportSQLiteDatabase) {
        mDatabase = db
        internalInitInvalidationTracker(db)
        val _callbacks: List<RoomDatabase.Callback>? = mCallbacks
        if (_callbacks != null) {
          for (_callback: RoomDatabase.Callback in _callbacks) {
            _callback.onOpen(db)
          }
        }
      }

      public override fun onPreMigrate(db: SupportSQLiteDatabase) {
        dropFtsSyncTriggers(db)
      }

      public override fun onPostMigrate(db: SupportSQLiteDatabase) {
      }

      public override fun onValidateSchema(db: SupportSQLiteDatabase):
          RoomOpenHelper.ValidationResult {
        val _columnsUsers: HashMap<String, TableInfo.Column> = HashMap<String, TableInfo.Column>(3)
        _columnsUsers.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUsers.put("username", TableInfo.Column("username", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUsers.put("email", TableInfo.Column("email", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysUsers: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesUsers: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoUsers: TableInfo = TableInfo("users", _columnsUsers, _foreignKeysUsers,
            _indicesUsers)
        val _existingUsers: TableInfo = read(db, "users")
        if (!_infoUsers.equals(_existingUsers)) {
          return RoomOpenHelper.ValidationResult(false, """
              |users(room.model.User).
              | Expected:
              |""".trimMargin() + _infoUsers + """
              |
              | Found:
              |""".trimMargin() + _existingUsers)
        }
        val _columnsTokens: HashMap<String, TableInfo.Column> = HashMap<String, TableInfo.Column>(6)
        _columnsTokens.put("username", TableInfo.Column("username", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTokens.put("access", TableInfo.Column("access", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTokens.put("refresh", TableInfo.Column("refresh", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTokens.put("expires_at", TableInfo.Column("expires_at", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTokens.put("issued_at", TableInfo.Column("issued_at", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsTokens.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysTokens: HashSet<TableInfo.ForeignKey> = HashSet<TableInfo.ForeignKey>(0)
        val _indicesTokens: HashSet<TableInfo.Index> = HashSet<TableInfo.Index>(0)
        val _infoTokens: TableInfo = TableInfo("tokens", _columnsTokens, _foreignKeysTokens,
            _indicesTokens)
        val _existingTokens: TableInfo = read(db, "tokens")
        if (!_infoTokens.equals(_existingTokens)) {
          return RoomOpenHelper.ValidationResult(false, """
              |tokens(room.model.Token).
              | Expected:
              |""".trimMargin() + _infoTokens + """
              |
              | Found:
              |""".trimMargin() + _existingTokens)
        }
        return RoomOpenHelper.ValidationResult(true, null)
      }
    }, "7a54192a87c7d96853cfc931e683414b", "ea867ddfe4bcf196f9c0282ecfd1b269")
    val _sqliteConfig: SupportSQLiteOpenHelper.Configuration =
        SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build()
    val _helper: SupportSQLiteOpenHelper = config.sqliteOpenHelperFactory.create(_sqliteConfig)
    return _helper
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: HashMap<String, String> = HashMap<String, String>(0)
    val _viewTables: HashMap<String, Set<String>> = HashMap<String, Set<String>>(0)
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","tokens")
  }

  public override fun clearAllTables() {
    super.assertNotMainThread()
    val _db: SupportSQLiteDatabase = super.openHelper.writableDatabase
    try {
      super.beginTransaction()
      _db.execSQL("DELETE FROM `users`")
      _db.execSQL("DELETE FROM `tokens`")
      super.setTransactionSuccessful()
    } finally {
      super.endTransaction()
      _db.query("PRAGMA wal_checkpoint(FULL)").close()
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM")
      }
    }
  }

  protected override fun getRequiredTypeConverters(): Map<Class<out Any>, List<Class<out Any>>> {
    val _typeConvertersMap: HashMap<Class<out Any>, List<Class<out Any>>> =
        HashMap<Class<out Any>, List<Class<out Any>>>()
    _typeConvertersMap.put(UserDao::class.java, UserDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(TokenDao::class.java, TokenDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecs(): Set<Class<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: HashSet<Class<out AutoMigrationSpec>> =
        HashSet<Class<out AutoMigrationSpec>>()
    return _autoMigrationSpecsSet
  }

  public override
      fun getAutoMigrations(autoMigrationSpecs: Map<Class<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = ArrayList<Migration>()
    return _autoMigrations
  }

  public override fun user(): UserDao = _userDao.value

  public override fun tokenDao(): TokenDao = _tokenDao.value
}
