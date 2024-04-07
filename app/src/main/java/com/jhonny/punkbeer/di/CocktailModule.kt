package com.jhonny.punkbeer.di

import com.jhonny.punkbeer.domain.usecases.GetCocktailsByNameUseCase
import com.jhonny.punkbeer.domain.usecases.GetCocktailsUseCase
import com.jhonny.punkbeer.presenter.favorites.FavoriteViewModel
import com.jhonny.punkbeer.presenter.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CocktailModule {

    @Provides
    fun beerViewModelProvider(
        getAllBeersUseCase: GetCocktailsUseCase,
        getBeersByNameUseCase: GetCocktailsByNameUseCase
    ) = MainViewModel (
        getAllBeersUseCase,
        getBeersByNameUseCase
    )

    @Provides
    fun favoriteViewModelProvider(

    ) = FavoriteViewModel ()
}