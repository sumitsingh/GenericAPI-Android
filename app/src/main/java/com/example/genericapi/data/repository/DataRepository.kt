package com.example.genericapi.data.repository

import com.example.genericapi.data.local.ApiResponseDao
import com.example.genericapi.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataRepository(
    private val api: ApiService,
    private val dao: ApiResponseDao
) {
    suspend fun fetchData(url: String): Flow<Result<String>> = flow {
        try {
            // Check cache first
            val cached = dao.getResponse(url)
            if (cached != null) {
                emit(Result.success(cached.response))
            }

            // Fetch from network
            val response = api.fetchData(url)
            val jsonResponse = response.toString()
            dao.insertResponse(ApiResponseEntity(url, jsonResponse))
            emit(Result.success(jsonResponse))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
