package com.example.glowdayzapp.presentaion.di

import com.example.data_remote.repository.GlowDaysRepositoryImpl
import com.example.data_remote.repository.datasource.GlowDaysRemoteDataSource
import com.example.domain.repository.GlowDaysRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GlowDaysRepositoryModule {

    @Singleton
    @Provides
    fun provideGlowDaysRepository(glowDaysRemoteDataSource: GlowDaysRemoteDataSource) : GlowDaysRepository {
        return  GlowDaysRepositoryImpl(glowDaysRemoteDataSource)
    }
}
