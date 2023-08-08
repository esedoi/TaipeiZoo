package com.example.taipeizoo.model

import com.example.taipeizoo.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class ZooRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getExhibits(): Response<ZooAreaResponse> = apiService.getExhibits()
    suspend fun getAnimals(): Response<AnimalResponse> = apiService.getAnimals()

}