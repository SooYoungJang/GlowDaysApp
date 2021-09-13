package com.example.data_remote.models


import com.google.gson.annotations.SerializedName

data class RecommendProductListResponse(

    @SerializedName("recommend1")
    var recommendProduct1: List<RecommendProductResponse>,

    @SerializedName("recommend2")
    var recommendProduct2: List<RecommendProductResponse>,

    @SerializedName("recommend3")
    var recommendProduct3: List<RecommendProductResponse>

    )