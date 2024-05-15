package com.jhonny.coolstore.data.entities.beer.service


import com.jhonny.coolstore.data.APIConstants.ENDPOINT_PRODUCTS
import com.jhonny.coolstore.data.entities.beer.entities.ProductResponse
import retrofit2.http.GET

interface ProductService {

    @GET(ENDPOINT_PRODUCTS)
    suspend fun getCocktails(): ProductResponse?

}