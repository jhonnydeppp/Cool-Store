package com.jhonny.punkbeer.domain.usecases

import com.jhonny.punkbeer.data.Result
import com.jhonny.punkbeer.data.entities.beer.CocktailDataSource
import com.jhonny.punkbeer.di.IoDispatcher
import com.jhonny.punkbeer.domain.base.SuspendMapperUseCase
import com.jhonny.punkbeer.domain.entities.DomainCocktail
import com.jhonny.punkbeer.domain.usecases.mapper.CocktailMapper
import com.jhonny.punkbeer.presenter.entities.CocktailsPresentation
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetCocktailsByNameUseCase @Inject constructor(
    private val cocktailDataSource: CocktailDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: CocktailMapper
) : SuspendMapperUseCase<String, CocktailsPresentation, DomainCocktail?>(dispatcher, mapper) {

    override suspend fun execute(parameters: String): Result<DomainCocktail?> {
        return cocktailDataSource.getCocktailsByName(parameters)
    }

}