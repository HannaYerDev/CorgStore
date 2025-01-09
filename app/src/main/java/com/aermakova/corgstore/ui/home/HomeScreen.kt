package com.aermakova.corgstore.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.components.AppTopBar
import com.aermakova.corgstore.ui.components.filter.FilterComponent
import com.aermakova.corgstore.ui.home.model.ProductUIModel
import com.aermakova.corgstore.ui.navigation.Screens
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.nunitoSansBold14
import com.aermakova.corgstore.ui.theme.nunitoSansRegular14

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    AppTheme {
        HomeScreenContent(
            screenState = viewModel.screenState,
            state = viewModel.state,
            onAction = viewModel::onAction
        )
    }
}

@Composable
private fun HomeScreenContent(
    screenState: ProductsScreenState,
    state: ProductsState,
    onAction: (ProductsActions) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.white)
    ) {
        AppTopBar(Screens.Home)

        FilterComponent(selectedItem = screenState.selectedFilter) {
            onAction(ProductsActions.SelectFilter(it))
        }

        when (state) {
            ProductsState.Empty -> {}
            ProductsState.Error -> {
            }

            is ProductsState.Loaded -> ProductsContent(state.products)
            ProductsState.Loading -> {

            }
        }
    }
}

@Composable
private fun ProductsContent(
    products: List<ProductUIModel>
) {
    val scrollState = rememberLazyGridState()

    LazyVerticalGrid(
        state = scrollState,
        modifier = Modifier
            .fillMaxHeight()
            .background(
                brush = AppTheme.colors.backgroundColor
            )
            .padding(AppTheme.dimens.spacing8),
        columns = GridCells.Fixed(2),
    ) {
        items(products, { item -> "item:${item}" }) { product ->
            ProductCard(product)
        }
    }
}

@Composable
private fun ProductCard(
    product: ProductUIModel
) {
    val isInPreviewMode = LocalInspectionMode.current
    Column(
        modifier = Modifier.padding(AppTheme.dimens.spacing8)
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(AppTheme.dimens.spacing10))
                .aspectRatio(6 / 7f),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter(
                    model = product.contextualImageUrl ?: product.image,
                    error = painterResource(R.drawable.product_mock)
                ).takeIf { !isInPreviewMode } ?: painterResource(R.drawable.product_mock),
                contentDescription = "product image photo",
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(AppTheme.dimens.spacing10))

        Text(
            text = product.title,
            style = nunitoSansRegular14.copy(
                color = AppTheme.colors.secondary,
            )
        )
        Spacer(modifier = Modifier.height(AppTheme.dimens.spacing4))

        Text(
            text = "$${product.price}",
            style = nunitoSansBold14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    AppTheme {
        ProductCard(
            product = ProductUIModel(
                id = "EKENÄSET",
                title = "EKENÄSET",
                image = null,
                contextualImageUrl = null,
                price = 239.0,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsScreenPreview() {
    AppTheme {
        HomeScreenContent(
            screenState = ProductsScreenState(),
            state = ProductsState.Loaded(
                products = listOf(
                    ProductUIModel(
                        id = "EKENÄSET",
                        title = "EKENÄSET",
                        image = null,
                        contextualImageUrl = null,
                        price = 239.0,
                    )
                )
            )
        ) {}
    }
}
