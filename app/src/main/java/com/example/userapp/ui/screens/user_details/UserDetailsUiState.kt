package com.example.userapp.ui.screens.user_details

import com.example.userapp.data.data_sources.network.model.User
import java.lang.Exception

sealed class UserDetailsUiState {
    data class Success(val pass : String) : UserDetailsUiState()
    data class Error (val exception: Exception) : UserDetailsUiState()
}