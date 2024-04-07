package com.jhonny.punkcocktail.di

import com.jhonny.punkbeer.data.entities.beer.CocktailDataSource
import com.jhonny.punkbeer.data.entities.beer.CocktailRepository
import com.jhonny.punkbeer.data.entities.beer.mapper.CocktailMapper
import com.jhonny.punkbeer.data.entities.beer.remote.CocktailRemoteDataSource
import com.jhonny.punkbeer.data.entities.beer.remote.CocktailRemoteDataSourceImpl
import com.jhonny.punkbeer.data.entities.beer.service.CocktailService
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
        cocktailRemoteDataSource: CocktailRemoteDataSource,
        cocktailMapper: CocktailMapper
    ) = CocktailRepository(
        cocktailRemoteDataSource,
        cocktailMapper
    )

    @Singleton
    @Provides
    fun cocktailDataSourceImplProvider(
        cocktailService: CocktailService
    ) = CocktailRemoteDataSourceImpl(
        cocktailService
    )

    @Singleton
    @Provides
    fun cocktailDataSourceProvider(
        cocktailRemoteDataSource: CocktailRemoteDataSource,
        cocktailMapper: CocktailMapper
    ): CocktailDataSource = CocktailRepository(
        cocktailRemoteDataSource,
        cocktailMapper
    )

    @Singleton
    @Provides
    fun cocktailRemoteDataSourceProvider(
        cocktailService: CocktailService
    ): CocktailRemoteDataSource = CocktailRemoteDataSourceImpl(
        cocktailService
    )

}