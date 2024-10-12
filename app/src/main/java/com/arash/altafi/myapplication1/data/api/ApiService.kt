package com.arash.altafi.myapplication1.data.api

import com.arash.altafi.myapplication1.data.model.ResponseUsers
import com.arash.altafi.myapplication1.utils.BaseService
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface ApiService: BaseService {
    @GET("users")
    suspend fun getUsers(
    ): Response<List<ResponseUsers>>

    @GET("users/{id}")
    suspend fun getUserDetails(
        @Path("id") id: Int
    ): Response<ResponseUsers>
}
