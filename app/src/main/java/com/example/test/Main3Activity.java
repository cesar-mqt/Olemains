package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

       }

    }





    public void letsgo(View view) {


        //on récupère la valeur dans le edittext et on l'associe a la variable
        String nomdutheme = "Profs";
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);
        //on utilise un Extra pour stocker la variable et la récupérer dans l'activité suivante
        intent2.putExtra("THEME",nomdutheme);

        startActivity(intent2);

    }

    public void letsgo2(View view) {
        //on récupère la valeur dans le edittext et on l'associe a la variable
        String nomdutheme = "Matières";
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);
        //on utilise un Extra pour stocker la variable  et la récupérer dans l'activité suivante
        intent2.putExtra("THEME",nomdutheme);

        startActivity(intent2);
    }
    public void letsgo3(View view) {
        //on récupère la valeur dans le edittext et on l'associe a la variable
        String nomdutheme = "Associations";
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);
        //on utilise un Extra pour stocker la variable  et la récupérer dans l'activité suivante
        intent2.putExtra("THEME",nomdutheme);

        startActivity(intent2);
    }
    public void letsgo4(View view) {

        String nomdutheme = "Soirée";
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);
        //on utilise un Extra pour stocker la variable  et la récupérer dans l'activité suivante
        intent2.putExtra("THEME",nomdutheme);

        startActivity(intent2);
    }


}
