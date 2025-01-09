package com.aermakova.corgstore.ui.components.filter

import com.aermakova.corgstore.domain.model.Filter

object FilterMapper {

    fun map(filter: FilterUIModel): Filter {
        return when (filter) {
            FilterUIModel.Armchair -> Filter.ARMCHAIR
            FilterUIModel.Bed -> Filter.BED
            FilterUIModel.Chair -> Filter.CHAIR
            FilterUIModel.Lamp -> Filter.LAMP
            FilterUIModel.Popular -> Filter.POPULAR
            FilterUIModel.Storage -> Filter.STORAGE
            FilterUIModel.Table -> Filter.TABLE
        }
    }
}
