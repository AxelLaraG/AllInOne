package com.example.todojuntofunciona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainWidgets extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageAdapterWidgets imageAdapterWidgets;
    private ArrayList<String> imageList;  // Lista de imágenes (almacenaremos las rutas)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets);

        Button btnReturn = findViewById(R.id.btnReturnWidgets);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainWidgets.this, MainMenu.class);
                startActivity(intent);
                finish(); // Cierra esta Activity
            }
        });


        FloatingActionButton fabAdd = findViewById(R.id.fab_add);

        // Inicializar lista y adaptador
        imageList = new ArrayList<>(); // Inicializa la lista de imágenes
        imageAdapterWidgets = new ImageAdapterWidgets(this, imageList); // Inicializa el adaptador de imágenes

        recyclerView = findViewById(R.id.recyclerView); // Obtiene una referencia al RecyclerView en el diseño
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // Configura un diseño de cuadrícula con 2 columnas
        recyclerView.setAdapter(imageAdapterWidgets); // Asigna el adaptador al RecyclerView


        // Botón para ir a la pantalla de carga de imágenes
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainWidgets.this, UploadActivity.class);
                startActivityForResult(intent, 1);  // Esperamos un resultado
            }
        });
    }

    // Recibe la imagen subida y la agrega al banner
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String imagePath = data.getStringExtra("imagePath");
            if (imagePath != null) {
                imageList.add(imagePath);
                imageAdapterWidgets.notifyDataSetChanged();
            }
        }
    }
}
