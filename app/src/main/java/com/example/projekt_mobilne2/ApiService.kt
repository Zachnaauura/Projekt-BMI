// ApiService.kt
package com.example.projekt_mobilne2.network

import com.example.projekt_mobilne2.models.UserInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun predictGender(
        @Query("name") name: String
    ): UserInfoResponse
}