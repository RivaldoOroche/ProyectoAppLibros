package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class activity_pdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        PDFView pdfView = findViewById(R.id.pdfviewer);
        pdfView.fromAsset("Filosofia-felina.pdf").load();
    }
}