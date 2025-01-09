package com.aermakova.corgstore.ui.components.filter

import androidx.annotation.DrawableRes
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.theme.AppStrings

sealed class FilterUIModel(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val title: String = ""
) {
    data object Popular : FilterUIModel(
        title = AppStrings.filterPopular,
        selectedIcon = R.drawable.ic_popular_selected,
        unselectedIcon = R.drawable.ic_popular_unselected
    )

    data object Chair : FilterUIModel(
        title = AppStrings.filterChair,
        selectedIcon = R.drawable.ic_chair_selected,
        unselectedIcon = R.drawable.ic_chair_unselected
    )

    data object Table : FilterUIModel(
        title = AppStrings.filterTable,
        selectedIcon = R.drawable.ic_table_selected,
        unselectedIcon = R.drawable.ic_table_unselected
    )

    data object Armchair : FilterUIModel(
        title = AppStrings.filterArmchair,
        selectedIcon = R.drawable.ic_armchair_selected,
        unselectedIcon = R.drawable.ic_armchair_unselected
    )

    data object Bed : FilterUIModel(
        title = AppStrings.filterBed,
        selectedIcon = R.drawable.ic_bed_selected,
        unselectedIcon = R.drawable.ic_bed_unselected
    )

    data object Lamp : FilterUIModel(
        title = AppStrings.filterLamp,
        selectedIcon = R.drawable.ic_lamp_selected,
        unselectedIcon = R.drawable.ic_lamp_unselected
    )

    data object Storage : FilterUIModel(
        title = AppStrings.filterStorage,
        selectedIcon = R.drawable.ic_storage_selected,
        unselectedIcon = R.drawable.ic_storage_unselected
    )

    companion object {
        val all = listOf(Popular, Chair, Table, Armchair, Bed, Lamp, Storage)
    }
}