package com.example.userapp.di

import com.example.userapp.data.repository.UserLocalRepositoryImpl
import com.example.userapp.data.repository.UserRepositoryImpl
import com.example.userapp.domain.repository.UserLocalRepository
import com.example.userapp.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserLocalRepository(
        userLocalRepositoryImpl: UserLocalRepositoryImpl
    ) : UserLocalRepository

    @Binds
    abstract fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ) : UserRepository
}