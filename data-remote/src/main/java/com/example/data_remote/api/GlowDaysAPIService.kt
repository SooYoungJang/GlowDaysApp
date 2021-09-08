package com.example.data_remote.api

import com.example.data_remote.models.ProductResponse
import com.example.data_remote.models.RecommendProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GlowDaysAPIService {

    @GET("test/app/product.{page}.json")
    suspend fun searchProduct(@Path("page") page: Int): Response<ProductResponse>

    @GET("test/app/recommend_product.json")
    suspend fun searchRecommendProduct(): Response<RecommendProductResponse>

}