package com.example.userapp.domain.use_cases

import com.example.userapp.domain.repository.UserLocalRepository
import javax.inject.Inject

class DeleteLocalUserListUseCase @Inject constructor(private val userLocalRepository: UserLocalRepository) {
    suspend operator fun invoke() = userLocalRepository.deleteAllUser()
}