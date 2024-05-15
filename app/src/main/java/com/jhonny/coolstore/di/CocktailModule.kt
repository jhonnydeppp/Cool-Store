package com.jhonny.coolstore.di

import com.jhonny.coolstore.domain.usecases.GetProductsUseCase
import com.jhonny.coolstore.presenter.resume.ResumeViewModel
import com.jhonny.coolstore.presenter.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CocktailModule {

    @Provides
    fun productViewModelProvider(
        getProductsUseCase: GetProductsUseCase
    ) = MainViewModel (
        getProductsUseCase
    )

    @Provides
    fun favoriteViewModelProvider(

    ) = ResumeViewModel ()
}