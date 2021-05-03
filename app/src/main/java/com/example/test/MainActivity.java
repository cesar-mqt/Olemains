package com.example.test;

//toutes les classes nécessaires sont importées ici
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bouttonaccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            bouttonaccueil = (Button) findViewById(R.id.newpartie);
            bouttonaccueil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    accueil();
                }
            });


            //Cette commande permet de forcer l'affichage de l'écran en mode paysage (désirée pour notre jeu)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

         

        }

        //méthode permettant d'aller a l'accueil du jeu (activity 2)
        public void accueil() {
            Intent intent2 = new Intent(this, Main2Activity.class);
            startActivity(intent2);
        }
    }
