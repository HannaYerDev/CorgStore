package com.aermakova.corgstore.ui.home.model

import com.aermakova.corgstore.domain.model.Product

object ProductMapper {

    fun map(product: Product): ProductUIModel {
        return ProductUIModel(
            id = product.id,
            title = product.title,
//            description = product.description,
            image = product.image,
            contextualImageUrl = product.contextualImageUrl,
            price = product.price
        )
    }
}