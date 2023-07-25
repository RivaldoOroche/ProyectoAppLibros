package com.zzoft.finalproject;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUser extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String nombre,email, user, pass;
    private EditText nombreEdt, emailEdt, userEdt, passEdt;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentUser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentUser.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentUser newInstance(String param1, String param2) {
        FragmentUser fragment = new FragmentUser();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        // Obtener referencias a los EditTexts y otros elementos
        nombreEdt = rootView.findViewById(R.id.nameEt);
        emailEdt = rootView.findViewById(R.id.correoEt);
        userEdt = rootView.findViewById(R.id.userEt);
        passEdt = rootView.findViewById(R.id.inputPassword);

        // Obtener referencia al botón y establecer el listener
        FloatingActionButton saveButton = rootView.findViewById(R.id.saveUser);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarUser(view);
            }
        });

        return rootView;
    }

    public boolean validarDatosInsert(){
        boolean datoOk = false;

        nombre = nombreEdt.getText().toString();
        email = emailEdt.getText().toString();
        user = userEdt.getText().toString();
        pass = passEdt.getText().toString();

        if(nombre.isEmpty()){
            Toast.makeText(getContext(),"Ingresar Codigo", Toast.LENGTH_SHORT).show();
            nombreEdt.requestFocus();
        } else if (email.isEmpty()) {
            Toast.makeText(getContext(), "Ingresar Nombre", Toast.LENGTH_SHORT).show();
            emailEdt.requestFocus();
        }else if (user.isEmpty()) {
            Toast.makeText(getContext(), "Ingresar Telefono", Toast.LENGTH_SHORT).show();
            userEdt.requestFocus();
        }else if (pass.isEmpty()) {
            Toast.makeText(getContext(), "Ingresar Email", Toast.LENGTH_SHORT).show();
            passEdt.requestFocus();
        }else{
            //Consultar si el id ya existe
            datoOk = true;
        }
        return datoOk;
    }
    public void RegistrarUser(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "project", null, 1);
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
            Toast.makeText(getContext(), "Datos Registrados", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarControles(){
        nombreEdt.setText("");
        emailEdt.setText("");
        userEdt.setText("");
        passEdt.setText("");
    }
}