package com.jhonny.punkbeer.data.entities.beer.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailResponse(

	@field:SerializedName("drinks")
	var drinks: ArrayList<CocktailItem?>? = null
) : Parcelable

@Parcelize
data class CocktailItem(

	@field:SerializedName("strInstructionsDE")
	val strInstructionsDE: String? = null,

	@field:SerializedName("strImageSource")
	val strImageSource: String? = null,

	@field:SerializedName("strIngredient10")
	val strIngredient10: String? = null,

	@field:SerializedName("strDrink")
	val strDrink: String? = null,

	@field:SerializedName("strIngredient12")
	val strIngredient12: String? = null,

	@field:SerializedName("strIngredient11")
	val strIngredient11: String? = null,

	@field:SerializedName("strIngredient14")
	val strIngredient14: String? = null,

	@field:SerializedName("strCategory")
	val strCategory: String? = null,

	@field:SerializedName("strAlcoholic")
	val strAlcoholic: String? = null,

	@field:SerializedName("strIngredient13")
	val strIngredient13: String? = null,

	@field:SerializedName("strIngredient15")
	val strIngredient15: String? = null,

	@field:SerializedName("strCreativeCommonsConfirmed")
	val strCreativeCommonsConfirmed: String? = null,

	@field:SerializedName("strIBA")
	val strIBA: String? = null,

	@field:SerializedName("strVideo")
	val strVideo: String? = null,

	@field:SerializedName("strTags")
	val strTags: String? = null,

	@field:SerializedName("strInstructions")
	val strInstructions: String? = null,

	@field:SerializedName("strIngredient1")
	val strIngredient1: String? = null,

	@field:SerializedName("strIngredient3")
	val strIngredient3: String? = null,

	@field:SerializedName("strIngredient2")
	val strIngredient2: String? = null,

	@field:SerializedName("strIngredient5")
	val strIngredient5: String? = null,

	@field:SerializedName("strIngredient4")
	val strIngredient4: String? = null,

	@field:SerializedName("strIngredient7")
	val strIngredient7: String? = null,

	@field:SerializedName("strIngredient6")
	val strIngredient6: String? = null,

	@field:SerializedName("strIngredient9")
	val strIngredient9: String? = null,

	@field:SerializedName("strInstructionsFR")
	val strInstructionsFR: String? = null,

	@field:SerializedName("strIngredient8")
	val strIngredient8: String? = null,

	@field:SerializedName("idDrink")
	val idDrink: String? = null,

	@field:SerializedName("strInstructionsES")
	val strInstructionsES: String? = null,

	@field:SerializedName("strInstructionsIT")
	val strInstructionsIT: String? = null,

	@field:SerializedName("strGlass")
	val strGlass: String? = null,

	@field:SerializedName("strMeasure12")
	val strMeasure12: String? = null,

	@field:SerializedName("strMeasure13")
	val strMeasure13: String? = null,

	@field:SerializedName("strMeasure10")
	val strMeasure10: String? = null,

	@field:SerializedName("strMeasure11")
	val strMeasure11: String? = null,

	@field:SerializedName("strImageAttribution")
	val strImageAttribution: String? = null,

	@field:SerializedName("dateModified")
	val dateModified: String? = null,

	@field:SerializedName("strDrinkAlternate")
	val strDrinkAlternate: String? = null,

	@field:SerializedName("strDrinkThumb")
	val strDrinkThumb: String? = null,

	@field:SerializedName("strInstructionsZH-HANT")
	val strInstructionsZHHANT: String? = null,

	@field:SerializedName("strMeasure9")
	val strMeasure9: String? = null,

	@field:SerializedName("strMeasure7")
	val strMeasure7: String? = null,

	@field:SerializedName("strMeasure8")
	val strMeasure8: String? = null,

	@field:SerializedName("strMeasure5")
	val strMeasure5: String? = null,

	@field:SerializedName("strMeasure6")
	val strMeasure6: String? = null,

	@field:SerializedName("strMeasure3")
	val strMeasure3: String? = null,

	@field:SerializedName("strMeasure4")
	val strMeasure4: String? = null,

	@field:SerializedName("strMeasure1")
	val strMeasure1: String? = null,

	@field:SerializedName("strMeasure2")
	val strMeasure2: String? = null,

	@field:SerializedName("strInstructionsZH-HANS")
	val strInstructionsZHHANS: String? = null,

	@field:SerializedName("strMeasure14")
	val strMeasure14: String? = null,

	@field:SerializedName("strMeasure15")
	val strMeasure15: String? = null
) : Parcelable
