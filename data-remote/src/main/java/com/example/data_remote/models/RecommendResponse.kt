package com.example.data_remote.models

import com.google.gson.annotations.SerializedName

data class RecommendResponse(
    @SerializedName("idProduct")
    var idProduct: Int = 0,

    @SerializedName("productTitle")
    var productTitle: String = "",

    @SerializedName("ratingAvg")
    var ratingAvg: Double = 0.0,

    @SerializedName("reviewCount")
    var reviewCount: String = "",

    @SerializedName("imageUrl")
    var imageUrl: String = "",
)
