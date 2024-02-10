package com.example.userapp.ui.screens.user_details

import androidx.lifecycle.ViewModel
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.utils.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UserDetailsUiState())
    val uiState
        get() = _uiState.asStateFlow()

    fun checkUserDetails(userDbEntities: UserDbEntities) {
        _uiState.value = UserDetailsUiState(LoadState.SUCCESS, userDbEntities)
    }
}