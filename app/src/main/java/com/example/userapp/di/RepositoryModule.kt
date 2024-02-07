package com.example.userapp.di

import com.example.userapp.data.repository.UserLocalRepositoryImpl
import com.example.userapp.data.repository.UserRemoteRepositoryImpl
import com.example.userapp.domain.repository.UserLocalRepository
import com.example.userapp.domain.repository.UserRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserRemoteRepository(
        userRemoteRepositoryImpl: UserRemoteRepositoryImpl
    ) : UserRemoteRepository

    @Binds
    abstract fun provideUserLocalRepository(
        userLocalRepositoryImpl: UserLocalRepositoryImpl
    ) : UserLocalRepository
}