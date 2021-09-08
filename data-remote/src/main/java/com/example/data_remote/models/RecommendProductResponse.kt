package com.example.data_remote.models


import com.google.gson.annotations.SerializedName

data class RecommendProductResponse(

    @SerializedName("recommend1")
    var recommend1: List<RecommendResponse>,

    @SerializedName("recommend2")
    var recommend2: List<RecommendResponse>,

    @SerializedName("recommend3")
    var recommend3: List<RecommendResponse>

    )