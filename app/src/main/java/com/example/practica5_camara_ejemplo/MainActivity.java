package com.example.practica5_camara_ejemplo;

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

    public void lector(View viw){
        Intent intent = new Intent(getApplicationContext(), activity_lector.class);
        startActivity(intent);
    }//lector

    public void camara(View view){
        Intent intent = new Intent(getApplicationContext(),
                activity_foto.class);
        startActivity(intent);
    }//camara
}