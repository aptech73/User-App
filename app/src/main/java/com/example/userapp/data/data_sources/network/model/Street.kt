package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val name: String,
    val number: Int
)