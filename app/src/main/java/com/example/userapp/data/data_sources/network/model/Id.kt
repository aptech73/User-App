package com.example.userapp.data.data_sources.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Id(
    val name: String,
    val value: String?
) : Parcelable