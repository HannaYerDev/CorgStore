package com.aermakova.corgstore.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aermakova.corgstore.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<ProductEntity>

    @Query("SELECT * FROM products")
    fun observeProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE typeName LIKE '%' || :category || '%'")
    suspend fun getProductsByCategory(category: String): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :productId")
    suspend fun getProductById(productId: String): ProductEntity?
}