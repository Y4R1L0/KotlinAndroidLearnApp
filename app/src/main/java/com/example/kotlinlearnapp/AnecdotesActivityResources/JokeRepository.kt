package com.example.kotlinlearnapp.AnecdotesActivityResources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeRepository {

    private val apiService: JokeApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(JokeApiService::class.java)
    }

    suspend fun getRandomJoke(): Result<JokeModel> {
        return try {
            Result.success(apiService.getRandomJoke())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
