package com.aermakova.corgstore.ui.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aermakova.corgstore.domain.repo.ProductsRepo
import com.aermakova.corgstore.ui.home.model.ProductMapper
import com.aermakova.corgstore.ui.home.model.ProductUIModel
import com.aermakova.corgstore.ui.navigation.ProductScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepo: ProductsRepo
) : ViewModel() {

    private val productId = savedStateHandle.get<String>(ProductScreen.argumentKey)!!

    var state by mutableStateOf<ProductState>(ProductState.Loading)
        private set

    init {
        loadProduct()
    }

    private fun loadProduct() {
        viewModelScope.launch {
            state = try {
                productsRepo.getProductById(productId)?.let {
                    ProductState.Loaded(ProductMapper.map(it))
                } ?: ProductState.Empty
            } catch (e: Exception) {
                ProductState.Error
            }
        }
    }
}

sealed interface ProductState {
    data object Loading : ProductState
    data class Loaded(
        val product: ProductUIModel
    ) : ProductState

    data object Empty : ProductState
    data object Error : ProductState
}
