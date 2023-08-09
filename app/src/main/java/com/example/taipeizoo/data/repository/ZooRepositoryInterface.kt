package com.example.taipeizoo.data.repository

import com.example.taipeizoo.data.GetAnimalsResponse
import com.example.taipeizoo.data.GetExhibitsResponse
import retrofit2.Response

interface ZooRepositoryInterface {
    suspend fun getExhibits(): Response<GetExhibitsResponse>
    suspend fun getAnimals(): Response<GetAnimalsResponse>
    suspend fun getExhibitsFromJson(): Response<GetExhibitsResponse>
    suspend fun getAnimalsFromJson(): Response<GetAnimalsResponse>
}