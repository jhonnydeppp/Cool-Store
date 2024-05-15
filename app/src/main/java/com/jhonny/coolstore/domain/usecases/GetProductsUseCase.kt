package com.jhonny.coolstore.domain.usecases

import com.jhonny.coolstore.data.Result
import com.jhonny.coolstore.data.entities.beer.ProductDataSource
import com.jhonny.coolstore.di.IoDispatcher
import com.jhonny.coolstore.domain.base.SuspendMapperUseCase
import com.jhonny.coolstore.domain.entities.DomainProduct
import com.jhonny.coolstore.domain.usecases.mapper.ProductMapper
import com.jhonny.coolstore.presenter.entities.ProductPresentation
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productDataSource: ProductDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: ProductMapper
) : SuspendMapperUseCase<String, ProductPresentation, DomainProduct?>(dispatcher, mapper) {

    override suspend fun execute(parameters: String): Result<DomainProduct?> {
        return productDataSource.getProducts(parameters)
    }

}