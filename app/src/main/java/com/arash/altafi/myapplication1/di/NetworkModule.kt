package com.arash.altafi.myapplication1.di

import com.arash.altafi.myapplication1.BuildConfig
import com.arash.altafi.myapplication1.data.api.ApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("BASE_URL")
    fun provideBaseURL(): String {
        return BuildConfig.BASE_URL
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named("BASE_URL") baseURL: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}