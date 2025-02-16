package com.example.todojuntofunciona;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class UploadActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private SeekBar seekBarBrillo, seekBarContraste;
    private Bitmap originalBitmap, editedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_widgets);

        imageView = findViewById(R.id.imageViewUpload);
        seekBarBrillo = findViewById(R.id.seekBarBrillo);
        seekBarContraste = findViewById(R.id.seekBarContraste);
        Button btnCargar = findViewById(R.id.btnCargar);
        Button btnSubir = findViewById(R.id.btnSubir);

        // Seleccionar imagen desde la galería
        btnCargar.setOnClickListener(v -> openGallery());

        // Aplicar brillo y contraste
        seekBarBrillo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Llamar a aplicarEfectos() cuando cambia el progreso del SeekBar
                aplicarEfectos();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBarContraste.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                aplicarEfectos();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Subir imagen editada al banner
        btnSubir.setOnClickListener(v -> {
            if (editedBitmap != null) {
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), editedBitmap, "title", null);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("imagePath", path);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            try {
                originalBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(originalBitmap);
                editedBitmap = originalBitmap.copy(originalBitmap.getConfig(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void aplicarEfectos() {
        if (originalBitmap == null) return;

        float brillo = (seekBarBrillo.getProgress() - 50) / 50f;
        float contraste = (seekBarContraste.getProgress() + 50) / 50f;

        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Bitmap nuevoBitmap = bitmap.copy(bitmap.getConfig(), true);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                contraste, 0, 0, 0, brillo * 255,
                0, contraste, 0, 0, brillo * 255,
                0, 0, contraste, 0, brillo * 255,
                0, 0, 0, 1, 0
        });

        ColorMatrixColorFilter filtro = new ColorMatrixColorFilter(colorMatrix);
        imageView.setColorFilter(filtro);
        editedBitmap = nuevoBitmap;
    }
}