package com.curso.android.counter

import android.annotation.SuppressLint
import android.os.Bundle

import android.widget.Button
import android.widget.TextView

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var counter = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomeText : TextView = findViewById(R.id.welcome_text)
        val counterText : TextView = findViewById(R.id.counter_text)
        val incrementButton : Button = findViewById(R.id.button)
        val resetButton: Button = findViewById(R.id.btn_reset)

        incrementButton.setOnClickListener(){
            counterText.text= "" + increaseCounter()
        }

        resetButton.setOnClickListener(){
            counter = 0
            counterText.text= "" + counter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun increaseCounter(): Int{
        ++counter
        return counter
    }
}