package com.example.userapp.di

import android.content.Context
import com.example.userapp.data.data_sources.local.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideUsersDatabase(@ApplicationContext context : Context) =
        UsersDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideUserDao(database : UsersDatabase) = database.getUserDao()
}