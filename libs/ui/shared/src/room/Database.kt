package room

import android.content.Context
import androidx.room.*
import room.dao.TokenDao
import room.dao.UserDao
import room.model.Token
import room.model.User

@Database(
    entities = [User::class, Token::class],
    version = 1,
    exportSchema = false
)
abstract class SharedDatabase : RoomDatabase() {
    abstract fun user(): UserDao
    abstract fun tokenDao(): TokenDao
    companion object {
        @Volatile
        var Instance: SharedDatabase? = null

        fun getDatabase(context: Context): SharedDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, SharedDatabase::class.java, "nxgt_amper")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}