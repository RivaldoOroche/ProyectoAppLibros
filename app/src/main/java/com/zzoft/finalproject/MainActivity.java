package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAddAlumno(View view){
        Intent i = new Intent(this, AddAlumnoActivity.class);
        startActivity(i);
    }

    public void irCurso(View view){
        Intent i = new Intent(this, CursoActivity.class);
        startActivity(i);
    }
}