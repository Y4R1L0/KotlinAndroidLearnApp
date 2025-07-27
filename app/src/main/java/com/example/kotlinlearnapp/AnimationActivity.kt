package com.example.kotlinlearnapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animation)
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb)
        val btt1 = AnimationUtils.loadAnimation(this, R.anim.btt1)
        val btt2 = AnimationUtils.loadAnimation(this, R.anim.btt2)
        val btt3 = AnimationUtils.loadAnimation(this, R.anim.btt3)

        val headertitle: TextView = findViewById(R.id.headertitle)
        val subtitle: TextView = findViewById(R.id.subtitle)

        val iccards: ImageView = findViewById(R.id.ImageCards)

        val res1: LinearLayout = findViewById(R.id.res1)
        val res2: LinearLayout = findViewById(R.id.res2)
        val res3: LinearLayout = findViewById(R.id.res3)

        headertitle.startAnimation(ttb)
        subtitle.startAnimation(ttb)

        iccards.startAnimation(stb)
        
        res1.startAnimation(btt1)
        res2.startAnimation(btt2)
        res3.startAnimation(btt3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}