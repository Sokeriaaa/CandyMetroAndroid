package io.candytechmc.candymetro.appdata.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.candytechmc.candymetro.appdata.db.dao.LineDao
import io.candytechmc.candymetro.appdata.db.dao.StationDao
import io.candytechmc.candymetro.appdata.db.table.LineEntity
import io.candytechmc.candymetro.appdata.db.table.StationEntity

@Database(
    entities = [
        LineEntity::class,
        StationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getLineDao(): LineDao
    abstract fun getStationDao(): StationDao

    companion object {

        fun provideDatabase(context: Context): AppDatabase {
            // TODO fallback migration
            return Room.databaseBuilder(
                context = context,
                klass = AppDatabase::class.java,
                name = "cm_db"
            ).fallbackToDestructiveMigration().build()
        }

    }

}