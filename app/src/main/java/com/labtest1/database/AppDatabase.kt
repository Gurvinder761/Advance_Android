package com.labtest1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.labtest1.database.converters.Converters
import com.labtest1.database.dao.DataDAO
import com.labtest1.database.entities.LocationData

@Database(entities = [LocationData::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDAO

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "FinalAssignment"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as AppDatabase
        }

    }

}