package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //var Bmi= Math.round((intent.getDoubleExtra("bmi", 0.0) * 100) / 100)
        val Bmi = intent.getFloatExtra("bmi", 0.0F)
        //var Bmi=Math.round((intent.getFloatExtra("BMI", 0)

        val age=intent.getStringExtra("age")
        your_bmi.text = "%.1f".format(Bmi)
        your_age.text=age.toString()


        //var Bmi_value=range.text.toString().toFloat()
        //if (Bmi_value>18.5){
        //  condition.setText("Moderate Thinness")
        //condition.setTextColor(R.color.green)
        //}
        when (Bmi) {
            in 0.0..18.5 -> {
                condition?.setTextColor(getColor(R.color.red))
                condition.setText("Underweight")
            }
            in 18.5..25.5->{
                condition?.setTextColor(getColor(R.color.green))
                condition.setText("Normal")
            }
            in 25.5..30.5->{
                condition?.setTextColor(getColor(R.color.yellow))
                condition.setText("OverWeight")
            }
            in 30.5..Float.MAX_VALUE.toDouble() ->{
                condition?.setTextColor(getColor(R.color.orange))
                condition.setText("Obese")


            }


        }
        recalculate.setOnClickListener(){
            val intent=Intent(this,SelectDetails::class.java)
            startActivity(intent)

        }
        extra_btn.setOnClickListener(){
            var get_bmi=your_bmi.text.toString().toFloat()
            val intent=Intent(this,SomeTips::class.java)
            intent.putExtra("get_bmi",get_bmi)
            startActivity(intent)
        }

    }
}