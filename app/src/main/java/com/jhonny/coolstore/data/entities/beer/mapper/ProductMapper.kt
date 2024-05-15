package com.jhonny.coolstore.data.entities.beer.mapper

import com.jhonny.coolstore.data.entities.beer.entities.ProductResponse
import com.jhonny.coolstore.domain.entities.DomainProduct


interface ProductMapper {
    fun responseToDomain(info: ProductResponse?): DomainProduct?
}
