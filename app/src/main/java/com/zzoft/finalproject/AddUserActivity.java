package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddUserActivity extends AppCompatActivity {

    private String nombre,email, user, pass;
    private EditText nombreEdt, emailEdt, userEdt, passEdt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alumno);

        nombreEdt = findViewById(R.id.nameEt);
        emailEdt = findViewById(R.id.correoEt);
        userEdt = findViewById(R.id.userEt);
        passEdt = findViewById(R.id.inputPassword);
    }
    public boolean validarDatosInsert(){
        boolean datoOk = false;

        nombre = nombreEdt.getText().toString();
        email = emailEdt.getText().toString();
        user = userEdt.getText().toString();
        pass = passEdt.getText().toString();

        if(nombre.isEmpty()){
            Toast.makeText(this,"Ingresar Codigo", Toast.LENGTH_SHORT).show();
            nombreEdt.requestFocus();
        } else if (email.isEmpty()) {
            Toast.makeText(this, "Ingresar Nombre", Toast.LENGTH_SHORT).show();
            emailEdt.requestFocus();
        }else if (user.isEmpty()) {
            Toast.makeText(this, "Ingresar Telefono", Toast.LENGTH_SHORT).show();
            userEdt.requestFocus();
        }else if (pass.isEmpty()) {
            Toast.makeText(this, "Ingresar Email", Toast.LENGTH_SHORT).show();
            passEdt.requestFocus();
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
            datos.put("nombres", nombre);
            datos.put("email", email);
            datos.put("user", user);
            datos.put("password", pass);
            db.insert("tblUser", null,datos);
            db.close();
            limpiarControles();
            Toast.makeText(this, "Datos Registrados", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarControles(){
        nombreEdt.setText("");
        emailEdt.setText("");
        userEdt.setText("");
        passEdt.setText("");
    }

}