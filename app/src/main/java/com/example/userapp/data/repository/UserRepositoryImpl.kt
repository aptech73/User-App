package com.example.userapp.data.repository

import com.example.userapp.data.data_sources.network.api.UserListService
import com.example.userapp.data.toDomain
import com.example.userapp.domain.model.User
import com.example.userapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userListService : UserListService
) : UserRepository {

    override fun getUserList(): Flow<List<User>> {
        return flow {
            emit(userListService.getUserList(10).results.map {
                it.toDomain()
            })
        }
    }

}