package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.telephony.ims.ImsMmTelManager;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class activity_pdf extends AppCompatActivity {
    private item_category ListItem;
    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pdf);
        initViews();
        init();



    }

    private void initViews(){
        textView=findViewById(R.id.titulodelibro);

    }
    private void init(){
        ListItem = (item_category) getIntent().getExtras().getSerializable("List");
        textView.setText(ListItem.getTitulo());
        PDFView pdfView = findViewById(R.id.pdfviewer);
        pdfView.fromAsset(String.valueOf(ListItem.getId())+".pdf").load();
    }
}