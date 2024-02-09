package com.example.userapp.ui.screens.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.domain.use_cases.DeleteLocalUserListUseCase
import com.example.userapp.domain.use_cases.GetLocalUserListUseCase
import com.example.userapp.domain.use_cases.GetRemoteUserListUseCase
import com.example.userapp.domain.use_cases.InsertLocalUserListUseCase
import com.example.userapp.utils.LoadState
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

    private val _uiState = MutableStateFlow(UserListUiState())
    val uiState : StateFlow<UserListUiState> = _uiState

    private val userDbEntities : MutableList<UserDbEntities> = mutableListOf()

    init {
        viewModelScope.launch {
            getLocalUserListUseCase().collect {
                _uiState.value = UserListUiState(LoadState.SUCCESS, it)
            }
        }
    }

    fun getUserList() {
        viewModelScope.launch {
            _uiState.value = UserListUiState()
            userDbEntities.clear()
            deleteLocalUserListUseCase()
            getRemoteUserListUseCase(20).collect {
                it.results.forEach { user ->
                    val tempUserDbEntities = _converterNetworkToDb(user)
                    userDbEntities.add(tempUserDbEntities)
                    insertLocalUserListUseCase(tempUserDbEntities)
                }
                _uiState.value = UserListUiState(LoadState.SUCCESS, userDbEntities)
            }
        }
    }

    private fun _converterNetworkToDb(user: User) : UserDbEntities {
        return UserDbEntities(
            user.name.first,
            user.name.last,
            user.name.title,
            user.email,
            user.picture.large,
            user.picture.medium,
            user.picture.thumbnail,
            user.nat,
            user.phone,
            user.cell,
            user.gender,
            user.dob.age,
            user.dob.date,
            user.id.name,
            user.id.value,
            user.location.city,
            user.location.state,
            user.location.street.name,
            user.location.street.number,
            user.location.timezone.description,
            user.location.timezone.offset,
            user.location.coordinates.latitude,
            user.location.coordinates.longitude,
            user.registered.age,
            user.registered.date,
            user.login.md5,
            user.login.password,
            user.login.salt,
            user.login.sha1,
            user.login.sha256,
            user.login.username,
            user.login.uuid
        )
    }
}