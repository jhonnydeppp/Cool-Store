package com.jhonny.coolstore.di

import com.jhonny.coolstore.data.APIConstants.BASE_API_URL
import com.jhonny.coolstore.data.entities.beer.service.ProductService
import com.jhonny.coolstore.util.OkHttpHelper.getOkHttpBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @DefaultClient
    fun providesClientOkhttp(
    ) = getOkHttpBuilder()
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private inline fun <reified T : Any> provideService(
        okhttpClient: OkHttpClient
    ): T {
        return providesRetrofit(okhttpClient).create(T::class.java)
    }

    @Singleton
    @Provides
    fun provideBeerService(
        @DefaultClient okHttpClient: OkHttpClient
    ) = provideService<ProductService>(okHttpClient)

}