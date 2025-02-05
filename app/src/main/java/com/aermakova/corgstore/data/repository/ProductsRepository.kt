package com.aermakova.corgstore.data.repository

import com.aermakova.corgstore.data.local.ProductDao
import com.aermakova.corgstore.data.mapper.toEntity
import com.aermakova.corgstore.data.mapper.toProduct
import com.aermakova.corgstore.data.remote.DEFAULT_KEYWORD
import com.aermakova.corgstore.data.remote.ProductApi
import com.aermakova.corgstore.domain.model.Product
import com.aermakova.corgstore.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val productApi: ProductApi,
    private val productDao: ProductDao
) : ProductsRepo {

    override suspend fun getProductById(productIt: String) =
        productDao.getProductById(productIt)?.toProduct()

    override fun observeProducts(): Flow<List<Product>> {
        return productDao.observeProducts().map { it.map { it.toProduct() } }
    }

    override suspend fun fetchProducts() {
        if (productDao.getAllProducts().size < 20) {
            productDao.apply {
                try {
                    insertProducts(productApi.getProducts(DEFAULT_KEYWORD).map { it.toEntity(null) })
                } catch (e: Exception){
                    println("Exception: ${e.message}")
                }
            }
        }
    }

     override suspend fun fetchProductsByCategory(filter: String) {
        if (productDao.getProductsByCategory(filter).size < 20) {
            productDao.apply {
                try {
                    insertProducts(productApi.getProducts(filter).map { it.toEntity(filter) })
                } catch (e: Exception){
                    println("Exception: ${e.message}")
                }
            }
        }
    }
}
