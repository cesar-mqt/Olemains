package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button goregles;
    private Button lancementjeu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        goregles = (Button) findViewById(R.id.regles);
        goregles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reglement();
            }
        });





    }




    public void recuperernomteam1 (View view){
        //on récupère la valeur dans le edittext et on l'associe a la variable
        EditText nomequipe1 = (EditText) findViewById(R.id.team1);
        String nomteam1 = nomequipe1.getText().toString();
        //Intent pour aller à l'activité
        Intent intent4 = new Intent(this, Main3Activity.class);
        //on utilise un Extra pour stocker la variable de l'équipe et la récupérer dans l'activité suivante
        intent4.putExtra("Equipe1",nomteam1);

        //on récupère la valeur dans le edittext et on l'associe a la variable
        EditText nomequipe2 = (EditText) findViewById(R.id.team2);
        String nomteam2 = nomequipe2.getText().toString();
        //Intent pour aller à l'activité
        Intent intent5 = new Intent(this, Main5Activity.class);
        //on utilise un Extra pour stocker la variable de l'équipe et la récupérer dans l'activité suivante
        intent5.putExtra("Equipe2",nomteam2);

        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();

        editor.putString("equipe1", nomteam1);
        editor.putString("equipe2",nomteam2);
        editor.commit();


        startActivity(intent4);
    }




    public void reglement() {
        Intent intent2 = new Intent(this, Main6Activity.class);
        startActivity(intent2);
    }



    }

