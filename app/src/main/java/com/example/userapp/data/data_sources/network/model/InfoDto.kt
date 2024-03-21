package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class InfoDto (
    val seed : String,
    val results : Int,
    val page : Int,
    val version : String
)