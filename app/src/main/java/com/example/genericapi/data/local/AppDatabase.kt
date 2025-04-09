package com.example.genericapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ApiResponseEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun apiResponseDao(): ApiResponseDao
}
