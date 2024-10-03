package com.example.kotlinlearnapp

import com.example.kotlinlearnapp.AnecdotesActivityResources.JokeViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

class MVVM_API_Anecdotes_Activity : AppCompatActivity() {

    private val jokeViewModel: JokeViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mvvm_api_anecdotes)

        val btnGenJoke: Button = findViewById(R.id.generateJokeBtn)
        val tvJoke: TextView = findViewById(R.id.JokeTextView)

        jokeViewModel.joke.observe(this, Observer { joke ->
            if (joke != null) {
                tvJoke.text = joke.joke
            } else {
                tvJoke.text = "Failed to load joke. Try again."
            }
        })

        // Set the OnClickListener for the button
        btnGenJoke.setOnClickListener {
            jokeViewModel.getJoke()
        }

        // Handling window insets for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
