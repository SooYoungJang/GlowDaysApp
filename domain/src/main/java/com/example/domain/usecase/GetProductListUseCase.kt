package com.example.domain.usecase

import com.example.domain.repository.GlowDaysRepository

class GetProductListUseCase(private val glowDaysRepository: GlowDaysRepository) {

    suspend fun execute(page:Int) = glowDaysRepository.getProductList(page)

}