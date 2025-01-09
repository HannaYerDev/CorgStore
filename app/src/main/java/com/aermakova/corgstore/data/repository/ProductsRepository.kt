package com.aermakova.corgstore.data.repository

import com.aermakova.corgstore.data.remote.ProductApi
import com.aermakova.corgstore.data.mapper.toProduct
import com.aermakova.corgstore.data.remote.DEFAULT_KEYWORD
import com.aermakova.corgstore.domain.model.Filter
import com.aermakova.corgstore.domain.model.Product
import com.aermakova.corgstore.domain.repo.ProductsRepo
import javax.inject.Inject


class ProductsRepository @Inject constructor(
    private val productApi: ProductApi
) : ProductsRepo {

    override suspend fun getProduct() = productApi.getProduct().first().toProduct()

    override suspend fun getProducts(filter: Filter?): List<Product> {
        return productApi.getProducts(filter?.keyword?: DEFAULT_KEYWORD).map { it.toProduct() }
    }
}
