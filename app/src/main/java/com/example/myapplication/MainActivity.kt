package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var btn1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*NumberFunction Buttons*/

/*        btn_1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }*/

        btn1=findViewById(R.id.btn_1)
        btn1?.setOnClickListener{
            Toast.makeText(this@MainActivity,
                "test", Toast.LENGTH_SHORT).show()
        }

    }

}