package com.jhonny.coolstore.domain.usecases.mapper


import com.jhonny.coolstore.domain.entities.DomainProduct
import com.jhonny.coolstore.domain.mapper.Mapper
import com.jhonny.coolstore.presenter.entities.ProductPresentation
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import javax.inject.Inject

class ProductMapper @Inject constructor() : Mapper<DomainProduct?, ProductPresentation>() {

    override fun map(info: DomainProduct?): ProductPresentation =
        ProductPresentation(
            products = info?.products?.map {
                ProductPresentationItem(
                    name = it?.name,
                    code = it?.code,
                    price = it?.price
                )
            } ?: emptyList()
        )

}
