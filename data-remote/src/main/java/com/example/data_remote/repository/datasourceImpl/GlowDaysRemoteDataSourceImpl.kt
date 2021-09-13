package com.example.data_remote.repository.datasourceImpl

import com.example.data_remote.api.GlowDaysAPIClient
import com.example.data_remote.api.GlowDaysAPIService
import com.example.data_remote.models.ProductListResponse
import com.example.data_remote.models.RecommendProductListResponse
import com.example.data_remote.repository.datasource.GlowDaysRemoteDataSource


class GlowDaysRemoteDataSourceImpl(private val glowDaysAPIService: GlowDaysAPIService) : GlowDaysRemoteDataSource {

    override suspend fun getProductList(page: Int): ProductListResponse {
        return glowDaysAPIService.requestProductList(page)
    }

    override suspend fun getRecommendProductList(): RecommendProductListResponse {
        return glowDaysAPIService.requestRecommendProduct()
    }

}