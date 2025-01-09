package com.aermakova.corgstore.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aermakova.corgstore.domain.repo.ProductsRepo
import com.aermakova.corgstore.ui.components.filter.FilterUIModel
import com.aermakova.corgstore.ui.components.filter.FilterMapper
import com.aermakova.corgstore.ui.home.model.ProductMapper
import com.aermakova.corgstore.ui.home.model.ProductUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        loadProducts()
    }

    fun onAction(action: ProductsActions) {
        when (action) {
            is ProductsActions.SelectFilter -> selectFilter(action.filter)
        }
    }

    private fun loadProducts() {
        viewModelScope.launch {
            val products =
                repo.getProducts(screenState.selectedFilter?.let { FilterMapper.map(it) })
            state = ProductsState.Loaded(
                products = products.map { ProductMapper.map(it) }
            )
        }
    }

    private fun selectFilter(filter: FilterUIModel?) {
        screenState = screenState.copy(selectedFilter = filter)
        state = ProductsState.Loading
        loadProducts()
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