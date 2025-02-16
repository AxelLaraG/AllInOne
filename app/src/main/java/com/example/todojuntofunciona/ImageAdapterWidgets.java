package com.example.todojuntofunciona;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class ImageAdapterWidgets extends RecyclerView.Adapter<ImageAdapterWidgets.ViewHolder> {
    private Context context;
    private ArrayList<String> imageList;

    public ImageAdapterWidgets(Context context, ArrayList<String> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_image_widgets, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imagePath = imageList.get(position);
        Glide.with(context).load(imagePath).into(holder.imageView);

        // Al hacer clic en la imagen, ir a la pantalla de detalles
        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ImageDetailActivityWidgets.class);
            intent.putExtra("imagePath", imagePath);
            ((MainActivity) context).startActivityForResult(intent, 2);
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

