package com.cs407.lab2calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        val numberInput1 = findViewById<EditText>(R.id.numberInput1)
        val numberInput2 = findViewById<EditText>(R.id.numberInput2)

        addButton.setOnClickListener {
            val number1 = numberInput1.text.toString().toDouble()
            val number2 = numberInput2.text.toString().toDouble()
            val result = number1 + number2
            displayResult(result)
        }

        subtractButton.setOnClickListener {
            val number1 = numberInput1.text.toString().toDouble()
            val number2 = numberInput2.text.toString().toDouble()
            val result = number1 - number2
            displayResult(result)
        }

        multiplyButton.setOnClickListener {
            val number1 = numberInput1.text.toString().toDouble()
            val number2 = numberInput2.text.toString().toDouble()
            val result = number1 * number2
            displayResult(result)
        }

        divideButton.setOnClickListener {
            val number1 = numberInput1.text.toString().toDouble()
            val number2 = numberInput2.text.toString().toDouble()

            if (number2 == 0.0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = number1 / number2
            displayResult(result)
        }
    }

    private fun displayResult(result: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("CALCULATION_RESULT", result)
        startActivity(intent)
    }
}