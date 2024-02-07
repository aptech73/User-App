package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val latitude: String,
    val longitude: String
)