package com.example.userapp.domain.use_cases

import com.example.userapp.domain.repository.UserListRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor (
    private val userListRepository: UserListRepository
) {
    suspend operator fun invoke(countUser : Int) = userListRepository.getUserList(countUser)
}