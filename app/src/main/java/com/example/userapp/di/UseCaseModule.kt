package com.example.userapp.di

import com.example.userapp.domain.repository.UserLocalRepository
import com.example.userapp.domain.repository.UserRemoteRepository
import com.example.userapp.domain.use_cases.DeleteLocalUserListUseCase
import com.example.userapp.domain.use_cases.GetLocalUserListUseCase
import com.example.userapp.domain.use_cases.GetRemoteUserListUseCase
import com.example.userapp.domain.use_cases.InsertLocalUserListUseCase
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
    fun provideGetRemoteUserListUseCase(userRemoteRepository: UserRemoteRepository) =
        GetRemoteUserListUseCase(userRemoteRepository)

    @Singleton
    @Provides
    fun provideGetLocalUserListUseCase(userLocalRepository: UserLocalRepository) =
        GetLocalUserListUseCase(userLocalRepository)

    @Singleton
    @Provides
    fun provideInsertLocalUserListUseCase(userLocalRepository: UserLocalRepository) =
        InsertLocalUserListUseCase(userLocalRepository)

    @Singleton
    @Provides
    fun provideDeleteLocalUserListUseCase(userLocalRepository: UserLocalRepository) =
        DeleteLocalUserListUseCase(userLocalRepository)
}