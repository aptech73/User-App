package com.example.userapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val titleName : String,
    val firstName : String,
    val lastName : String,
    val email : String,
    val image : String,
    val phone : String
) : Parcelable