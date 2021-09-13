package com.example.glowdayzapp.presentaion.di

import com.example.domain.repository.GlowDaysRepository
import com.example.domain.usecase.GetProductListUseCase
import com.example.domain.usecase.GetRecommendProductList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetProductListFromAPIUseCase(glowDaysRepository: GlowDaysRepository) : GetProductListUseCase {
        return GetProductListUseCase(glowDaysRepository)
    }

    @Singleton
    @Provides
    fun provideGetRecommendListFromAPIUseCase(glowDaysRepository: GlowDaysRepository) : GetRecommendProductList {
        return GetRecommendProductList(glowDaysRepository)
    }
}