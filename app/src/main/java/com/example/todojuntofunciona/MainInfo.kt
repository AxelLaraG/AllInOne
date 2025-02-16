package com.example.todojuntofunciona

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_info) // Asegúrate que este nombre coincida con tu archivo layout

        val exit = findViewById<Button>(R.id.btnReturnInfo)

        exit.setOnClickListener {
            val intent =Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}