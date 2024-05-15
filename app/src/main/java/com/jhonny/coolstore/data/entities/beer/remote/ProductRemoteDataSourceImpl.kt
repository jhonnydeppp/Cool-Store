package com.jhonny.coolstore.data.entities.beer.remote

import com.jhonny.coolstore.data.entities.beer.service.ProductService
import com.jhonny.coolstore.data.util.BaseRemoteDataSource
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(private val service: ProductService) :
    ProductRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getProducts() = getResult {
        service.getCocktails()
    }


}

