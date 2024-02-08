package com.example.userapp.domain.repository

import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.data.data_sources.network.model.User
import kotlinx.coroutines.flow.Flow

interface UserLocalRepository {

    fun getUserList() : Flow<List<UserDbEntities>>

    suspend fun insertUser(userDbEntities: UserDbEntities)
    suspend fun deleteAllUser()
}