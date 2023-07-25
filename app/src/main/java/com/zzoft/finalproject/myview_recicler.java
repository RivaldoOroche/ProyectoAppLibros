package com.zzoft.finalproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myview_recicler  extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView titulo;

    public myview_recicler(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image_item);
        titulo=itemView.findViewById(R.id.titulo_item);

    }
}
