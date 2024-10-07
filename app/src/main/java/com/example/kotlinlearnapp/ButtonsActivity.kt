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
    private var YNBtn = false
    private val TxtToast = "HI! I'm toast button"
    private val textDuration= Toast.LENGTH_SHORT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buttons)

        val BtnCounter: Button = findViewById(R.id.BtnCounter)
        BtnCounter.setOnClickListener{
            countBtn++
            BtnCounter.text="$countBtn"
        }

        val NoYesBtn: Button= findViewById(R.id.YesNoBtn)
        NoYesBtn.setOnClickListener{
            YNBtn=!YNBtn
            YNUpdateBtn(NoYesBtn)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val TBtn: Button = findViewById(R.id.ToastBtn)
        TBtn.setOnClickListener{
            val toast = Toast.makeText(this, TxtToast, textDuration) // in Activity
            toast.show()
        }
        val TimeToastBtn: Button=findViewById(R.id.TimeToastButton)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        TimeToastBtn.setOnClickListener{
            val timetoast = Toast.makeText(this,current,textDuration)
            timetoast.show()
        }
    }

    private fun YNUpdateBtn(button: Button){
        if (YNBtn)
            button.text="YES"
        else
            button.text="NO"
    }



}