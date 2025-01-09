package com.aermakova.corgstore.domain.model

data class Product(
    val id: String,
    val title: String,
    val category: String,
//    val description: String?,
    val image: String,
    val contextualImageUrl: String?,
    val price: Double?,
)
