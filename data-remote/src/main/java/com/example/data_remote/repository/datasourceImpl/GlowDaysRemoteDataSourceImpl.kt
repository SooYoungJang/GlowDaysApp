package com.example.data_remote.repository.datasourceImpl

import com.example.data_remote.api.GlowDaysAPIClient
import com.example.data_remote.models.ProductListResponse
import com.example.data_remote.models.RecommendProductListResponse
import com.example.data_remote.repository.datasource.GlowDaysRemoteDataSource


class GlowDaysRemoteDataSourceImpl : GlowDaysRemoteDataSource {

    override suspend fun getProductList(page: Int): ProductListResponse {
        return GlowDaysAPIClient.get().requestProductList(page)
    }

    override suspend fun getRecommendProductList(): RecommendProductListResponse {
        return GlowDaysAPIClient.get().requestRecommendProduct()
    }

}