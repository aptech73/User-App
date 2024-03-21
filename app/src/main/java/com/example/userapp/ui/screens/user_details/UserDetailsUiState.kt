package com.example.userapp.ui.screens.user_details

import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.domain.model.User
import com.example.userapp.utils.LoadState

//sealed class UserDetailsUiState {
//    data class Success(val pass : String) : UserDetailsUiState()
//    data class Error (val exception: Exception) : UserDetailsUiState()
//}

data class UserDetailsUiState (
    val loadState : LoadState = LoadState.LOADING,
    val user : User? = null,
    val errorMessage : String? = null
)