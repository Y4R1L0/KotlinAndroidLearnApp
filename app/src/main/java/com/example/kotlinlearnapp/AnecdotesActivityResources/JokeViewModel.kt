package com.example.kotlinlearnapp.AnecdotesActivityResources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    private val repository = JokeRepository()

    private val _joke = MutableLiveData<JokeModel?>()
    val joke: LiveData<JokeModel?> = _joke
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun getJoke() {
        viewModelScope.launch {
            val result: Result<JokeModel> = repository.getRandomJoke()

            result.fold(
                onSuccess = { jokeModel ->
                    _joke.postValue(jokeModel)
                    _error.postValue(null) // Clear any previous errors
                },
                onFailure = { exception ->
                    _joke.postValue(null)
                    _error.postValue(exception.message ?: "Unknown error occurred")
                }
            )
        }
    }
}