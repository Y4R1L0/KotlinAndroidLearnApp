package com.example.kotlinlearnapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ButtonsActivity : AppCompatActivity() {
    private var countBtn = 0
    private var ynBtn = false
    private val txtToast = "HI! I'm toast button"
    private val textDuration= Toast.LENGTH_SHORT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buttons)

        val btnCounter: Button = findViewById(R.id.BtnCounter)
        btnCounter.setOnClickListener{
            countBtn++
            btnCounter.text="$countBtn"
        }

        val noYesBtn: Button= findViewById(R.id.YesNoBtn)
        noYesBtn.setOnClickListener{
            ynBtn=!ynBtn
            ynUpdateBtn(noYesBtn)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toastBtn: Button = findViewById(R.id.ToastBtn)
        toastBtn.setOnClickListener{
            val toast = Toast.makeText(this, txtToast, textDuration) // in Activity
            toast.show()
        }
        val timeToastBtn: Button=findViewById(R.id.TimeToastButton)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        timeToastBtn.setOnClickListener{
            val timetoast = Toast.makeText(this,current,textDuration)
            timetoast.show()
        }
    }

    private fun ynUpdateBtn(button: Button){
        if (ynBtn)
            button.text="YES"
        else
            button.text="NO"
    }



}