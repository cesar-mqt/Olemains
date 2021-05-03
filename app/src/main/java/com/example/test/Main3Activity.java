package com.example.test;

//toutes les classes nécessaires sont importées ici
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


    //on déclare les variables néessaires
    private static final int DIALOG_ALERT = 10;
    String IDtheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        //Cette commande permet de forcer l'affichage de l'écran en mode paysage (désirée pour notre jeu)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        //on récupère les données envoyées précedemment par le extra en vérifiant qu'il y a bien des données
       Intent intent = getIntent();
        if (intent != null) {
            String nomteam1 = "";
            if (intent.hasExtra("Equipe1")) {
                nomteam1 = intent.getStringExtra("Equipe1");
            }

            //on met le nom de l'équipe dans la case voulue (demandant de choisir le thème)
            TextView affichageequipe = (TextView) findViewById(R.id.nomequipe_qui_commence);
            affichageequipe.setText(nomteam1 + " Sélectionnez votre thème ! ");

            //on appelle le sharedpreference global
            SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpref.edit();
            //on met une nouvelle donnée dans un nouveau sous groupe
            editor.putString("Tour1", nomteam1);
            //on envoie la donnée
            editor.commit();

        }


    }







       //ces 4 méthodes permettent de récupérer le thème choisi de la même manière
       // la seule différence est la valeur de la variable envoyée dans le sharedpreference


    public void letsgo(View view) {
        //on crée la variable contenant le nom du thème
        String nomdutheme = "Profs";
        //on appelle le sharedpreference global
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        //on edit le sharedpreference
        SharedPreferences.Editor editor = sharedpref.edit();
        //on ajoute au sous groupe thème le nom du thème en question
        editor.putString("THEME",nomdutheme);
        //on envoie la donnée
        editor.commit();
        //Intent pour aller à l'activité
        Intent intent2 = new Intent(this, Main4Activity.class);

        //on appelle l'ativité
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
