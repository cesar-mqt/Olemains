package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main5Activity extends AppCompatActivity {

    TextView marchestp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);

        String nomequipe2 = sharedpref.getString("equipe2", "");
         marchestp = findViewById(R.id.nomequipe2);
         marchestp.setText(nomequipe2 + " c'est a vous");



        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("Tour1",nomequipe2);
        editor.commit();


            }







}
