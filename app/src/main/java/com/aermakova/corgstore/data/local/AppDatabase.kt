package com.aermakova.corgstore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aermakova.corgstore.data.local.entity.ProductEntity

@Database(
    version = 1,
    entities = [
        ProductEntity::class,
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}