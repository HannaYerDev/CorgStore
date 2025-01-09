package com.aermakova.corgstore.ui.home.model

data class ProductUIModel(
    val id: String,
    val title: String,
//    val description: String?,
    val image: String?,
    val contextualImageUrl: String?,
    val price: Double?,
)
