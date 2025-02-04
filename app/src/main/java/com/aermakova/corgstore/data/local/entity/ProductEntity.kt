package com.aermakova.corgstore.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val price: String,
    val measurement: String,
    val typeName: String,
    val image: String,
    val contextualImageUrl: String? = null
)
