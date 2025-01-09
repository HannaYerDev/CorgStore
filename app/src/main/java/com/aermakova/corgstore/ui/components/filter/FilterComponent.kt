package com.aermakova.corgstore.ui.components.filter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.nunitoSansRegular14

@Composable
fun FilterComponent(
    selectedItem: FilterUIModel? = null,
    onItemSelected: (FilterUIModel?) -> Unit
) {
    val listState = rememberLazyListState()

    AppTheme {
        LazyRow(
            modifier = Modifier.padding(horizontal = AppTheme.dimens.spacing12),
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacing12),
        ) {
            itemsIndexed(FilterUIModel.all) { _, item ->
                FilterItem(
                    model = item,
                    isSelected = item == selectedItem,
                    onItemSelected = onItemSelected
                )
            }
        }
    }
}

@Composable
private fun FilterItem(
    model: FilterUIModel,
    isSelected: Boolean = false,
    onItemSelected: (FilterUIModel?) -> Unit
) {
    Column(
        modifier = Modifier.width(AppTheme.dimens.filterItemSize),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(AppTheme.dimens.filterIconSize)
                .clickable {
                    onItemSelected(model.takeIf { !isSelected })
                }
                .background(
                    color = when (isSelected) {
                        true -> AppTheme.colors.black
                        false -> AppTheme.colors.filterColor
                    },
                    shape = RoundedCornerShape(size = AppTheme.dimens.filterCornerRadius)
                )

        ) {
            Image(
                painter = painterResource(
                    when (isSelected) {
                        true -> model.selectedIcon
                        false -> model.unselectedIcon
                    },
                ),
                contentDescription = model.javaClass.name
            )
        }
        Text(
            text = model.title,
            style = nunitoSansRegular14.copy(
                color = when(isSelected){
                    true -> AppTheme.colors.black
                    false -> AppTheme.colors.secondary
                }
            )
        )
    }
}

@Preview
@Composable
private fun FilterComponentPreview() {
    AppTheme {
        FilterComponent(FilterUIModel.Popular) {}
    }
}
