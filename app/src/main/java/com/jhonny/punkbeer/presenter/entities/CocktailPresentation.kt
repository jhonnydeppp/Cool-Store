package com.jhonny.punkbeer.presenter.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailsPresentation(
    var list: List<CocktailPresentation?>? = null
) : Parcelable

@Parcelize
data class CocktailPresentation(
    @field:SerializedName("strDrink")
    val strDrink: String? = null,

    @field:SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = null,

    @field:SerializedName("strCategory")
    val strCategory: String? = null,

    @field:SerializedName("strAlcoholic")
    val strAlcoholic: String? = null,

    @field:SerializedName("strInstructions")
    val strInstructions: String? = null,

    @field:SerializedName("strIngredient")
    val strIngredient: String? = null,

    @field:SerializedName("isFavorite")
    var isFavorite: Boolean = false,
    ) : Parcelable