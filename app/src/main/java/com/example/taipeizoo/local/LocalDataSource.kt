package com.example.taipeizoo.local

import android.content.Context
import android.util.Log
import com.example.taipeizoo.model.GetAnimalsResponse
import com.example.taipeizoo.model.GetExhibitsResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val context: Context
) : ZooDataSource {

    private val gson = Gson()
    override suspend fun getExhibits(): Response<GetExhibitsResponse> {
        return try {
            val json = loadJsonFromFile("exhibits.json")
            val exhibitType = object : TypeToken<GetExhibitsResponse>() {}.type
            val response = gson.fromJson<GetExhibitsResponse>(json, exhibitType)
            return Response.success(response)

        } catch (e: Exception) {
            Response.error(500, ResponseBody.create(null, e.message ?: ""))
        }
    }

    override suspend fun getAnimals(): Response<GetAnimalsResponse> {
        return try {
            val json = loadJsonFromFile("animals.json")
            val animalType = object : TypeToken<GetAnimalsResponse>() {}.type
            val response = gson.fromJson<GetAnimalsResponse>(json, animalType)
            return Response.success(response)
        } catch (e: Exception) {
            Response.error(500, ResponseBody.create(null, e.message ?: ""))
        }
    }


    private fun loadJsonFromFile(fileName: String): String {
        val originalJson = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return originalJson.replace("\uFEFF", "")
    }

}