package com.aermakova.corgstore.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.components.AppTopBar
import com.aermakova.corgstore.ui.components.ShimmerImage
import com.aermakova.corgstore.ui.components.filter.FilterComponent
import com.aermakova.corgstore.ui.home.model.ProductUIModel
import com.aermakova.corgstore.ui.navigation.ProductScreen
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
            onAction = viewModel::onAction,
            onProductSelected = {
                navController.navigate(ProductScreen.routeFormat.format(it))
                viewModel.onAction(ProductsActions.SelectProduct(it))
            }
        )
    }
}

@Composable
private fun HomeScreenContent(
    screenState: ProductsScreenState,
    state: ProductsState,
    onAction: (ProductsActions) -> Unit,
    onProductSelected: (String) -> Unit
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

        Spacer(Modifier.height(AppTheme.dimens.spacing8))

        when (state) {
            ProductsState.Empty -> {}
            ProductsState.Error -> {
            }

            is ProductsState.Loaded -> ProductsContent(
                products = state.products,
                onProductSelected = onProductSelected
            )

            ProductsState.Loading -> {

            }
        }
    }
}

@Composable
private fun ProductsContent(
    products: List<ProductUIModel>,
    onProductSelected: (String) -> Unit
) {
    val scrollState = rememberLazyGridState()

    LazyVerticalGrid(
        state = scrollState,
        modifier = Modifier
            .fillMaxHeight()
            .background(
                brush = AppTheme.colors.backgroundColor
            )
            .padding(horizontal = AppTheme.dimens.spacing8),
        columns = GridCells.Fixed(2),
    ) {
        items(products, { item -> "item:${item}" }) { product ->
            ProductCard(
                product = product,
                onProductSelected = onProductSelected
            )
        }
    }
}

@Composable
private fun ProductCard(
    product: ProductUIModel,
    onProductSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(AppTheme.dimens.spacing8)
            .clickable {
                onProductSelected(product.id)
            }
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(AppTheme.dimens.spacing10))
                .aspectRatio(6 / 7f),
        ) {
            ShimmerImage(
                modifier = Modifier.fillMaxSize(),
                contentDescription = "product image photo",
                imageUrl = product.contextualImageUrl ?: product.image,
                errorImage = R.drawable.product_mock
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
            product = ProductUIModel.test,
            onProductSelected = {}
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
                    ProductUIModel.test
                )
            ),
            onAction = { },
            onProductSelected = { }
        )
    }
}
