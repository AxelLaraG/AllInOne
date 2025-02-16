package com.example.todojuntofunciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThanksButtons extends AppCompatActivity {
    private boolean isFabOpen = false;
    private FloatingActionButton fabMain, fabBtn1, fabBtn2;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_buttons);

        fabMain = findViewById(R.id.fab_main);
        fabBtn1 = findViewById(R.id.fab_btn);
        fabBtn2 = findViewById(R.id.fab_btn_2);
        btnInicio = findViewById(R.id.btnInicio);

        // Botón flotante principal: Abre/cierra menú
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFabOpen) {
                    fabBtn1.setVisibility(View.GONE);
                    fabBtn2.setVisibility(View.GONE);
                    isFabOpen = false;
                } else {
                    fabBtn1.setVisibility(View.VISIBLE);
                    fabBtn2.setVisibility(View.VISIBLE);
                    isFabOpen = true;
                }
            }
        });

// Establecemos los listeners para los botones flotantes secundarios (fabBtn1 y fabBtn2)
        fabBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar el mensaje correspondiente al hacer clic en fabBtn1
                Toast.makeText(getApplicationContext(), "Tienes un mensaje de tu ex", Toast.LENGTH_SHORT).show();
            }
        });

        fabBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar el mensaje correspondiente al hacer clic en fabBtn2
                Toast.makeText(getApplicationContext(), "Recuerda revisar tu correo institucional", Toast.LENGTH_SHORT).show();
            }
        });


        // Botón normal: Regresa a MainActivity
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThanksButtons.this, MainButtons.class);
                startActivity(intent);
                finish(); // Cierra esta Activity
            }
        });
    }
}
