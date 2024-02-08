package com.example.userapp.data.data_sources.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Street(
    val name: String,
    val number: Int
) : Parcelable