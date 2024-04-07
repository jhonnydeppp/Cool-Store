package com.jhonny.punkbeer.data.entities.beer

import com.jhonny.punkbeer.data.entities.beer.mapper.CocktailMapper
import com.jhonny.punkbeer.data.entities.beer.remote.CocktailRemoteDataSource
import com.jhonny.punkbeer.data.map
import javax.inject.Inject

class CocktailRepository @Inject constructor(private val cocktailRemoteDataSource: CocktailRemoteDataSource,
                                             private val cocktailMapper: CocktailMapper
): CocktailDataSource {

    override suspend fun getCocktails(name: String) = cocktailRemoteDataSource.getCocktails()
        .map(cocktailMapper::responseToDomain)

    override suspend fun getCocktailsByName(name: String) = cocktailRemoteDataSource.getCocktailsByName(name)
        .map(cocktailMapper::responseToDomain)

}