package com.example.taipeizoo.model

import com.example.taipeizoo.network.ApiService
import retrofit2.Response
import javax.inject.Inject
import kotlin.Result

class ZooRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getData(): Response<ZooAreaResponse> = apiService.getData()

}