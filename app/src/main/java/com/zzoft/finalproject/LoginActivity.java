package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText txtusuario, txtpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtusuario = findViewById(R.id.inputUsername);
        txtpass = findViewById(R.id.inputPassword);
    }

    public void validar(View view){
        String us, pass;
        us = txtusuario.getText().toString();
        pass = txtpass.getText().toString();
        if(us.isEmpty()){
            Toast.makeText(this, "Ingrese UserName", Toast.LENGTH_SHORT).show();
            txtusuario.requestFocus();
        } else if(pass.isEmpty()){
            Toast.makeText(this, "Ingrese Password", Toast.LENGTH_SHORT).show();
            txtpass.requestFocus();
        } else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "project", null, 1);
            if(admin.verificarLogin(us, pass)){
                Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainActivity.class);
                limpiar();
                startActivity(i);
            } else {
                Toast.makeText(this,"Usuario o Password Incorrecto",Toast.LENGTH_SHORT).show();
                limpiar();
            }
        }
    }

    public void irNewCuenta(View view){
        Intent i = new Intent(this, AddUserActivity.class);
        startActivity(i);
    }

    public void limpiar(){
        txtpass.setText("");
        txtusuario.setText("");
    }

}