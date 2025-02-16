package com.example.todojuntofunciona;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.*;

public class MainText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_text);

        EditText name = findViewById(R.id.nameTex);
        EditText email = findViewById(R.id.emailTex);
        EditText phone = findViewById(R.id.phoneTex);
        EditText password = findViewById(R.id.passwordTex);
        EditText postalAddress = findViewById(R.id.postalAddressTex);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextViewTex);
        Button submitButton = findViewById(R.id.submitButtonTex);
        TextView resultTextView = findViewById(R.id.textView5Tex);

        Button btnReturn = findViewById(R.id.btnReturnTexts);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainText.this, MainMenu.class);
                startActivity(intent);
                finish(); // Cierra esta Activity
            }
        });

        // Configuración del autocompletado
        String[] suggestions = {"Android", "iOS", "Windows", "Linux"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, suggestions);
        autoCompleteTextView.setAdapter(adapter);

        // Evento del botón de registro
        submitButton.setOnClickListener(v -> {
            String userInfo = "Registro Exitoso:\n" +
                    "Nombre: " + name.getText().toString() + "\n" +
                    "Correo: " + email.getText().toString() + "\n" +
                    "Teléfono: " + phone.getText().toString() + "\n" +
                    "Dirección: " + postalAddress.getText().toString();
            resultTextView.setText(userInfo);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainText), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
