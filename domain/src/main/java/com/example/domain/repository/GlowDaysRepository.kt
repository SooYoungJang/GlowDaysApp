package com.example.domain.repository

import com.example.domain.models.ProductList
import com.example.domain.models.RecommendProductList
import kotlinx.coroutines.flow.Flow

interface GlowDaysRepository {

    suspend fun getRecommendProductList() : Flow<RecommendProductList>

    suspend fun getProductList(page: Int) : Flow<ProductList>
}