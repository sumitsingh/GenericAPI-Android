package com.example.genericapi.data.network

import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun fetchData(@Url url: String): List<Any> // Generic response type
}
