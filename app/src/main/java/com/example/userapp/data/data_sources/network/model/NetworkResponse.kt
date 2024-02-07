package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse(
    @SerialName("results")
    val results: List<User>
)