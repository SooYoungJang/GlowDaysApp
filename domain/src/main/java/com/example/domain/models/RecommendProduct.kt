package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecommendProduct(
    var idProduct: Int = 0,
    var productTitle: String = "",
    var ratingAvg: Double = 0.0,
    var reviewCount: String = "",
    var imageUrl: String = "",
) : Parcelable
