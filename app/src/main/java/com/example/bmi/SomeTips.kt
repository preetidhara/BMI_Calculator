package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_some_tips.*

class SomeTips : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some_tips)

        val Bmi_value = intent.getFloatExtra("get_bmi", 0.0F)
        //var Bmi=Math.round((intent.getFloatExtra("BMI", 0)

        //val age=intent.getStringExtra("age")
        bmiValueTV.text = "%.1f".format(Bmi_value)

        when (Bmi_value) {
            in 0.0..18.5 -> {
                containerL.setBackgroundResource(R.color.yellow)
                bmiFlagImgView.setImageResource(R.drawable.ic_mark)
                bmiLabelTV.text="You have an UnderWeight!"
                commentTV.text="Here are some advices To help you increase your weight"
                advice1IMG.setImageResource(R.drawable.nowater)
                advice1TV.text="Don't drink water before meals"
                advice2IMG.setImageResource(R.drawable.bigmeal)
                advice2TV.text="Use bigger plates"
                advice3IMG.setImageResource(R.drawable.sleep)
                advice3TV.text="Get quality sleep"

            }
            in 18.5..25.5->{
                containerL.setBackgroundResource(R.color.green)
                bmiFlagImgView.setImageResource(R.drawable.correct)
                bmiLabelTV.text="You have an normal weight!"
                commentTV.text="Here are some advices To help you keep your healhty weight"
                advice1IMG.setImageResource(R.drawable.active)
                advice1TV.text="Choose the right foods and Cook by yourself"
                advice2IMG.setImageResource(R.drawable.salad)
                advice2TV.text="Use bigger plates"
                advice3IMG.setImageResource(R.drawable.sleep)
                advice3TV.text="Get quality sleep"


            }
            in 25.5..30.5->{
                containerL.setBackgroundResource(R.color.red)
                bmiFlagImgView.setImageResource(R.drawable.warning)
                bmiLabelTV.text="You have an OverWeight!"
                commentTV.text="Here are some advices To help you decrease your weight"
                advice1IMG.setImageResource(R.drawable.water)
                advice1TV.text="Drink water a half hour before meals"
                advice2IMG.setImageResource(R.drawable.twoeggs)
                advice2TV.text="Eeat only two meals per day and make sure that they contains a high protein"
                advice3IMG.setImageResource(R.drawable.nosugar)
                advice3TV.text="Drink coffee or tea and Avoid sugary food"

            }
            in 30.5..Float.MAX_VALUE.toDouble() ->{
                containerL.setBackgroundResource(R.color.red)
                bmiFlagImgView.setImageResource(R.drawable.warning)
                bmiLabelTV.text="You have an OverWeight!"
                commentTV.text="Here are some advices To help you decrease your weight"
                advice1IMG.setImageResource(R.drawable.water)
                advice1TV.text="Drink water a half hour before meals"
                advice2IMG.setImageResource(R.drawable.twoeggs)
                advice2TV.text="Eeat only two meals per day and make sure that they contains a high protein"
                advice3IMG.setImageResource(R.drawable.nosugar)
                advice3TV.text="Drink coffee or tea and Avoid sugary food"



            }


        }


    }
}