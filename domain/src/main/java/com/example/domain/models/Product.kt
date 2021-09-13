package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val brandResponse: Brand,
    val idBrand: Int,
    val idProduct: Int,
    val imageUrl: String,
    val price: Int,
    val productRank: String,
    val productScore: Double,
    val productTitle: String,
    val rankChange: String,
    val rankChangeType: String,
    val ratingAvg: Double,
    val reviewCount: String,
    val volume: String
) : Parcelable
