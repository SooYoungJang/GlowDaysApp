package com.example.data_remote.repository

import com.example.data_remote.mapper.toDomain
import com.example.data_remote.repository.datasource.GlowDaysRemoteDataSource
import com.example.domain.models.ProductList
import com.example.domain.models.RecommendProductList
import com.example.domain.repository.GlowDaysRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GlowDaysRepositoryImpl(private val glowDaysRemoteDataSource: GlowDaysRemoteDataSource) : GlowDaysRepository {

    override suspend fun getProductList(page: Int): Flow<ProductList> = flow {
        emit(glowDaysRemoteDataSource.getProductList(page).toDomain())
    }

    override suspend fun getRecommendProductList(): Flow<RecommendProductList> = flow {
        emit(glowDaysRemoteDataSource.getRecommendProductList().toDomain())
    }

}