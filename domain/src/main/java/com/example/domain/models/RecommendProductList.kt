package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecommendProductList(
    var recommendProduct1: List<RecommendProduct>,
    var recommendProduct2: List<RecommendProduct>,
    var recommendProduct3: List<RecommendProduct>
) : Parcelable
