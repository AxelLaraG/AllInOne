package com.example.todojuntofunciona

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MenuLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layouts_app)

        val btnConstraintLayout = findViewById<Button>(R.id.btnConstraintLayout)
        val btnLinearLayoutH = findViewById<Button>(R.id.btnLinearLayoutH)
        val btnLinearLayoutV = findViewById<Button>(R.id.btnLinearLayoutV)
        val btnFrameLayout = findViewById<Button>(R.id.btnFrameLayout)
        val btnTableLayout = findViewById<Button>(R.id.btnTableLayout)
        val btnSpace = findViewById<Button>(R.id.btnSpace)

        btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }

        btnLinearLayoutH.setOnClickListener {
            val intent = Intent(this, LinearLayout::class.java)
            startActivity(intent)
        }

        btnLinearLayoutV.setOnClickListener {
            val intent = Intent(this, LinearLayoutV::class.java)
            startActivity(intent)
        }

        btnFrameLayout.setOnClickListener {
            val intent = Intent(this, FrameLayout::class.java)
            startActivity(intent)
        }

        btnTableLayout.setOnClickListener {
            val intent = Intent(this, TableLayout::class.java)
            startActivity(intent)
        }

        btnSpace.setOnClickListener {
            val intent = Intent(this, SpaceLayout::class.java)
            startActivity(intent)
        }
    }
}
