package com.example.userapp.data

import com.example.userapp.data.data_sources.network.model.UserDto
import com.example.userapp.domain.model.User

fun UserDto.toDomain() : User {
    return User(
        titleName = this.name.title,
        firstName = this.name.first,
        lastName = this.name.last,
        email = this.email,
        image = this.picture.thumbnail,
        phone = this.phone
    )
}