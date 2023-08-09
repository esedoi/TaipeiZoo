package com.example.taipeizoo.data.local

import com.example.taipeizoo.data.GetAnimalsResponse
import com.example.taipeizoo.data.GetExhibitsResponse
import retrofit2.Response

interface ZooDataSource {
    suspend fun getExhibits(): Response<GetExhibitsResponse>
    suspend fun getAnimals(): Response<GetAnimalsResponse>
}