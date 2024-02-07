package com.example.userapp.domain.use_cases

import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.domain.repository.UserLocalRepository
import javax.inject.Inject

class InsertLocalUserListUseCase @Inject constructor(
    private val userLocalRepository: UserLocalRepository
){
    suspend operator fun invoke(user : User) = userLocalRepository.insertUser(user)
}