package com.aermakova.corgstore.domain.repo

import com.aermakova.corgstore.domain.model.Filter
import com.aermakova.corgstore.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepo {

    suspend fun getProductById(productIt: String): Product?

    suspend fun fetchProducts()

    suspend fun fetchProductsByCategory(filter: String)

    fun observeProducts(): Flow<List<Product>>
}