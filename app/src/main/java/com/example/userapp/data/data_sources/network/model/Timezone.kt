package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    val description: String,
    val offset: String
)