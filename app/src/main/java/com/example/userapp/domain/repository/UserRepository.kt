package com.example.userapp.domain.repository

import com.example.userapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserList() : Flow<List<User>>
}