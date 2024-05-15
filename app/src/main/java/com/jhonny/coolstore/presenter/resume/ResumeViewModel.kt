package com.jhonny.coolstore.presenter.resume

import android.util.Log
import com.jhonny.coolstore.App
import com.jhonny.coolstore.presenter.base.BaseViewModel
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ResumeViewModel @Inject constructor() : BaseViewModel() {
    private val _products = MutableStateFlow<List<ProductPresentationItem?>>(emptyList())
    val products: StateFlow<List<ProductPresentationItem?>> = _products

    private val _purchase = MutableStateFlow( false)
    val purchase: StateFlow<Boolean> = _purchase

    private val _errorHandling = MutableStateFlow(Exception())
    val errorHandling: StateFlow<Exception> = _errorHandling

    fun setPurchase(isBought : Boolean){
        _purchase.value = isBought
    }

    fun getProducts() {
        _products.value = App.StoreSingletonList.instance
    }

    fun calculateTotal(): Float{
        var total =0f
        _products.value.forEach{ product ->
            total+= calculateOffer(product)
        }
        return total
    }

    fun calculateOffer(product: ProductPresentationItem?): Float {
        var offerPrice = 0f
        product?.price?.let { price ->
            product.number?.let { number ->
                when (product.code) {
                    "VOUCHER" -> {
                        offerPrice = price * number - (price * parNumber(number))
                    }
                    "TSHIRT" -> {
                        offerPrice = price * number
                        if (number >= 3)
                            offerPrice-= number
                        else { }
                    }
                    "MUG" -> {
                        offerPrice = price * number
                    }

                    else -> {
                        Log.i(javaClass.name, "Código no reconocido:")
                    }
                }
            }
        }
        return offerPrice
    }

    private fun parNumber(number: Int): Int {
        return (number/2)
    }
    fun resetQuantities() {
        _products.value.forEach { product ->
            product?.number = 0
        }
    }

    fun offerText(product: ProductPresentationItem?): String {
        var offerText = ""
        product?.price?.let { price ->
            product.number?.let { number ->
                when (product.code) {
                    "VOUCHER" -> {
                        offerText = " 2x1 en VOUCHER"
                    }
                    "TSHIRT" -> {
                            offerText = " 1€ de descuento por cada TSHIRT  a partir de 3 o mas"
                    }

                    "MUG" -> {
                        offerText = "no hay oferta disponible de momento "
                    }

                    else -> {
                        Log.i(javaClass.name, "Código no reconocido:")
                    }
                }
            }
        }
        return offerText
    }
}

