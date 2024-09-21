package com.example.kotlinlearnapp

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class RNGTableActivity : AppCompatActivity() {

    private lateinit var gridRes: GridLayout
    private lateinit var genetareButton: Button
    private val gridSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rngtable)

        gridRes = findViewById(R.id.gridRes)
        genetareButton = findViewById(R.id.generateButton)

        initializeGrid()

        genetareButton.setOnClickListener {
            generateRandomNumbers()
        }
    }

    // Function to initialize the grid with empty TextViews
    private fun initializeGrid() {
        for (i in 0 until  gridSize * gridSize) {
            val textView = TextView(this)
            textView.text = "0"
            textView.textSize = 18f
            textView.setPadding(8, 8, 8, 8)
            textView.gravity = android.view.Gravity.CENTER
            gridRes.addView(textView)
        }
    }

    // Function to generate random numbers and update the grid
    private fun generateRandomNumbers() {
        for (i in 0 until gridRes.childCount) {
            val textView = gridRes.getChildAt(i) as TextView
            val randomNum = Random.nextInt(100) // Generate random number between 0 and 99
            textView.text = randomNum.toString()
        }
    }
}