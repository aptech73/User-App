package com.example.userapp.data.data_sources.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
) : Parcelable