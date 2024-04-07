package com.jhonny.punkbeer.data.entities.beer.mapper

import com.jhonny.punkbeer.data.entities.beer.entities.CocktailResponse
import com.jhonny.punkbeer.domain.entities.DomainCocktail


interface CocktailMapper {
    fun responseToDomain(info: CocktailResponse?): DomainCocktail?
}
