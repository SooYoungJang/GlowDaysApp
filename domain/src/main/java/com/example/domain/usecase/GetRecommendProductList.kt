package com.example.domain.usecase

import com.example.domain.repository.GlowDaysRepository

class GetRecommendProductList(private val glowDaysRepository: GlowDaysRepository) {

    suspend fun execute() = glowDaysRepository.getRecommendProductList()

}