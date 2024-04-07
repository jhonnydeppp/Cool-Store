package com.jhonny.punkbeer.data.entities.beer

import com.jhonny.punkbeer.data.Result
import com.jhonny.punkbeer.domain.entities.DomainCocktail

interface CocktailDataSource {
    suspend fun getCocktails(name: String): Result<DomainCocktail?>

    suspend fun getCocktailsByName(name: String): Result<DomainCocktail?>

}