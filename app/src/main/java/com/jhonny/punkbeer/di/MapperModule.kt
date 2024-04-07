package com.jhonny.punkbeer.di

import com.jhonny.punkbeer.data.entities.beer.mapper.CocktailMapper
import com.jhonny.punkbeer.data.entities.beer.mapper.CocktailMapperImpl
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
    fun beerMapperProvider(): CocktailMapper = CocktailMapperImpl()
}