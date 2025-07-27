package com.example.kotlinlearnapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val navBtn = findViewById<Button>(R.id.ButtonsActivityB)
        navBtn.setOnClickListener {
            val intent = Intent(this,ButtonsActivity::class.java)
            startActivity(intent)
        }
        val rngAct = findViewById<Button>(R.id.RNGTableActivity)
        rngAct.setOnClickListener {
            val intent = Intent(this,RNGTableActivity::class.java)
            startActivity(intent)
        }
        val todoAct = findViewById<Button>(R.id.ToDoListActivity)
        todoAct.setOnClickListener {
            val intent = Intent(this,TodoListActivity::class.java)
            startActivity(intent)
        }
        val jokeAct = findViewById<Button>(R.id.MVVMJokeBtn)
        jokeAct.setOnClickListener {
            val intent = Intent(this,APIAnecdotesActivityMVVM::class.java)
            startActivity(intent)
        }
        val animAct = findViewById<Button>(R.id.AnimationActivityBTN)
        animAct.setOnClickListener {
            val intent = Intent(this, AnimationActivity::class.java )
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}