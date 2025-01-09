package com.aermakova.corgstore.data.mapper

import com.aermakova.corgstore.data.remote.model.ProductOutput
import com.aermakova.corgstore.domain.model.Product

fun ProductOutput.toProduct(): Product = Product(
    id = id,
    title = name,
    category = typeName,
//    description = description,
    image = image,
    contextualImageUrl = contextualImageUrl,
    price = price.currentPrice
)

//fun CategoryOutput.toCategory() = Category(
//    id = id,
//    name = name,
//    image = image
//)
