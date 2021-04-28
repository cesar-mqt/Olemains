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
        editor.remove("Tour1").commit();
        editor.putString("Tour1",nomequipe2);
        editor.commit();


            }

    public void letsgo21(View view) {
        String nomdutheme = "Profs";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.remove("THEME").commit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);

    }

    public void letsgo22(View view) {
        String nomdutheme = "Matières";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.remove("THEME").commit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);
    }


    public void letsgo23(View view) {
        String nomdutheme = "Associations";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.remove("THEME").commit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);
    }


    public void letsgo24(View view) {
        String nomdutheme = "Soirée";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.remove("THEME").commit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);
    }





}
