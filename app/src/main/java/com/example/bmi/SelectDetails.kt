package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_select_details.*

class SelectDetails : AppCompatActivity() {

    lateinit var ViewModel:SelectViewModel

    var malecheck: Boolean = true
    var check1: Boolean = true
    var feamlecheck: Boolean = true
    var check2: Boolean = true

    var count_wt:Int=50
    var count_age:Int=18

    var height : Float = 0.0F
    var BMI : Float= 0.0F




    lateinit var slider:SeekBar

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_details)



        ViewModel = ViewModelProviders.of(this).get(SelectViewModel::class.java)


        slider = findViewById(R.id.Seekbar) as SeekBar

        cardView_male.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //Your code here
                if (check1) {

                    if (malecheck) {

                        male_text.setTextColor(Color.parseColor("#FFFFFF"));
                        //male.setImageResource(R.drawable.male_white);
                        male_text.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.male_white,
                            0,
                            0
                        );
                        malecheck = false;
                        check2 = false;

                    } else {

                        male_text.setTextColor(Color.parseColor("#8D8E99"));
                        //male.setImageResource(R.drawable.male);
                        male_text.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.male, 0, 0);
                        malecheck = true;
                        check2 = true;
                    }
                }

            }
        })

        cardView_female.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //Your code here
                if (check2) {
                    if (feamlecheck) {
                        female_text.setTextColor(Color.parseColor("#FFFFFF"));
                        female_text.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female_white,
                            0,
                            0
                        );
                        feamlecheck = false;
                        check1 = false;
                    } else {

                        female_text.setTextColor(Color.parseColor("#8D8E99"));
                        female_text.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            R.drawable.female,
                            0,
                            0
                        );
                        feamlecheck = true;
                        check1 = true;
                    }
                }

            }
        })


        weight_plus.setOnClickListener() {
            count_wt++
            weight_text.setText(count_wt.toString())
        }

        weight_minus.setOnClickListener {
            count_wt--
            weight_text.setText(count_wt.toString())

        }



        slider.max = 200

      checkHeight()

        age_plus.setOnClickListener {
            count_age++
            age_text.setText(count_age.toString())
        }
        age_minus.setOnClickListener {
            count_age--
            age_text.setText(count_age.toString())
        }

        // WEight
        // ViewModel.Weight_edt.observe(this,{
        //New_weight->weight_text.text=New_weight.toString()
        //})




        ///Age

      //  ViewModel.age_edt.observe(this, {
        //    age->
          //  age_text.text = age.toString()
       // })




        calculate.setOnClickListener() {
            CalculateBMI()
        }



    }

    private fun checkHeight() {
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //TODO("Not yet implemented")
                height_txt.text = progress.toString()
                height = ((progress / 100).toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
                height_txt.text = seekBar?.progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
                height_txt.text = seekBar?.progress.toString()
            }

            //get_height=height_txt.text
        })
    }





    private fun CalculateBMI() {
        var Final_WT=weight_text.text.toString().toFloat()
        var Final_HT=height_txt.text.toString().toFloat()
        var Final_age=age_text.text.toString()
        //BMI= ((final_wt/(height*height)))
        //BMI=((weight_text.text.toString().toFloat()/height_txt.text.toString().toFloat()*height_txt.text.toString().toFloat()))
        BMI=((Final_WT/(Final_HT*Final_HT))*10000)
        //var age=ViewModel.age_edt.toString()
        val intent=Intent(this,Result::class.java)
        intent.putExtra("bmi",BMI)
        intent.putExtra("age",Final_age)
        startActivity(intent)



    }


}