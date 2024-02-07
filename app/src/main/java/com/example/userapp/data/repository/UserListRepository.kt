package com.example.userapp.data.repository

import com.example.userapp.data.data_sources.network.api.UserListService
import com.example.userapp.data.data_sources.network.model.NetworkResponse
import com.example.userapp.domain.repository.UserListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor (
    private val service : UserListService
) : UserListRepository {
    override suspend fun getUserList(countUser : Int) : Flow<NetworkResponse> =
        flow {
            emit(service.getUserList(countUser))
        }
}