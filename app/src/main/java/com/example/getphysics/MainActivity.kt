package com.example.getphysics


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find CardViews by their IDs
        val formulasCardView: CardView = findViewById(R.id.cardView1)
        val calculatorCardView: CardView = findViewById(R.id.cardView2)

        formulasCardView.setOnClickListener {
            val intent = Intent(this, FormulasActivity::class.java)
            startActivity(intent)
        }

        calculatorCardView.setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java)
            startActivity(intent)

        }
    }
}


