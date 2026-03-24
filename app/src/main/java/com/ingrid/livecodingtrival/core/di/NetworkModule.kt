package com.ingrid.livecodingtrival.core.di

import com.ingrid.livecodingtrival.core.di.NetworkManager.instanceRetrofit
import com.ingrid.livecodingtrival.data.remote.api.JokesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun categoriesApi() : JokesApi = instanceRetrofit.create(JokesApi::class.java)
}