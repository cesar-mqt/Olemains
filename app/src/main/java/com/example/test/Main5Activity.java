package com.example.test;

//toutes les classes nécessaires sont importées ici
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

    //on déclare les variables
    TextView marchestp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        //Cette commande permet de forcer l'affichage de l'écran en mode paysage (désirée pour notre jeu)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //on ouvre le shared preference global
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        //on récupère le nom de l'équipe 2 depuis son sous groupe
        String nomequipe2 = sharedpref.getString("equipe2", "");
         marchestp = findViewById(R.id.nomequipe2);
         //on met le nom de l'équipe 2 dans le textview pour dire que c'est a lui de jouer
         marchestp.setText(nomequipe2 + " c'est a vous");


        //on vide le sous groupe Tour1 et on remplace par le nom de l'équipe 2 (pour avoir accès a la méthode de fin de partie vu plus tot)
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.remove("Tour1").commit();
        editor.putString("Tour1",nomequipe2);
        editor.commit();


            }


            //comme précedemment les 4 prochaines méthodes fonctionnent de la même façon

    public void letsgo21(View view) {
        String nomdutheme = "Profs";
        //on rappelle le shared preference global
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        //on vide la valeur précédente
        editor.remove("THEME").commit();
        //on met la nouvelle valeur du thème
        editor.putString("THEME",nomdutheme);
        editor.commit();
        //Intent pour aller à l'activité (retour à la 4 pour la manche de jeu)
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
