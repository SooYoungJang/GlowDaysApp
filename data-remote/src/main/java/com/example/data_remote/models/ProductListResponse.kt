package com.example.data_remote.models


import com.google.gson.annotations.SerializedName

data class ProductListResponse(
    @SerializedName("products")
    val products: List<ProductResponse>
)

