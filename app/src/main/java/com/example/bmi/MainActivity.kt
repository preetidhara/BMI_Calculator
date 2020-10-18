package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.NumberPicker
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    lateinit var handler:Handler

    private lateinit var  countDownTimer:CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()

        handler= Handler()

        handler.postDelayed({

            // Delay and Start Activity
            val intent = Intent(this,SelectDetails::class.java)
            startActivity(intent)
            finish()
        } , 3000) // here we're delaying to startActivity after 3seconds





    }
}
