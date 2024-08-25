package com.example.getphysics

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FormulasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulas)

        // force card
        val forceCard = findViewById<CardView>(R.id.force_card)
        forceCard.setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java)
            intent.putExtra("formula", "force")
            startActivity(intent)
        }

        // velocity card
        val velocityCard = findViewById<CardView>(R.id.velocity_card)
        velocityCard.setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java)
            intent.putExtra("formula", "velocity")
            startActivity(intent)
        }


        // linear drag card
        val linearDragCard = findViewById<CardView>(R.id.linear_drag_card)
        linearDragCard.setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java)
            intent.putExtra("formula", "linear drag")
            startActivity(intent)
        }
    }
}

