package com.example.taipeizoo.repository

import com.example.taipeizoo.model.GetAnimalsResponse
import com.example.taipeizoo.model.GetExhibitsResponse
import retrofit2.Response

interface ZooRepositoryInterface {
    suspend fun getExhibits(): Response<GetExhibitsResponse>
    suspend fun getAnimals(): Response<GetAnimalsResponse>
}