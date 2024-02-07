package com.example.userapp.data.data_sources.network.api

import com.example.userapp.data.data_sources.network.model.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserListService {
    @GET(".")
    suspend fun getUserList(@Query("results") countUser : Int) : NetworkResponse
}