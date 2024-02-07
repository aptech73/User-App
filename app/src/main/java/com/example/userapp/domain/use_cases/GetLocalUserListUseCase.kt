package com.example.userapp.domain.use_cases

import com.example.userapp.domain.repository.UserLocalRepository
import javax.inject.Inject

class GetLocalUserListUseCase @Inject constructor(private val userLocalRepository: UserLocalRepository) {
    operator fun invoke() = userLocalRepository.getUserList()
}