package com.example.myapplication

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var value1: Double = 0.0
    var value2: Double = 0.0
    var digit_on_screen = StringBuilder("0")
    var symbol: String = ""
    var value3: Double = 0.0
    var value4: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener {
            if (tv_display.text.toString()
                    .isEmpty() || tv_display.text.toString() == "0"
            ) digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        btn_1.setOnClickListener {
            if (tv_display.text.toString()
                    .isEmpty() || tv_display.text.toString() == "0"
            ) digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        btn_2.setOnClickListener {
            if (tv_display.text.toString()
                    .isEmpty() || tv_display.text.toString() == "0"
            ) digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }
        btn_3.setOnClickListener {
            if (tv_display.text.toString()
                    .isEmpty() || tv_display.text.toString() == "0"
            ) digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()

        }

        btn_4.setOnClickListener {
            if (tv_display.text.toString()
                    .isEmpty() || tv_display.text.toString() == "0"
            )
                digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()

        }

        btn_5.setOnClickListener {
            if (tv_display.text.toString().isEmpty() || tv_display.text.toString() == "0"
            )
                digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        btn_6.setOnClickListener {
            if (tv_display.text.toString().isEmpty() || tv_display.text.toString() == "0"
            )
                digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        btn_7.setOnClickListener {
            if (tv_display.text.toString().isEmpty() || tv_display.text.toString() == "0"
            )
                digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        btn_8.setOnClickListener {
            if (tv_display.text.toString().isEmpty() || tv_display.text.toString() == "0"
            )
                digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        btn_9.setOnClickListener {
            if (tv_display.text.toString().isEmpty() || tv_display.text.toString() == "0"
            )
                digit_on_screen.clear()
            digit_on_screen.append((it as TextView).text.toString())
            tv_display.text = digit_on_screen.toString()
        }

        /*Operators*/

        btn_add.setOnClickListener {

            if (symbol.isEmpty()) {
                value1 = digit_on_screen.toString().toDouble()
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "+"

            } else {
                value2 = digit_on_screen.toString().toDouble()
                value1 = value2 + value1
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "+"

            }
        }
        btn_sub.setOnClickListener {
            if (symbol.isEmpty()) {
                value1 = digit_on_screen.toString().toDouble()
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "-"
            } else {
                value2 = digit_on_screen.toString().toDouble()
                value1 = value1 - value2
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "-"
            }
        }





        btn_mul.setOnClickListener {
            if (symbol.isEmpty()) {
                value1 = digit_on_screen.toString().toDouble()
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "*"
            } else {
                value2 = digit_on_screen.toString().toDouble()
                value1 = value2 * value1
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "*"
            }


        }

        btn_div.setOnClickListener {
            if (symbol.isEmpty()) {
                value1 = digit_on_screen.toString().toDouble()
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "/"
            } else {
                value2 = digit_on_screen.toString().toDouble()
                value1 = value1 / value2
                digit_on_screen.clear()
                digit_on_screen.append("0")
                tv_display.text = digit_on_screen.toString()
                symbol = "/"
            }
        }

        btn_dot.setOnClickListener {
            if (!digit_on_screen.contains(".")) appendToDigitOnScreen(".")
        }

        btn_clear.setOnClickListener {

            digit_on_screen.clear()
            tv_display.text = "0"

        }

        btn_equal.setOnClickListener {
            value2 = digit_on_screen.toString().toDouble()

            if (symbol == "+")
                value1 = value2 + value1




            if (symbol == "-")
                value1 = value1 - value2


            if (symbol == "*")
                value1 = value2 * value1


            if (symbol == "/")
                value1 = value1 / value2


            digit_on_screen.clear()
            digit_on_screen.append("$value1")
            tv_display.text = digit_on_screen.toString()
            value2 = 0.0
            symbol = ""
        }

        btn_delete.setOnClickListener {
            clearDigit()
        }

    }


    private fun appendToDigitOnScreen(digit: String) {

        digit_on_screen.append(digit)

        tv_display.text = digit_on_screen.toString()

    }


    private fun clearDigit() {

        val length = digit_on_screen.length
        if (length == 1) {
            digit_on_screen.deleteCharAt(0)
            digit_on_screen.append("0")
        } else {
            digit_on_screen.deleteCharAt(length - 1)
        }

        tv_display.text = digit_on_screen.toString()

    }


}
