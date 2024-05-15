package com.jhonny.coolstore.data.entities.beer.remote

import com.jhonny.coolstore.data.Result
import com.jhonny.coolstore.data.entities.beer.entities.ProductResponse

interface ProductRemoteDataSource {

    suspend fun getProducts(): Result<ProductResponse?>

}