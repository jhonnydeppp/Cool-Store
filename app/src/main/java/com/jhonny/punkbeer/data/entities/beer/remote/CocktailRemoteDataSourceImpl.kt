package com.jhonny.punkbeer.data.entities.beer.remote

import com.jhonny.punkbeer.data.entities.beer.service.CocktailService
import com.jhonny.punkbeer.data.util.BaseRemoteDataSource
import javax.inject.Inject

class CocktailRemoteDataSourceImpl @Inject constructor(private val service: CocktailService) :
    CocktailRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getCocktails() = getResult {
        service.getCocktails()
    }

    override suspend fun getCocktailsByName(name: String) = getResult {
        service.getCocktailsByName(name)
    }

}

