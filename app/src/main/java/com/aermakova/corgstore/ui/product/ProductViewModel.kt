package com.aermakova.corgstore.ui.product

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.aermakova.corgstore.ui.navigation.ProductScreen
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val productId = savedStateHandle.get<String>(ProductScreen.argumentKey)!!

}
