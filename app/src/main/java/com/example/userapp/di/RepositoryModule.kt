package com.example.userapp.di

import com.example.userapp.data.repository.UserListRepositoryImpl
import com.example.userapp.domain.repository.UserListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserListRepository(
        userListRepositoryImpl: UserListRepositoryImpl
    ) : UserListRepository
}