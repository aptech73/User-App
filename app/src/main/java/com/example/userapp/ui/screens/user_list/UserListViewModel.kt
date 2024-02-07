package com.example.userapp.ui.screens.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.domain.use_cases.DeleteLocalUserListUseCase
import com.example.userapp.domain.use_cases.GetLocalUserListUseCase
import com.example.userapp.domain.use_cases.GetRemoteUserListUseCase
import com.example.userapp.domain.use_cases.InsertLocalUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getLocalUserListUseCase: GetLocalUserListUseCase,
    private val getRemoteUserListUseCase: GetRemoteUserListUseCase,
    private val insertLocalUserListUseCase: InsertLocalUserListUseCase,
    private val deleteLocalUserListUseCase: DeleteLocalUserListUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(UserListUiState.Success(emptyList()))
    val uiState : StateFlow<UserListUiState> = _uiState

    init {
        viewModelScope.launch {
            getLocalUserListUseCase.invoke().collect {
                _uiState.value = UserListUiState.Success(it)
            }
        }
    }

    fun getUserList() {
        viewModelScope.launch {
            deleteLocalUserListUseCase.invoke()
            getRemoteUserListUseCase.invoke(10).collect {
                _uiState.value = UserListUiState.Success(it.results)
                it.results.forEach { user ->
                    insertLocalUserListUseCase.invoke(user)
                }
            }
        }
    }
}