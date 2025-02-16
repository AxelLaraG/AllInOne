package com.example.todojuntofunciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_buttons);

        FloatingActionButton fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainButtons.this, "No tienes ningún mensaje", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab_btn_2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainButtons.this, "Elaborado por Sandra y Melanie", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSig = findViewById(R.id.btnSig);
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainButtons.this, Screen3Buttons.class);
                startActivity(intent);
            }
        });

        Button btnReturn = findViewById(R.id.returnMainButtons);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainButtons.this, MainMenu.class);
                startActivity(intent);
                finish(); // Cierra esta Activity
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainButtons), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
