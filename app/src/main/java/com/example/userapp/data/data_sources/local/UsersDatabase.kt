package com.example.userapp.data.data_sources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userapp.data.data_sources.local.model.UserDbEntities

@Database(entities = arrayOf(UserDbEntities::class), exportSchema = false, version = 1)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object {
        private const val DATABASE_NAME = "users"

        @Volatile
        private var instance: UsersDatabase? = null

        fun getInstance(context: Context) : UsersDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }
        private fun buildDatabase(context: Context): UsersDatabase {
            return Room.databaseBuilder(context, UsersDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}