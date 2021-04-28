package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {


    private static final int DIALOG_ALERT = 10;
    String IDtheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);




       Intent intent = getIntent();
        if (intent != null) {
            String nomteam1 = "";
            if (intent.hasExtra("Equipe1")) {
                nomteam1 = intent.getStringExtra("Equipe1");
            }
            TextView affichageequipe = (TextView) findViewById(R.id.nomequipe_qui_commence);
            affichageequipe.setText(nomteam1 + " Sélectionnez votre thème ! ");

            SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpref.edit();
            editor.putString("Tour1",nomteam1);
            editor.commit();


       }



    }





    public void letsgo(View view) {
        String nomdutheme = "Profs";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);

    }

    public void letsgo2(View view) {
        String nomdutheme = "Matières";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);
    }


    public void letsgo3(View view) {
        String nomdutheme = "Associations";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);
    }


    public void letsgo4(View view) {
        String nomdutheme = "Soirée";
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);


        startActivity(intent2);
    }


}
