package com.aermakova.corgstore.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aermakova.corgstore.domain.model.Filter
import com.aermakova.corgstore.domain.repo.ProductsRepo
import com.aermakova.corgstore.ui.components.filter.FilterMapper
import com.aermakova.corgstore.ui.components.filter.FilterUIModel
import com.aermakova.corgstore.ui.home.model.ProductMapper
import com.aermakova.corgstore.ui.home.model.ProductUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: ProductsRepo
) : ViewModel() {

    var state by mutableStateOf<ProductsState>(ProductsState.Loading)
        private set

    var screenState by mutableStateOf(ProductsScreenState())
        private set

    private val selectedFilter = MutableStateFlow<Filter?>(null)

    init {
        loadProducts()
        observeProducts()
    }

    fun onAction(action: ProductsActions) {
        when (action) {
            is ProductsActions.SelectFilter -> selectFilter(action.filter)
            is ProductsActions.SelectProduct -> navigateToProductScreen(action.productId)
        }
    }

    private fun navigateToProductScreen(productId: String) {
        // Track the event
    }

    private fun loadProducts() {
        viewModelScope.launch {
                repo.fetchProducts()
        }
    }

    private fun observeProducts() {
        repo.observeProducts()
            .combine(selectedFilter) { products, filter -> products to filter }
            .onEach {(products, filter) ->
                state = ProductsState.Loaded(
                    products = products
                        .filter { (filter?.keyword ?: "") in it.tags }
                        .map { ProductMapper.map(it) }
                )
            }
            .launchIn(viewModelScope)
    }

    private fun selectFilter(filter: FilterUIModel?) {
        state = ProductsState.Loading
        val keyword = filter?.let { FilterMapper.map(it) }

        keyword?.let {
            viewModelScope.launch {
                repo.fetchProductsByCategory(keyword.keyword)
            }
        }

        selectedFilter.value = filter?.let { FilterMapper.map(it) }
        screenState = screenState.copy(selectedFilter = filter)
    }
}

data class ProductsScreenState(
    val selectedFilter: FilterUIModel? = null
)

sealed interface ProductsState {
    data object Loading : ProductsState
    data class Loaded(
        val products: List<ProductUIModel>
    ) : ProductsState

    data object Empty : ProductsState
    data object Error : ProductsState
}