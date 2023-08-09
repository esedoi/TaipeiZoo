package com.example.taipeizoo.network

import android.content.Context
import com.example.taipeizoo.local.LocalDataSource
import com.example.taipeizoo.local.ZooDataSource
import com.example.taipeizoo.repository.ZooRepository
import com.example.taipeizoo.repository.ZooRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ZooNetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://data.taipei/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideLocalDataSource(context: Context): ZooDataSource = LocalDataSource(context)

    @Provides
    @Singleton
    fun provideDataRepository(apiService: ApiService, localDataSource: LocalDataSource): ZooRepositoryInterface = ZooRepository(apiService, localDataSource)

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }
}

