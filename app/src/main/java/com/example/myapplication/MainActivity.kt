package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
    var value1: Double =0.0
    var value2: Double =0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener {
            tv_display.text = if (tv_display.text.toString().isEmpty()||tv_display.text.toString()== "0")btn_0.text.toString()else tv_display.text.toString()+btn_0.text.toString()

        }

        btn_1.setOnClickListener {
        }

        btn_2.setOnClickListener {
        }
        btn_3.setOnClickListener {
        }

        btn_4.setOnClickListener {
        }

        btn_5.setOnClickListener {
        }

        btn_6.setOnClickListener {
        }

        btn_7.setOnClickListener {
        }

        btn_8.setOnClickListener {
        }

        btn_9.setOnClickListener {
        }

        /*Operators*/

        btn_add.setOnClickListener {
        }

        btn_sub.setOnClickListener {
        }

        btn_mul.setOnClickListener {
        }

        btn_div.setOnClickListener {
        }

        btn_dot.setOnClickListener {
        }

        btn_clear.setOnClickListener {
            tv_display.text = ""

        }

        btn_equal.setOnClickListener {

        }


    }

}



