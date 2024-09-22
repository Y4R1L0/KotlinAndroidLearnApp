package com.example.kotlinlearnapp

import android.content.Intent
import android.os.Bundle
import android.view.View
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
        val NavBtn = findViewById<Button>(R.id.ButtonsActivityB)
        NavBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,ButtonsActivity::class.java)
            startActivity(intent)
        })
        val RNGAct = findViewById<Button>(R.id.RNGTableActivity)
        RNGAct.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,RNGTableActivity::class.java)
            startActivity(intent)
        })
        val TodoAct = findViewById<Button>(R.id.ToDoListActivity)
        TodoAct.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,TodoListActivity::class.java)
            startActivity(intent)
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}