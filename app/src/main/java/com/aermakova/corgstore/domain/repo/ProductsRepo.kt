package com.aermakova.corgstore.domain.repo

import com.aermakova.corgstore.domain.model.Filter
import com.aermakova.corgstore.domain.model.Product

interface ProductsRepo {

    suspend fun getProduct(): Product

    suspend fun getProducts(filter: Filter? = null): List<Product>
}