package com.jhonny.punkcocktail.di

import com.jhonny.coolstore.data.entities.beer.ProductDataSource
import com.jhonny.coolstore.data.entities.beer.ProductRepository
import com.jhonny.coolstore.data.entities.beer.mapper.ProductMapper
import com.jhonny.coolstore.data.entities.beer.remote.ProductRemoteDataSource
import com.jhonny.coolstore.data.entities.beer.remote.ProductRemoteDataSourceImpl
import com.jhonny.coolstore.data.entities.beer.service.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun cocktailRepositoryProvider(
        productRemoteDataSource: ProductRemoteDataSource,
        productMapper: ProductMapper
    ) = ProductRepository(
        productRemoteDataSource,
        productMapper
    )

    @Singleton
    @Provides
    fun cocktailDataSourceImplProvider(
        productService: ProductService
    ) = ProductRemoteDataSourceImpl(
        productService
    )

    @Singleton
    @Provides
    fun cocktailDataSourceProvider(
        productRemoteDataSource: ProductRemoteDataSource,
        productMapper: ProductMapper
    ): ProductDataSource = ProductRepository(
        productRemoteDataSource,
        productMapper
    )

    @Singleton
    @Provides
    fun cocktailRemoteDataSourceProvider(
        productService: ProductService
    ): ProductRemoteDataSource = ProductRemoteDataSourceImpl(
        productService
    )

}