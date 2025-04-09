package com.example.genericapi.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ApiResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResponse(response: ApiResponseEntity)

    @Query("SELECT * FROM api_responses WHERE url = :url")
    suspend fun getResponse(url: String): ApiResponseEntity?

    @Query("DELETE FROM api_responses WHERE url = :url")
    suspend fun deleteResponse(url: String)
}
