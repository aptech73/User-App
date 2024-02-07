package com.example.userapp.domain.repository

import com.example.userapp.data.data_sources.network.model.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface UserListRepository {
    suspend fun getUserList(countUser : Int) : Flow<NetworkResponse>
}