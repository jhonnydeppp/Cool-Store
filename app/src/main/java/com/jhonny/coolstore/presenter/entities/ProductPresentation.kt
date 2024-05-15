package com.jhonny.coolstore.presenter.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductPresentation(
@field:SerializedName("products")
val products: List<ProductPresentationItem?>? = null
) : Parcelable

@Parcelize
data class ProductPresentationItem(

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("price")
    var price: Float? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("number")
    var number: Int? = 0

) : Parcelable