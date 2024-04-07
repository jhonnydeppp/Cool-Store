package com.jhonny.punkbeer.data.entities.beer.mapper


import com.jhonny.punkbeer.data.entities.beer.entities.CocktailResponse
import com.jhonny.punkbeer.domain.entities.DomainCocktail
import com.jhonny.punkbeer.domain.entities.DomainCocktailItem
import javax.inject.Inject

class CocktailMapperImpl @Inject constructor() : CocktailMapper {

    override fun responseToDomain(info: CocktailResponse?) =
        DomainCocktail(
            list =
            info?.drinks?.map {
                DomainCocktailItem(
                strDrink = it?.strDrink,
                strDrinkThumb = it?.strDrinkThumb,
                strCategory = it?.strCategory,
                strAlcoholic = it?.strAlcoholic,
                strInstructions = it?.strInstructions,
                strIngredient =  it?.strIngredient1
                        + it?.strIngredient2?.let { ", $it" }.orEmpty()
                        + it?.strIngredient3?.let { ", $it" }.orEmpty()
                        + it?.strIngredient4?.let { ", $it" }.orEmpty()
                        + it?.strIngredient5?.let { ", $it" }.orEmpty()
                        + it?.strIngredient6?.let { ", $it" }.orEmpty()
                        + it?.strIngredient7?.let { ", $it" }.orEmpty()
                        + it?.strIngredient8?.let { ", $it" }.orEmpty()
                        + it?.strIngredient9?.let { ", $it" }.orEmpty()
                        + it?.strIngredient10?.let { ", $it" }.orEmpty()
                        + it?.strIngredient11?.let { ", $it" }.orEmpty()
                        + it?.strIngredient12?.let { ", $it" }.orEmpty()
                        + it?.strIngredient13?.let { ", $it" }.orEmpty()
                        + it?.strIngredient14?.let { ", $it" }.orEmpty()
                        + it?.strIngredient15?.let { ", $it" }.orEmpty()
            )
        } ?: emptyList()
        )

}
