package com.aermakova.corgstore.di

import android.app.Application
import androidx.room.Room
import com.aermakova.corgstore.data.local.AppDatabase
import com.aermakova.corgstore.data.local.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room
            .databaseBuilder(app, AppDatabase::class.java, "corg-store-app-db")
            .build()

    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase): ProductDao = db.productDao()
}