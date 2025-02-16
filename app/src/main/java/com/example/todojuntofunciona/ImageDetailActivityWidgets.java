package com.example.todojuntofunciona;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class ImageDetailActivityWidgets extends AppCompatActivity {
    private ImageView imageView;
    private RatingBar ratingBar;
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail_widgets);

        imageView = findViewById(R.id.imageViewDetail);

        // Obtener la imagen desde el Intent
        Intent intent = getIntent();
        if (intent.hasExtra("imagePath")) {
            imagePath = intent.getStringExtra("imagePath");
            Uri imageUri = Uri.parse(imagePath);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Enviar puntuación y regresar a la pantalla principal
        ratingBar = findViewById(R.id.ratingBar); // Obtiene una referencia al RatingBar en el diseño
        Button btnEnviar = findViewById(R.id.btnEnviarRating); // Obtiene una referencia al botón en el diseño
        btnEnviar.setOnClickListener(v -> {
            float rating = ratingBar.getRating(); // Obtiene la calificación del RatingBar
            Intent resultIntent = new Intent(); // Crea un nuevo Intent para el resultado
            resultIntent.putExtra("rating", rating); // Añade la calificación al Intent
            setResult(RESULT_OK, resultIntent); // Establece el resultado de la actividad
            finish(); // Finaliza la actividad
        });

    }
}

