package com.zzoft.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddAlumnoActivity extends AppCompatActivity {

    private String id, nombre, descripcion, fechaN, email, telefono;
    private EditText nombreEdt, idEdt, descripcionEdt, fechaNEdt, emailEdt, telefonoEdt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alumno);

        idEdt = findViewById(R.id.idEt);
        nombreEdt = findViewById(R.id.nameEt);
        telefonoEdt = findViewById(R.id.telfEt);
        emailEdt = findViewById(R.id.emailEt);
        fechaNEdt = findViewById(R.id.dobEt);
        descripcionEdt = findViewById(R.id.bioEt);
    }
    public boolean validarDatosInsert(){
        boolean datoOk = false;
        id = idEdt.getText().toString();
        nombre = nombreEdt.getText().toString();
        descripcion = descripcionEdt.getText().toString();
        fechaN = fechaNEdt.getText().toString();
        email = emailEdt.getText().toString();
        telefono = telefonoEdt.getText().toString();
        if(id.isEmpty()){
            Toast.makeText(this, "Ingresar Codigo", Toast.LENGTH_SHORT).show();
            idEdt.requestFocus();
        } else if (nombre.isEmpty()) {
            Toast.makeText(this, "Ingresar Nombre", Toast.LENGTH_SHORT).show();
            nombreEdt.requestFocus();
        }else if (telefono.isEmpty()) {
            Toast.makeText(this, "Ingresar Telefono", Toast.LENGTH_SHORT).show();
            telefonoEdt.requestFocus();
        }else if (email.isEmpty()) {
            Toast.makeText(this, "Ingresar Email", Toast.LENGTH_SHORT).show();
            emailEdt.requestFocus();
        }else if (fechaN.isEmpty()) {
            Toast.makeText(this, "Ingresar Fecha de Nacimiento", Toast.LENGTH_SHORT).show();
            fechaNEdt.requestFocus();
        }else{
            //Consultar si el id ya existe
            datoOk = true;
        }
        return datoOk;
    }

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "project", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if(validarDatosInsert()){
            ContentValues datos = new ContentValues();
            datos.put("id", id);
            datos.put("nombre", nombre);
            datos.put("telefono", telefono);
            datos.put("email", email);
            datos.put("fechaN", fechaN);
            datos.put("descrip", descripcion);
            db.insert("alumno", null,datos);
            db.close();
            limpiarControles();
            Toast.makeText(this, "Datos Registrados", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarControles(){
        idEdt.setText("");
        nombreEdt.setText("");
        telefonoEdt.setText("");
        emailEdt.setText("");
        fechaNEdt.setText("");
        descripcionEdt.setText("");
    }

}