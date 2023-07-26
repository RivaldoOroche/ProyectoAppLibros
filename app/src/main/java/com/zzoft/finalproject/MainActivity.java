package com.zzoft.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zzoft.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new FragmentHome());
        binding.menuvar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navbar01:
                    replaceFragment(new FragmentHome());
                    break;
                case R.id.navbar03:
                    replaceFragment(new FragmentCategory());
                    break;
                case R.id.navbar04:
                    replaceFragment(new FragmentBook());
                    break;
            }

            return true;
        });

    }

    public void irAddAlumno(View view){
        Intent i = new Intent(this, AddUserActivity.class);
        startActivity(i);
    }

    public void irCurso(View view){
        Intent i = new Intent(this, LibroActivity.class);
        startActivity(i);
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();

    }
}