package com.example.userapp.ui.screens.user_list

import com.example.userapp.domain.model.User
import com.example.userapp.utils.LoadState

data class UserListUiState (
    val loadState : LoadState = LoadState.LOADING,
    val userList : List<User> = listOf(),
    val errorMessage : String? = null
)