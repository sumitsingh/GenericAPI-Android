package com.example.genericapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "api_responses")
data class ApiResponseEntity(
    @PrimaryKey val url: String,
    val response: String,
    val timestamp: Long = System.currentTimeMillis()
)
