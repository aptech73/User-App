package com.example.userapp.data.data_sources.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbDto(
    @PrimaryKey
    val titleName : String,
    val firstName : String,
    val lastName : String,
    val email : String,
    val image : String,
    val phone : String
)