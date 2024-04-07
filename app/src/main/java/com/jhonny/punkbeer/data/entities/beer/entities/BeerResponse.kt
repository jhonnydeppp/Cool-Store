package com.jhonny.punkbeer.data.entities.beer.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Beers(
	var list: List<BeerResponseItem?>? = null
) : Parcelable

@Parcelize
data class MaltItem(

	@field:SerializedName("amount")
	val amount: Amount? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

@Parcelize
data class Volume(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class Ingredients(

	@field:SerializedName("hops")
	val hops: List<HopsItem?>? = null,

	@field:SerializedName("yeast")
	val yeast: String? = null,

	@field:SerializedName("malt")
	val malt: List<MaltItem?>? = null
) : Parcelable

@Parcelize
data class BoilVolume(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class Amount(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("value")
	val value: Float? = null
) : Parcelable

@Parcelize
data class BeerResponseItem(

	@field:SerializedName("first_brewed")
	val firstBrewed: String? = null,

	@field:SerializedName("attenuation_level")
	val attenuationLevel: Float? = null,

	@field:SerializedName("method")
	val method: Method? = null,

	@field:SerializedName("target_og")
	val targetOg: Float? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("boil_volume")
	val boilVolume: BoilVolume? = null,

	@field:SerializedName("ebc")
	val ebc: Float? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("target_fg")
	val targetFg: Int? = null,

	@field:SerializedName("srm")
	val srm: Float? = null,

	@field:SerializedName("volume")
	val volume: Volume? = null,

	@field:SerializedName("contributed_by")
	val contributedBy: String? = null,

	@field:SerializedName("abv")
	val abv: Float? = null,

	@field:SerializedName("food_pairing")
	val foodPairing: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("ph")
	val ph: Float? = null,

	@field:SerializedName("tagline")
	val tagline: String? = null,

	@field:SerializedName("ingredients")
	val ingredients: Ingredients? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("ibu")
	val ibu: Float? = null,

	@field:SerializedName("brewers_tips")
	val brewersTips: String? = null
) : Parcelable

@Parcelize
data class Temp(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class MashTempItem(

	@field:SerializedName("duration")
	val duration: Int? = null,

	@field:SerializedName("temp")
	val temp: Temp? = null
) : Parcelable

@Parcelize
data class Fermentation(

	@field:SerializedName("temp")
	val temp: Temp? = null
) : Parcelable

@Parcelize
data class Method(

	@field:SerializedName("mash_temp")
	val mashTemp: List<MashTempItem?>? = null,

	@field:SerializedName("fermentation")
	val fermentation: Fermentation? = null,

	@field:SerializedName("twist")
	val twist: String? = null
) : Parcelable

@Parcelize
data class HopsItem(

	@field:SerializedName("add")
	val add: String? = null,

	@field:SerializedName("amount")
	val amount: Amount? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("attribute")
	val attribute: String? = null
) : Parcelable
