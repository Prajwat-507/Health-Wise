package com.example.healthwise.di

import com.example.healthwise.api.DiseaseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// We use SingletonComponent because we need just one instance of our retrofit obj in out whole project

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDiseaseApi(retrofit: Retrofit): DiseaseApi{
        return retrofit.create(DiseaseApi::class.java)
    }

}