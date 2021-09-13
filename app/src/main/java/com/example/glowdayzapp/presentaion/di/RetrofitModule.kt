package com.example.glowdayzapp.presentaion.di

import androidx.databinding.ktx.BuildConfig
import com.example.data_remote.api.GlowDaysAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://s3.ap-northeast-2.amazonaws.com/public.glowday.com/"
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 20, TimeUnit.SECONDS))
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    level = HttpLoggingInterceptor.Level.BODY
                )
            )
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient) : GlowDaysAPIService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(BASE_URL)
            .build()
            .create(GlowDaysAPIService::class.java)
    }

}