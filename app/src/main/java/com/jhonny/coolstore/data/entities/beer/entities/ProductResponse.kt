package com.jhonny.coolstore.data.entities.beer.entities

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ProductResponse(
	@field:SerializedName("products")
	val products: List<ProductItem?>? = null
) : Parcelable

@Parcelize
data class ProductItem(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("price")
	val price: Float? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable
