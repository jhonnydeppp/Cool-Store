package com.jhonny.coolstore.data.entities.beer.mapper

import com.jhonny.coolstore.data.entities.beer.entities.ProductResponse
import com.jhonny.coolstore.domain.entities.DomainProduct
import com.jhonny.coolstore.domain.entities.ProductDomainItem
import javax.inject.Inject

class ProductMapperImpl @Inject constructor() : ProductMapper {

    override fun responseToDomain(info: ProductResponse?) =
        DomainProduct(
            products =
            info?.products?.map {
            ProductDomainItem(
                code = it?.code,
                price = it?.price,
                name = it?.name
            )
        } ?: emptyList()
    )

}
