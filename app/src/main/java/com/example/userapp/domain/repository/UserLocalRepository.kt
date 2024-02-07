package com.example.userapp.domain.repository

import com.example.userapp.data.data_sources.network.model.User
import kotlinx.coroutines.flow.Flow

interface UserLocalRepository {

    fun getUserList() : Flow<List<User>>

    suspend fun insertUser(user : User)
    suspend fun deleteAllUser()
}