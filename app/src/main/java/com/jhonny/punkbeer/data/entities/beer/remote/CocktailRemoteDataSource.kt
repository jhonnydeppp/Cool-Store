package com.jhonny.punkbeer.data.entities.beer.remote

import com.jhonny.punkbeer.data.Result
import com.jhonny.punkbeer.data.entities.beer.entities.CocktailResponse

interface CocktailRemoteDataSource {

    suspend fun getCocktails(): Result<CocktailResponse?>

    suspend fun getCocktailsByName(name: String = ""): Result<CocktailResponse?>
}