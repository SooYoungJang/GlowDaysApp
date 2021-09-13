package com.example.data_remote.api

import com.example.data_remote.models.ProductListResponse
import com.example.data_remote.models.ProductResponse
import com.example.data_remote.models.RecommendProductListResponse
import com.example.data_remote.models.RecommendProductResponse
import com.example.domain.models.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GlowDaysAPIService {

    @GET("test/app/product.{page}.json")
    suspend fun requestProductList(@Path("page") page: Int): ProductListResponse

    @GET("test/app/recommend_product.json")
    suspend fun requestRecommendProduct(): RecommendProductListResponse

}