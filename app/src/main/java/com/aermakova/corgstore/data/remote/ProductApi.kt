package com.aermakova.corgstore.data.remote

import com.aermakova.corgstore.data.remote.model.ProductOutput
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET(PRODUCTS_PATH)
    suspend fun getProducts(
        @Query("keyword") keyword: String = DEFAULT_KEYWORD
    ) : List<ProductOutput>

    @GET(PRODUCT_PATH)
    suspend fun getProduct(
    ) : List<ProductOutput>

    suspend fun getCategories()

    companion object {
//        const val CATEGORIES_PATH =  "categories"
        const val PRODUCTS_PATH = "keywordSearch"
        const val PRODUCT_PATH = "product?productID=90533485"
    }
}

const val DEFAULT_KEYWORD = "all"
