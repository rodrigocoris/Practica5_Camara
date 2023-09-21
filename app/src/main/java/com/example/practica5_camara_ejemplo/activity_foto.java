package com.example.practica5_camara_ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class activity_foto extends AppCompatActivity {

    //intancias
    private ImageView foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        //asociar
        foto = findViewById(R.id.imgimagen);
    }//on create

    public void tomarFoto(View view){
        abrirCamara();
    }//tomarFoto
    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent,1);
    }//abirCamara
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "Tomar foto", Toast.LENGTH_SHORT).show();
        if( requestCode == 1 && resultCode == RESULT_OK){
            Toast.makeText(this, "Foto capturada",
                    Toast.LENGTH_SHORT).show();
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imgBitmap);
        }
    }//onActivityResult


}