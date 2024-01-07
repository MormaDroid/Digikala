package mohsen.morma.digikala.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [CartEntity::class], exportSchema = false)
abstract class DigikalaDatabase : RoomDatabase() {
    abstract fun cartDao() : CartDao
}