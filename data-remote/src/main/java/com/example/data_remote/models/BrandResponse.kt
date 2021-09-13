package com.example.data_remote.models


import com.google.gson.annotations.SerializedName

data class BrandResponse(
    @SerializedName("brandTitle")
    val brandTitle: String,
    @SerializedName("idBrand")
    val idBrand: Int,
    @SerializedName("imageUrl")
    val imageUrl: String
)