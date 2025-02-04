package com.aermakova.corgstore.ui.home.model

data class ProductUIModel(
    val id: String,
    val title: String,
    val description: String?,
    val image: String?,
    val contextualImageUrl: String?,
    val price: String?,
){
    companion object{
        
        val test = ProductUIModel(
            id = "EKENÄSET",
            title = "EKENÄSET",
            image = null,
            contextualImageUrl = null,
            price = "239.0",
            description = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
        )
    }
}
