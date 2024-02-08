package com.example.userapp.data.data_sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.data.data_sources.network.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUserList() : Flow<List<UserDbEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userDbEntities : UserDbEntities)

    @Query("DELETE FROM users")
    suspend fun deleteAllUser()
}