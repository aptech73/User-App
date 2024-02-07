package com.example.userapp.di

import com.example.userapp.domain.repository.UserListRepository
import com.example.userapp.domain.use_cases.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesGetUserListUseCase(userListRepository: UserListRepository) =
        GetUserListUseCase(userListRepository)
}