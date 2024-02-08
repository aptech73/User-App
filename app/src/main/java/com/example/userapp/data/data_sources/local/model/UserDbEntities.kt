package com.example.userapp.data.data_sources.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbEntities(
    @PrimaryKey
    val name : String,
    val email : String,
    val image : String
)