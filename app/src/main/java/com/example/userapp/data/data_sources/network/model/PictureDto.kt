package com.example.userapp.data.data_sources.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
data class PictureDto(
    val large: String,
    val medium: String,
    val thumbnail: String
)