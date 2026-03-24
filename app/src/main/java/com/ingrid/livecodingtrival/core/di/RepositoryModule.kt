package com.ingrid.livecodingtrival.core.di

import com.ingrid.livecodingtrival.data.repositoryImpl.CategoriesRepositoryImpl
import com.ingrid.livecodingtrival.domain.repository.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun categoriesRepository(categoriesRepositoryImpl: CategoriesRepositoryImpl) : CategoriesRepository
}