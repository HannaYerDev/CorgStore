package com.aermakova.corgstore.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductOutput(
    val id: String,
    val name: String,
    val price: Price,
    val availability: Availability?= null,
    val measurement: String,
    val typeName: String,
    val image: String,
    val contextualImageUrl: String? = null,
    val imageAlt: String,
    val url: String,
    val categoryPath: List<Category>
)

@Serializable
data class Price(
    val currency: String,
    val currentPrice: Double,
    val discounted: Boolean
)

@Serializable
data class Availability(
    val status: String,
    val store: String
)

@Serializable
data class Category(
    val name: String,
    val key: String
)