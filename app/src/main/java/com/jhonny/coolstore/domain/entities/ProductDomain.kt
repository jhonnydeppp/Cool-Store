package com.jhonny.coolstore.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class DomainProduct(
@field:SerializedName("products")
val products: List<ProductDomainItem?>? = null
) : Parcelable

@Parcelize
data class ProductDomainItem(

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("price")
    val price: Float? = null,

    @field:SerializedName("name")
    val name: String? = null
) : Parcelable
