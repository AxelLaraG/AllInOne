package com.example.todojuntofunciona

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layouts_app) // Asegúrate de que está apuntando al layout del menú

        // Botones y listeners
        val constraintButton: Button = findViewById(R.id.btnConstraintLayout)
        val linearButton: Button = findViewById(R.id.btnLinearLayoutH)
        val linearVButton: Button = findViewById(R.id.btnLinearLayoutV)
        val frameButton: Button = findViewById(R.id.btnFrameLayout)
        val tableButton: Button = findViewById(R.id.btnTableLayout)
        val spaceButton: Button = findViewById(R.id.btnSpace)
        val btnReturn = findViewById<Button>(R.id.btnReturnLayout)

        // Navegación a cada layout
        constraintButton.setOnClickListener {
            val intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }

        linearButton.setOnClickListener {
            val intent = Intent(this, LinearLayout::class.java)
            startActivity(intent)
        }

        linearVButton.setOnClickListener {
            val intent = Intent(this, LinearLayoutV::class.java)
            startActivity(intent)
        }

        frameButton.setOnClickListener {
            val intent = Intent(this, FrameLayout::class.java)
            startActivity(intent)
        }

        tableButton.setOnClickListener {
            val intent = Intent(this, TableLayout::class.java)
            startActivity(intent)
        }

        spaceButton.setOnClickListener {
            val intent = Intent(this, SpaceLayout::class.java)
            startActivity(intent)
        }


        btnReturn.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@MainLayout,
                MainMenu::class.java
            )
            startActivity(intent)
            finish() // Cierra esta Activity
        })
    }
}