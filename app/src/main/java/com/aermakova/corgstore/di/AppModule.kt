package com.aermakova.corgstore.di

import android.content.Context
import android.content.SharedPreferences
import com.aermakova.corgstore.data.local.ProductDao
import com.aermakova.corgstore.data.local.UserSettingsRepo
import com.aermakova.corgstore.data.remote.ProductApi
import com.aermakova.corgstore.data.repository.ProductsRepository
import com.aermakova.corgstore.data.repository.UserSettingsRepository
import com.aermakova.corgstore.domain.repo.ProductsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context,
    ): SharedPreferences = context.getSharedPreferences("corg_store_prefs", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideProductRepo(
        productApi: ProductApi,
        productDao: ProductDao
    ): ProductsRepo = ProductsRepository(productApi, productDao)

    @Provides
    @Singleton
    fun provideUserSettings(
        preferences: SharedPreferences
    ): UserSettingsRepo = UserSettingsRepository(preferences)
}