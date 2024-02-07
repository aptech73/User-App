package com.example.userapp.domain.use_cases

import com.example.userapp.domain.repository.UserRemoteRepository
import javax.inject.Inject

class GetRemoteUserListUseCase @Inject constructor (
    private val userRemoteRepository: UserRemoteRepository
) {
    suspend operator fun invoke(countUser : Int) = userRemoteRepository.getUserList(countUser)
}