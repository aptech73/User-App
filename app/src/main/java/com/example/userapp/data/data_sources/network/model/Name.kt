package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val first: String,
    val last: String,
    val title: String
)