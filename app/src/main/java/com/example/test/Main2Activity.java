package com.example.test;

//toutes les classes nécessaires sont importées ici
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main2Activity extends AppCompatActivity {

    //on déclare les variables dont on aura besoin plus tard dans le code
    private Button goregles;
    private Button lancementjeu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //Cette commande permet de forcer l'affichage de l'écran en mode paysage (désirée pour notre jeu)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //on réagit lorsque l'on clique sur le bouton des règles en appelant la méthode correspondante
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
        //Intent pour aller à l'activité 3
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

        //on crée un sharedpreference afin de récupérer la variable dans n'importe quelle activité  on lui donne le nom global "données"
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        //on crée l'editeur de ce sharedpreference pour ajouter/supprimer/envoyer des données
        SharedPreferences.Editor editor = sharedpref.edit();

        //on ajoute les données dans des sous groupes ici équipes 1 et 2 (on envoie ici les noms des équipes)
        editor.putString("equipe1", nomteam1);
        editor.putString("equipe2",nomteam2);
        //on envoie les données pour les récupérer plus tard
        editor.commit();


        startActivity(intent4);
    }




    //méthode pour aller vers l'activité des règles (associée au bouton règles)
    public void reglement() {
        Intent intent2 = new Intent(this, Main6Activity.class);
        startActivity(intent2);
    }



    }

