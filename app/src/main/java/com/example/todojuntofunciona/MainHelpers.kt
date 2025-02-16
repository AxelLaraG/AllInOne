package com.example.todojuntofunciona
import com.google.android.gms.ads.AdRequest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.Group

class MainHelpers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_helpers)

        val textGroup = findViewById<Group>(R.id.textGroup)
        val btnShow = findViewById<Button>(R.id.showButton)
        val btnHide = findViewById<Button>(R.id.hideButton)
        val layer = findViewById<Layer>(R.id.buttonLayer)
        val btnReturn = findViewById<Button>(R.id.btnReturnHelpers)
        btnShow.setOnClickListener {
            textGroup.visibility = View.VISIBLE
        }

        btnHide.setOnClickListener {
            textGroup.visibility = View.GONE
        }

        btnShow.setOnLongClickListener {
            layer.rotation = 45f
            layer.scaleX = 1.2f
            layer.scaleY = 1.2f
            true
        }

        btnReturn.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@MainHelpers,
                MainMenu::class.java
            )
            startActivity(intent)
            finish() // Cierra esta Activity
        })    }
}