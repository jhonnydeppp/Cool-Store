package com.jhonny.coolstore.data.entities.beer

import com.jhonny.coolstore.data.Result
import com.jhonny.coolstore.domain.entities.DomainProduct

interface ProductDataSource {
    suspend fun getProducts(name: String): Result<DomainProduct?>

}