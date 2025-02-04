package com.aermakova.corgstore.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aermakova.corgstore.data.local.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProducts(products: List<ProductEntity>)

    @Query("SELECT * FROM products")
    suspend fun getAllProduct(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :productId")
    suspend fun getProductById(productId: String): ProductEntity
}