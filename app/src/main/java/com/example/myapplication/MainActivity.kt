package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


class MainActivity : AppCompatActivity() {
    var operation = StringBuilder("")
    var lastNumeric: Boolean = false

    var stateError: Boolean = false

    var lastDot: Boolean = false
    var value1: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener {
            appendvalue("0")

        }

        btn_1.setOnClickListener {
            appendvalue("1")
        }

        btn_2.setOnClickListener {

            appendvalue("2")


        }
        btn_3.setOnClickListener {
            appendvalue("3")
        }

        btn_4.setOnClickListener {
            appendvalue("4")
        }

        btn_5.setOnClickListener {
            appendvalue("5")
        }

        btn_6.setOnClickListener {
            appendvalue("6")
        }

        btn_7.setOnClickListener {
            appendvalue("7")
        }

        btn_8.setOnClickListener {
            appendvalue("8")
        }

        btn_9.setOnClickListener {
            appendvalue("9")

        }

        /*Operators*/

        btn_add.setOnClickListener {

            val value = tv_display.text.toString()
            val lastChar = value.get(value.length - 1)
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                var newvalue = value.substring(0, value.length - 1)
                tv_display.text = newvalue + "+"
            } else tv_display.text = value + "+"
        }

        btn_sub.setOnClickListener {
            val value = tv_display.text.toString()
            val lastChar = value.get(value.length - 1)
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                var newvalue = value.substring(0, value.length - 1)
                tv_display.text = newvalue + "-"
            } else tv_display.text = value + "-"
        }
        btn_mul.setOnClickListener {

            val value = tv_display.text.toString()
            val lastchar = value.get(value.length - 1)
            if (lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/') {
                var newvalue = value.substring(0, value.length - 1)
                tv_display.text = newvalue + "*"

            } else tv_display.text = value + "*"
        }

        btn_div.setOnClickListener {
            val value = tv_display.text.toString()
            val lastChar = value.get(value.length - 1)
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                var newvalue = value.substring(0, value.length - 1)
                tv_display.text = newvalue + "/"
            } else tv_display.text = value + "/"
        }

        btn_dot.setOnClickListener {
            dot()
        }


        btn_equal.setOnClickListener {
            /*  val split = tv_display.text.toString()
           var operator1 = "/ "
            var operator2 = "*"
            var operator3 = "-"
            var operator = "+"
          for (value.split) {
              ("".toRegex())*/
            equation()
        }



        btn_clear.setOnClickListener {
            clearvalue("", clear = true)
            tv_display.text = "0"

        }
        btn_delete.setOnClickListener {
            tv_display.text = "0"
        }

        btn_delete.setOnClickListener {
            val sb = StringBuffer(tv_display.text.toString())
            if (sb.length <= 1)
                tv_display.text = "0"
            else {
                sb.deleteCharAt(sb.length - 1)
                tv_display.text = sb.toString()
            }
        }

    }
    /*private fun getFormateddecimal(double: Double){
        var NumberFormat = tv_display.text
        var format =NumberFormat ("#,###,###.00")

        *//*NumberFormat format1 = new DecimalFormat("#,###,###");*//*
    }*/

    private fun dot() {
        val action = tv_display.text.toString()
        var hasDot = false
        for (i in action.length - 1 downTo 0) {
            if (action[i] == '.') hasDot = true
            if (action[i] == '+' || action[i] == '-' || action[i] == '*' || action[i] == '/') break
        }
        if (!hasDot) tv_display.text = action +
                if (action[action.length - 1] == '+' || action[action.length - 1] == '-' || action[action.length - 1] == '*' || action[action.length - 1] == '/')
                    "0."
                else "."
    }

    /* var formatter = DecimalFormat("#,##0.0")*/

    fun Double.toPrice(): String = DecimalFormat("#,###,###.##", DecimalFormatSymbols().apply {
        groupingSeparator = ' '
    }).format(this)

    private fun equation() {
        val equation = tv_display.text.toString()
        /* var formatter = DecimalFormat("0,000,000.00")*/
        if (equation.contains("/")) {
            var divArray = equation.split("/").toMutableList()
            var firstOperant = ""
            var secondOperant = ""
            for (i in divArray[0].length - 1 downTo 0) {
                if (!"+*-/".contains(divArray[0].get(i).toString())) {
                    firstOperant = divArray[0].get(i) + firstOperant

                } else {
                    break
                }
                /* println("firstOperant $firstOperant")*/
            }

            for (i in 0..divArray[1].length - 1) {
                if (!"+*-/".contains(divArray[1].get(i).toString())) {
                    secondOperant = secondOperant + divArray[1].get(i)

                } else {
                    break
                }
            }/*val number2digits:Double = Math.round(number3digits * 100.0) / 100.0*/

            val calculatedValue = (firstOperant.toDouble() / secondOperant.toDouble()).toPrice()
            divArray[0] = divArray[0].substring(0, divArray[0].length - firstOperant.length)
            divArray[1] = divArray[1].substring(secondOperant.length, divArray[1].length)

            var finalEquation = ""

            for (i in 0..divArray.size - 1) {
                if (i == 0) {
                    finalEquation = finalEquation + divArray[i] + calculatedValue
                } else {
                    finalEquation = finalEquation + (if (i > 1) "/" else "") + divArray[i]
                }
            }

            tv_display.text = (finalEquation)
            equation()
        } else if (equation.contains("*")) {
            var divArray = equation.split("*").toMutableList()
            var firstOperant = ""
            var secondOperant = ""
            for (i in divArray[0].length - 1 downTo 0) {
                if (!"+*-/".contains(divArray[0].get(i).toString())) {
                    firstOperant = divArray[0].get(i) + firstOperant

                } else {
                    break
                }

            }
            /*var formatter = DecimalFormat("#,###,##0.00")*/
            for (i in 0..divArray[1].length - 1) {
                if (!"+*-/".contains(divArray[1].get(i).toString())) {
                    secondOperant = secondOperant + divArray[1].get(i)

                } else {
                    break
                }
            }
            val calculatedValue =
                (firstOperant.toDouble() * secondOperant.toDouble()).toPrice()

            divArray[0] = divArray[0].substring(0, divArray[0].length - firstOperant.length)
            divArray[1] = divArray[1].substring(secondOperant.length, divArray[1].length)

            var finalEquation = ""
            for (i in 0..divArray.size - 1) {
                if (i == 0) {
                    finalEquation = finalEquation + divArray[i] + calculatedValue
                } else {
                    finalEquation = finalEquation + (if (i > 1) "*" else "") + divArray[i]
                }
            }
            tv_display.text = (finalEquation)/*.toDouble()).toPrice()*/
            equation()
        } else if (equation.contains("+")) {
            var divArray = equation.split("+").toMutableList()
            var firstOperant = ""
            var secondOperant = ""
            for (i in divArray[0].length - 1 downTo 0) {
                if (!"+*-/".contains(divArray[0].get(i).toString())) {
                    firstOperant = divArray[0].get(i) + firstOperant

                } else {
                    break
                }
            }
            /*var formatter = DecimalFormat("0,000,000.00")*/
            for (i in 0..divArray[1].length - 1) {
                if (!"+*-/".contains(divArray[1].get(i).toString())) {
                    secondOperant = secondOperant + divArray[1].get(i)

                } else {
                    break
                }

            }
            val calculatedValue =
                (firstOperant.toDouble() + secondOperant.toDouble()).toPrice()
            divArray[0] = divArray[0].substring(0, divArray[0].length - firstOperant.length)
            divArray[1] = divArray[1].substring(secondOperant.length, divArray[1].length)

            var finalEquation = ""
            for (i in 0..divArray.size - 1) {
                if (i == 0) {
                    finalEquation = finalEquation + divArray[i] + calculatedValue
                } else {
                    finalEquation = finalEquation + (if (i > 1) "+" else "") + divArray[i]
                }
            }
            tv_display.text = (finalEquation)/*.toDouble()).toPrice()*/
            equation()
        } else if (equation.contains("-")) {
            var isNegative = false
            var divArray = equation.split("-").toMutableList()
            for (i in 0..divArray.size - 1) {
                if (i < divArray.size) {
                    if (divArray[i].isEmpty()) {
                        isNegative = true
                    }
                }
            }
            if (divArray[0].isNotEmpty()) {
                var firstOperant = ""
                var secondOperant = ""
                for (i in divArray[0].length - 1 downTo 0) {
                    if (!"+*-/".contains(divArray[0].get(i).toString())) {
                        firstOperant = divArray[0].get(i) + firstOperant
                    } else {
                        break
                    }
                }
                for (i in 0..divArray[1].length - 1) {
                    if (!"+*-/".contains(divArray[1].get(i).toString())) {
                        secondOperant = secondOperant + divArray[1].get(i)
                    } else {
                        break
                    }
                }

                var calculatedValue =
                    (firstOperant.toDouble() - (secondOperant.toDouble())).toPrice()

                divArray[0] = divArray[0].substring(0, divArray[0].length - firstOperant.length)
                divArray[1] = divArray[1].substring(secondOperant.length, divArray[1].length)
                var finalEquation = ""
                for (i in 0..divArray.size - 1) {
                    /* if ((divArray[-firstOperant - secondOperant)*/
                    if (i == 0) {
                        finalEquation =
                            finalEquation + divArray[i] + calculatedValue
                    } else {
                        finalEquation = finalEquation + (if (i > 1) "-" else "") + divArray[i]
                    }
                }
                tv_display.text = (finalEquation)
                if (finalEquation.length > 2)
                    equation()
            } else {
                divArray.removeAt(0)
                var firstOperant = ""
                var secondOperant = ""
                for (i in divArray[0].length downTo 0) {
                    if (!"+*-/".contains(divArray[0].get(i).toString()) || divArray[0].get(i)
                            .toString()
                            .isNotEmpty()
                    ) {
                        firstOperant = divArray[0].get(i) + firstOperant
                    } else {
                        break
                    }
                }
                for (i in 0..divArray[1].length - 1) {
                    if (!"+*-/".contains(divArray[1].get(i).toString())) {
                        secondOperant = secondOperant + divArray[1].get(i)
                    } else {
                        break
                    }
                }

                var calculatedValue =
                    (firstOperant.toDouble() + (secondOperant.toDouble())).toPrice()

                divArray[0] = divArray[0].substring(0, divArray[0].length - firstOperant.length)
                divArray[1] = divArray[1].substring(secondOperant.length, divArray[1].length)
                var finalEquation = ""
                for (i in 0..divArray.size - 1) {
                    /* if ((divArray[-firstOperant - secondOperant)*/
                    if (i == 0) {
                        finalEquation =
                            finalEquation + divArray[i] + ("-" + calculatedValue)
                    } else {
                        finalEquation = finalEquation + (if (i > 1) "-" else "") + divArray[i]
                    }
                }
                tv_display.text = (finalEquation)
                equation()
            }
        }
    }


    /* fun Double.toPrice(): String =   DecimalFormat("#,###,###.##", DecimalFormatSymbols().apply {
         groupingSeparator = ' '
     }).format(this)*//*

    *//* fun getFromattedNumber(number: Double) {
         val format: NumberFormat = DecimalFormat("#,###,###.00")
         val num: Double = format.format(number).replace(",", "").toDouble()

         // Format for integer decimal numbers
         val formatInt: NumberFormat = DecimalFormat("#,###,###")
         if (num as Double == num){
             return formatInt.format(number)
         } else {
             return format.format(number)
         }
     }*//*

    *//* if (equals(operand &&operator).toString)*//*


    *//*tv_display.text = final.toString()*//*


    *//* val pattern = Regex("^a")*//*
    *//* *//**//*  private fun appendscreen(digit: String) {

       operation .append(digit)

        tv_display.text = operation.toString()

    }
*//**//*

}*/
    private fun appendvalue(string: String) {
        val displayvalue = tv_display.text.toString()
        val currentvalue =
            if (displayvalue == "0")
                string
            else displayvalue + string

        tv_display.text = currentvalue

    }

    private fun append(string: String) {

        var displayvalue = tv_display.text.toString()
        var currentvalue = displayvalue + string

        if (currentvalue == "0") {
            currentvalue = string

        }
        tv_display.text = currentvalue
    }

    private fun clearvalue(string: String, clear: Boolean) {

        if (clear) {
            tv_display.text = ""
            appendvalue(string)
            tv_display.text = ""
        } else {
            appendvalue(toString())
            appendvalue(string)
            tv_display.text = ""
        }
    }
}


