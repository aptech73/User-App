package com.example.userapp.data.data_sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userapp.data.data_sources.local.model.UserDbDto
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUserList() : Flow<List<UserDbDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : UserDbDto)

    @Query("DELETE FROM users")
    suspend fun deleteAllUser()
}