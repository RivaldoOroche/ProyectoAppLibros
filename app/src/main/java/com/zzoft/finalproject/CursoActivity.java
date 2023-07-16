package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CursoActivity extends AppCompatActivity {

    private EditText codigoEt;
    private String idAlumno;

    private Spinner spinner;
    private String[] options = {"Opción 1", "Opción 2", "Opción 3"};


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        codigoEt = findViewById(R.id.codEt);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption = options[i];
                Toast.makeText(CursoActivity.this, "Seleccionaste: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public boolean validar(){
        boolean datoOk = false;
        idAlumno = codigoEt.getText().toString();

        if(idAlumno.isEmpty()){
            Toast.makeText(this, "Ingresar Codigo", Toast.LENGTH_SHORT).show();
            codigoEt.requestFocus();
        }else{
            //Consultar si el id ya existe
            datoOk = true;
        }
        return datoOk;
    }

    public void insertTable(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "project", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        if(validar()){
            //db.rawQuery("insert into TBLCURSO (idAlumno, nombreAlumno) select id, nombre from TBLALUMNO where id="+idAlumno,null);
            db.rawQuery("select id, nombre into TBLCURSO from TBLALUMNO where id ="+idAlumno,null);
            Toast.makeText(this, "Datos Registrados", Toast.LENGTH_SHORT).show();
        }

    }

}