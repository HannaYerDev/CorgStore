package com.aermakova.corgstore.data.mapper

import com.aermakova.corgstore.data.remote.model.ProductOutput
import com.aermakova.corgstore.domain.model.Product

fun ProductOutput.toProduct(): Product = Product(
    id = id,
    title = name,
    category = typeName,
    description = measurement,
    image = image,
    contextualImageUrl = contextualImageUrl,
    price = price.currentPrice
)
