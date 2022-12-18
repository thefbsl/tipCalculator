package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(){
            calculate()
        }
    }

    private fun calculate(){
        val stringCost = et_cost.text.toString()
        val cost = stringCost.toDouble()

        val tipPercent = when(rg_options.checkedRadioButtonId){
            R.id.rb_20 -> 0.2
            R.id.rb_18 -> 0.18
            else -> 0.15
        }

        var tip = tipPercent * cost
        if (sw_round.isChecked){
            tip = kotlin.math.ceil(tip)
        }

        tv_result.text = tip.toString()
    }
}

