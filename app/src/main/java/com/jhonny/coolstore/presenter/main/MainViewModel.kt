package com.jhonny.coolstore.presenter.main

import com.jhonny.coolstore.App
import com.jhonny.coolstore.data.dataOrNull
import com.jhonny.coolstore.data.getError
import com.jhonny.coolstore.data.isError
import com.jhonny.coolstore.data.isSuccess
import com.jhonny.coolstore.domain.usecases.GetProductsUseCase
import com.jhonny.coolstore.extensions.launch
import com.jhonny.coolstore.presenter.base.BaseViewModel
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : BaseViewModel() {
    private val _product = MutableStateFlow<List<ProductPresentationItem?>>(emptyList())
    val product: StateFlow<List<ProductPresentationItem?>> = _product

    private val _errorHandling = MutableStateFlow(Exception())
    val errorHandling: StateFlow<Exception> = _errorHandling

    fun getProducts() {
        if(App.StoreSingletonList.instance.isEmpty()) {
            launch {
                getProductsUseCase("").let { result ->
                    when {
                        result.isSuccess ->
                            result.dataOrNull()?.let { productPresentation ->
                                updateStoreList(productPresentation.products ?: emptyList())
                            }

                        result.isError -> {
                            _errorHandling.value = result.getError()
                        }

                        else -> {}
                    }
                }
            }
        } else {
            _product.value = App.StoreSingletonList.instance
        }
    }

     private fun updateStoreList(product: List<ProductPresentationItem?>) {
         App.StoreSingletonList.instance.clear()
         App.StoreSingletonList.instance.addAll(product)
         _product.value = App.StoreSingletonList.instance
     }

    fun updateNumberProductList(product: ProductPresentationItem) {
        App.StoreSingletonList.instance.find { product.code == it?.code }?.number = product.number
        _product.value.find { product.code == it?.code }?.number = product.number
    }

}

