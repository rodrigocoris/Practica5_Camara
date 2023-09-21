package com.example.practica5_camara_ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class activity_lector extends AppCompatActivity {

    //instancias
    private EditText resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector);
        //asociar componente
        resultado = findViewById(R.id.edtResultado);
    }//oncreate

    public void escanearCodigoBarra(View view){
       IntentIntegrator intentIntegrator = new IntentIntegrator(activity_lector.this);

       intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);

        intentIntegrator.setPrompt("Lector - CDP");
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.initiateScan();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
            IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            //validar que si recibe informacion
        if(intentResult !=null){
            if (intentResult.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Dtos leidos", Toast.LENGTH_SHORT).show();
                resultado.setText(intentResult.getContents());
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}