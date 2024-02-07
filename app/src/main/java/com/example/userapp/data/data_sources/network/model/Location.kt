package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val state: String,
    val street: Street,
    val timezone: Timezone
)