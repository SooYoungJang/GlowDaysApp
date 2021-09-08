package com.example.data_remote.models


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("brand")
    val brand: Brand,
    @SerializedName("idBrand")
    val idBrand: Int,
    @SerializedName("idProduct")
    val idProduct: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("productRank")
    val productRank: String,
    @SerializedName("productScore")
    val productScore: Double,
    @SerializedName("productTitle")
    val productTitle: String,
    @SerializedName("rankChange")
    val rankChange: String,
    @SerializedName("rankChangeType")
    val rankChangeType: String,
    @SerializedName("ratingAvg")
    val ratingAvg: Double,
    @SerializedName("reviewCount")
    val reviewCount: String,
    @SerializedName("volume")
    val volume: String
)