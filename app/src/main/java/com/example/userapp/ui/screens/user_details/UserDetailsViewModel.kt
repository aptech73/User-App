package com.example.userapp.ui.screens.user_details

import androidx.lifecycle.ViewModel
import com.example.userapp.data.data_sources.network.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UserDetailsUiState.Success(""))
    val uiState
        get() = _uiState.asStateFlow()


    fun checkUserDetails(user : User) {

    }
}