package com.example.data_remote.repository.datasource

import com.example.data_remote.models.ProductListResponse
import com.example.data_remote.models.ProductResponse
import com.example.data_remote.models.RecommendProductListResponse
import com.example.domain.models.Brand
import com.example.domain.models.Product
import com.example.domain.models.ProductList
import com.example.domain.models.RecommendProductList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface GlowDaysRemoteDataSource {

    suspend fun getProductList(page: Int) : ProductListResponse

    suspend fun getRecommendProductList() : RecommendProductListResponse
}