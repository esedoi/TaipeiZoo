package com.example.taipeizoo.repository

import com.example.taipeizoo.model.GetAnimalsResponse
import com.example.taipeizoo.model.GetExhibitsResponse
import com.example.taipeizoo.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class ZooRepository @Inject constructor(private val apiService: ApiService):
    ZooRepositoryInterface {
    override suspend fun getExhibits(): Response<GetExhibitsResponse> = apiService.getExhibits()
    override suspend fun getAnimals(): Response<GetAnimalsResponse> = apiService.getAnimals()

}