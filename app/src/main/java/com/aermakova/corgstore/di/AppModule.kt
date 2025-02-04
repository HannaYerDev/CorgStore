package com.aermakova.corgstore.di

import com.aermakova.corgstore.data.local.ProductDao
import com.aermakova.corgstore.data.remote.ProductApi
import com.aermakova.corgstore.data.repository.ProductsRepository
import com.aermakova.corgstore.domain.repo.ProductsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideProductRepo(
        productApi: ProductApi,
        productDao: ProductDao
    ): ProductsRepo = ProductsRepository(productApi, productDao)
}