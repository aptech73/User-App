package com.example.userapp.data.data_sources.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val email: String,
    val gender: String,
    val name: NameDto,
    val nat: String,
    val phone: String,
    val picture: PictureDto,
)