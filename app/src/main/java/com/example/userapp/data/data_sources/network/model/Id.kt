package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Id(
    val name: String,
    val value: String?
)