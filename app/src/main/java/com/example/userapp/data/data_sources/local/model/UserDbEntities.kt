package com.example.userapp.data.data_sources.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class UserDbEntities(
    @PrimaryKey
    val nameFirst : String,
    val nameLast : String,
    val nameTitle : String,
    val email : String,
    val pictureLarge : String,
    val pictureMedium : String,
    val pictureThumbnail : String,
    val nat: String,
    val phone: String,
    val cell : String,
    val gender : String,
    val dobAge : Int,
    val dobDate : String,
    val idName : String,
    val idValue : String?,
    val locationCity : String,
    val locationState : String,
    val locationStreetName : String,
    val locationStreetNumber : Int,
    val locationTimezoneDescription: String,
    val locationTimezoneOffset : String,
    val locationLatitude : String,
    val locationLongitude : String,
    val registeredAge : Int,
    val registeredDate : String,
    val loginMd5 : String,
    val loginPassword : String,
    val loginSalt : String,
    val loginSha1 : String,
    val loginSha256 : String,
    val loginUsername : String,
    val loginUuid : String
) : Parcelable