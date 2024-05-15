package com.jhonny.coolstore.data.entities.beer

import com.jhonny.coolstore.data.entities.beer.mapper.ProductMapper
import com.jhonny.coolstore.data.entities.beer.remote.ProductRemoteDataSource
import com.jhonny.coolstore.data.map
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productRemoteDataSource: ProductRemoteDataSource,
                                            private val productMapper: ProductMapper
): ProductDataSource {

    override suspend fun getProducts(name: String) = productRemoteDataSource.getProducts()
        .map(productMapper::responseToDomain)

}