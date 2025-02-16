package com.example.todojuntofunciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Screen3Buttons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_screen3_buttons);

        FloatingActionButton fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Screen3Buttons.this, "ADVERTENCIA: El usuario es muy guapo", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fabSubmit = findViewById(R.id.fabSubmit);
        fabSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje emergente con AlertDialog
                new AlertDialog.Builder(Screen3Buttons.this)
                        .setTitle("Éxito")
                        .setMessage("Formulario enviado con éxito.")
                        .setPositiveButton("OK", (dialog, which) -> {
                            // Redirigir a la pantalla de agradecimientos
                            Intent intent = new Intent(Screen3Buttons.this, ThanksButtons.class);
                            startActivity(intent);
                            finish(); // Finaliza esta actividad para que no pueda volver atrás con el botón de retroceso
                        })
                        .show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.screen3Buttons), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

