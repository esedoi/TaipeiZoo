package com.example.taipeizoo.network


import com.example.taipeizoo.model.AnimalResponse
import com.example.taipeizoo.model.ZooAreaResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun getExhibits(): Response<ZooAreaResponse>

    @GET("api/v1/dataset/a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire")
    suspend fun getAnimals(): Response<AnimalResponse>
}