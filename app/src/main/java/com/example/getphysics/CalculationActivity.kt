// CalculationActivity.kt
package com.example.getphysics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CalculationActivity : AppCompatActivity() {

    private lateinit var formulaNameTextView: TextView
    private lateinit var labelInput1: TextView
    private lateinit var labelInput2: TextView
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var resultText: TextView
    private lateinit var calculateButton: Button
    private lateinit var formulasCard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        formulaNameTextView = findViewById(R.id.formula_name)
        labelInput1 = findViewById(R.id.label_input1)
        labelInput2 = findViewById(R.id.label_input2)
        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        resultText = findViewById(R.id.result_text)
        calculateButton = findViewById(R.id.calculate_button)
        formulasCard = findViewById(R.id.formulas_card)

        // pass string of the selected formula for the intent
        // default to force if user goes straight to calculator
        val formula = intent.getStringExtra("formula") ?: "force"
        setupUIForFormula(formula)

        calculateButton.setOnClickListener {
            calculateResult(formula)
        }

        formulasCard.setOnClickListener {
            val intent = Intent(this, FormulasActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupUIForFormula(formula: String?) {
        when (formula) {
            "force" -> {
                formulaNameTextView.text = "Force (F = m * a)"
                labelInput1.text = "Mass (kg)"
                labelInput2.text = "Acceleration (m/s2)"
            }
            "velocity" -> {
                formulaNameTextView.text = "Velocity (v = d / t)"
                labelInput1.text = "Distance (m)"
                labelInput2.text = "Time (s)"
            }
            "linear drag" -> {
                formulaNameTextView.text = "Linear Drag (Fd = -b * v)"
                labelInput1.text = "Drag Coefficient (b)"
                labelInput2.text = "Velocity (v)"
            }
        }
    }

    private fun calculateResult(formula: String?) {
        val input1Value = input1.text.toString().toDoubleOrNull() ?: 0.0
        val input2Value = input2.text.toString().toDoubleOrNull() ?: 0.0

        // physics formulas for calculating the inputs the user enters
        val result = when (formula) {
            "force" -> input1Value * input2Value // F = m * a
            "velocity" -> input1Value / input2Value // v = d / t
            "linear drag" -> input1Value * -1 * input2Value
            else -> 0.0
        }

        resultText.text = "Result: $result"
    }

}
