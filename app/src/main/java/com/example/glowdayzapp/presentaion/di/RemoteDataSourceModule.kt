package com.example.glowdayzapp.presentaion.di

import com.example.data_remote.api.GlowDaysAPIService
import com.example.data_remote.repository.datasource.GlowDaysRemoteDataSource
import com.example.data_remote.repository.datasourceImpl.GlowDaysRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideGlowDaysRemoteDataSource(glowDaysAPIService: GlowDaysAPIService) : GlowDaysRemoteDataSource {
        return GlowDaysRemoteDataSourceImpl(glowDaysAPIService)
    }

}