package com.jhonny.punkbeer.domain.usecases.mapper


import com.jhonny.punkbeer.domain.entities.DomainCocktail
import com.jhonny.punkbeer.domain.mapper.Mapper
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import com.jhonny.punkbeer.presenter.entities.CocktailsPresentation
import javax.inject.Inject

class CocktailMapper @Inject constructor() : Mapper<DomainCocktail?, CocktailsPresentation>() {

    override fun map(info: DomainCocktail?): CocktailsPresentation =
        CocktailsPresentation(
            list = info?.list?.map {
                CocktailPresentation(
                    strDrink = it?.strDrink,
                    strDrinkThumb = it?.strDrinkThumb,
                    strCategory = it?.strCategory,
                    strAlcoholic = it?.strAlcoholic,
                    strInstructions = it?.strInstructions,
                    strIngredient =  it?.strIngredient
                )
            } ?: emptyList()
        )

}
