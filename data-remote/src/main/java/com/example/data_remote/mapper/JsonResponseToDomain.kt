package com.example.data_remote.mapper

import com.example.data_remote.models.*
import com.example.domain.models.*

internal fun RecommendProductListResponse.toDomain(): RecommendProductList {
    return RecommendProductList(
        this.recommendProduct1.map { it.toDomain() },
        this.recommendProduct2.map { it.toDomain() },
        this.recommendProduct3.map { it.toDomain() }
    )
}


internal fun RecommendProductResponse.toDomain(): RecommendProduct {
    return RecommendProduct(
        this.idProduct,
        this.productTitle,
        this.ratingAvg,
        this.reviewCount,
        this.imageUrl
    )
}


internal fun ProductListResponse.toDomain(): ProductList {
    return ProductList(
        this.products.map { it.toDomain() }
    )
}

internal fun ProductResponse.toDomain(): Product {
    return Product(
        this.brandResponse.toDomain(),
        this.idBrand,
        this.idProduct,
        this.imageUrl,
        this.price,
        this.productRank,
        this.productScore,
        this.productTitle,
        this.rankChange,
        this.rankChangeType,
        this.ratingAvg,
        this.reviewCount,
        this.volume,
    )
}

internal fun BrandResponse.toDomain(): Brand {
    return Brand(
        this.brandTitle,
        this.idBrand,
        this.imageUrl
    )
}
