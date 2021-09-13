package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductList(
    val productResponses: List<Product>
) : Parcelable
