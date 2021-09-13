package com.example.data_remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GlowDaysAPIClient {

    private val client by lazy {
        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    private const val BASE_URL = "https://s3.ap-northeast-2.amazonaws.com/public.glowday.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val service: GlowDaysAPIService = retrofit.create(GlowDaysAPIService::class.java)


    fun get(): GlowDaysAPIService {
        return service
    }
}