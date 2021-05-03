package com.example.test;

//toutes les classes nécessaires sont importées ici
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main7Activity extends AppCompatActivity {

    //on déclare nos variables
    TextView resultatsequip1;
    TextView resultatsequip2;
    TextView victoire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        //Cette commande permet de forcer l'affichage de l'écran en mode paysage (désirée pour notre jeu)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //on récupère dans le shared preference global les noms de équipes et les points des équipes dans les sous groupes associés
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        int pointsfin1 = sharedpref.getInt("points_equipe1",0);
        int pointsfin2 = sharedpref.getInt("points_equipe2",0);
        String nomequipe1 = sharedpref.getString("equipe1","");
        String nomequipe2 = sharedpref.getString("equipe2","");

        victoire = findViewById(R.id.gagnant);

        //on définit le vainqueur en comparant les points

        //si l'équipe 1 a plus de points
        if (pointsfin1>pointsfin2) {
            //on affiche que l'équipe 1 gagne et son nombre de points
            String resultat1 = "Le gagnant est : " + "\n" + nomequipe1;
            victoire.setText(resultat1);

            //si l'équipe 2 a plus de points
        } else if (pointsfin1<pointsfin2) {
            //on affiche que l'équipe 2 gagne et son nombre de points
            String resultat1 = "Le gagnant est : " + "\n" + nomequipe2;
            victoire.setText(resultat1);

            //si les équipes ont le meme nombre de points
        }else if (pointsfin1==pointsfin2){
            //on affiche l'égalité
            String resultat1 = "EGALITE";
            victoire.setText(resultat1);
        }


        //on met de part et d'autre de la coupe le résultat des deux équipes
        resultatsequip1 = findViewById(R.id.result1);
        resultatsequip2 = findViewById(R.id.result2);

        resultatsequip1.setText(nomequipe1 + " a obtenu : " + "\n" + pointsfin1 + " points");
        resultatsequip2.setText(nomequipe2 + " a obtenu : " + "\n" + pointsfin2 + " points");






    }

    //méthode pour une nouvelle partie directement définie dans le layout avec le Onclick (s'active lorsqu'on clique sur le bouton)
    public void nouvellepartie(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        //on vide le nom des équipes désormais inutiles
        editor.remove("points_equipe1").commit();
        editor.remove("points_equipe2").commit();
        //on revient à l'accueil
        startActivity(intent);

    }


}
