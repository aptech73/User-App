package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    val age: Int,
    val date: String
)