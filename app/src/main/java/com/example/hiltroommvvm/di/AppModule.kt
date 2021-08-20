package com.example.hiltroommvvm.di

import com.example.hiltroommvvm.data.remote.ApiHelper
import com.example.hiltroommvvm.data.remote.RetrofitApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiHelper(retrofitApp: RetrofitApp): ApiHelper {
        return retrofitApp.apiHelper
    }


}