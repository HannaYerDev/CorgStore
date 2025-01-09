package com.aermakova.corgstore.ui.home

import com.aermakova.corgstore.ui.components.filter.FilterUIModel

sealed interface ProductsActions {
    data class SelectFilter(val filter: FilterUIModel?): ProductsActions
}