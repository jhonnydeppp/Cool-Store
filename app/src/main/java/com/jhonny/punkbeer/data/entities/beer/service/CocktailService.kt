package com.jhonny.punkbeer.data.entities.beer.service


import com.jhonny.punkbeer.data.APIConstants.Cocktail_NAME
import com.jhonny.punkbeer.data.APIConstants.ENDPOINT_COCKTAILS
import com.jhonny.punkbeer.data.entities.beer.entities.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {

    @GET(ENDPOINT_COCKTAILS)
    suspend fun getCocktails(
        @Query(Cocktail_NAME) cocktailName: String = ""): CocktailResponse?

    @GET(ENDPOINT_COCKTAILS)
    suspend fun getCocktailsByName(
        @Query(Cocktail_NAME) cocktailName: String): CocktailResponse?

}