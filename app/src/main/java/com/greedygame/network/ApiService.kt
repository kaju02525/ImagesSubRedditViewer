package com.greedygame.network


import com.greedygame.model.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("/r/images/hot.json")
    fun getAsync(): Deferred<Response<ApiResponse>>

}