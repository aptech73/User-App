package com.example.userapp.data.repository

import com.example.userapp.data.data_sources.local.UserDao
import com.example.userapp.data.data_sources.network.api.UserListService
import com.example.userapp.data.toDataDb
import com.example.userapp.data.toDomain
import com.example.userapp.domain.model.User
import com.example.userapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userListService : UserListService,
    private val userDao: UserDao
) : UserRepository {

    override fun getUserList(): Flow<List<User>> {
//        return flow {
//            userDao.getUserList().collect{ it.map { it.toDomain() } }
//        }
        return flow {
            emit(userListService.getUserList(10).results.map {
                it.toDomain()
            })
        }
    }

    override suspend fun insertUserIntoDb(user: User) {
        userDao.insertUser(user.toDataDb())
    }

    override suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }

}