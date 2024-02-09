package com.example.userapp.ui.screens.user_list

import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.utils.LoadState
import java.lang.Exception

//sealed class UserListUiState {
//    data class Success(val userList : List<UserDbEntities>) : UserListUiState()
//    data class Error (val exception: Exception) : UserListUiState()
//}

data class UserListUiState (
    val loadState : LoadState = LoadState.LOADING,
    val userList : List<UserDbEntities> = listOf(),
    val errorMessage : String? = null
)