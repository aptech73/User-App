package com.example.userapp.data.repository

import com.example.userapp.data.data_sources.local.UserDao
import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.domain.repository.UserLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLocalRepositoryImpl @Inject constructor(private val userDao : UserDao):
    UserLocalRepository {
    override fun getUserList(): Flow<List<User>> = userDao.getUserList()

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}