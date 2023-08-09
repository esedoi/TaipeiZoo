package com.example.taipeizoo.data.repository

import com.example.taipeizoo.data.local.ZooDataSource
import com.example.taipeizoo.data.GetAnimalsResponse
import com.example.taipeizoo.data.GetExhibitsResponse
import com.example.taipeizoo.data.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class ZooRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: ZooDataSource
) : ZooRepositoryInterface {
    override suspend fun getExhibits(): Response<GetExhibitsResponse> = apiService.getExhibits()
    override suspend fun getAnimals(): Response<GetAnimalsResponse> = apiService.getAnimals()
    override suspend fun getExhibitsFromJson(): Response<GetExhibitsResponse> = localDataSource.getExhibits()
    override suspend fun getAnimalsFromJson(): Response<GetAnimalsResponse>  = localDataSource.getAnimals()

}