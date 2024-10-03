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

    fun getJoke() {
        viewModelScope.launch {
            val fetchedJoke = repository.getRandomJoke()
            _joke.postValue(fetchedJoke)
        }
    }
}
