package com.zzoft.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class adapter_category extends RecyclerView.Adapter<adapter_category.MyViewHolder> {

    Context context;
    ArrayList<item_category> item_categories_lista;

    public adapter_category(Context context, ArrayList<item_category> item_categories_lista) {
        this.context = context;
        this.item_categories_lista = item_categories_lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.item_category,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_category.MyViewHolder holder, int position) {

        item_category item_category_item=item_categories_lista.get(position);
        holder.textView_title.setText(item_category_item.titulo);
        Glide.with(context).load(item_category_item.portada).into(holder.iv);
       holder.b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(holder.b.getContext(),activity_pdf.class);
               intent.putExtra("List",item_category_item);
               holder.b.getContext().startActivity(intent);
           }
       });
    }



    @Override
    public int getItemCount() {
        return  item_categories_lista.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView_title;
        TextView textView_id;
        ImageView iv;
        Button b;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.titulo_item);
            iv = itemView.findViewById(R.id.image_item);
            b=itemView.findViewById(R.id.leerpdff);

        }
    }
}
