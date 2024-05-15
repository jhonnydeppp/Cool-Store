package com.jhonny.coolstore.di

import com.jhonny.coolstore.data.entities.beer.mapper.ProductMapper
import com.jhonny.coolstore.data.entities.beer.mapper.ProductMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Singleton
    @Provides
    fun beerMapperProvider(): ProductMapper = ProductMapperImpl()
}