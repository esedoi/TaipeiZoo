package com.example.taipeizoo.local

import com.example.taipeizoo.model.GetAnimalsResponse
import com.example.taipeizoo.model.GetExhibitsResponse
import retrofit2.Response

interface ZooDataSource {
    suspend fun getExhibits(): Response<GetExhibitsResponse>
    suspend fun getAnimals(): Response<GetAnimalsResponse>
}