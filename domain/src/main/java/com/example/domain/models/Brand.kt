package com.example.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Brand(
    val brandTitle: String,
    val idBrand: Int,
    val imageUrl: String
) : Parcelable
