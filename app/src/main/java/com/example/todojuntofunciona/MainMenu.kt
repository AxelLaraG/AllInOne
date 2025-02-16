package com.example.todojuntofunciona

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu) // Asegúrate que este nombre coincida con tu archivo layout

        val buttons = findViewById<Button>(R.id.btnButtons)
        val commons = findViewById<Button>(R.id.btnCommons)
        val layouts = findViewById<Button>(R.id.btnLayouts)
        val helpers = findViewById<Button>(R.id.btnHelpers)
        val google = findViewById<Button>(R.id.btnGoogle)
        val containers = findViewById<Button>(R.id.btnContainers)
        val texts = findViewById<Button>(R.id.btnTexts)
        val widgets = findViewById<Button>(R.id.btnWidgets)
        val info = findViewById<Button>(R.id.btnInfo)
        val exit = findViewById<Button>(R.id.btnLogin)

        buttons.setOnClickListener {
            val intent = Intent (this, MainButtons::class.java)
            startActivity(intent)
        }

        commons.setOnClickListener {
            val intent =Intent(this, MainCommons::class.java)
            startActivity(intent)
        }

        layouts.setOnClickListener {
            val intent =Intent(this, MainLayout::class.java)
            startActivity(intent)
        }

        helpers.setOnClickListener {
            val intent =Intent(this, MainHelpers::class.java)
            startActivity(intent)
        }

        google.setOnClickListener {
            val intent =Intent(this, MainGoogle::class.java)
            startActivity(intent)
        }

        containers.setOnClickListener {
            val intent =Intent(this, MainContainers::class.java)
            startActivity(intent)
        }

        texts.setOnClickListener {
            val intent =Intent(this, MainText::class.java)
            startActivity(intent)
        }

        widgets.setOnClickListener {
            val intent =Intent(this, MainWidgets::class.java)
            startActivity(intent)
        }

        info.setOnClickListener {
            val intent = Intent(this, MainInfo::class.java)
            startActivity(intent)
        }

        exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}