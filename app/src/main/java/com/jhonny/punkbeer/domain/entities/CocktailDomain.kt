package com.jhonny.punkbeer.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class DomainCocktail(
    var list: List<DomainCocktailItem?>? = null
) : Parcelable

@Parcelize
data class DomainCocktailItem(
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
): Parcelable
