package com.example.test;

//toutes les classes nécessaires sont importées ici
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main4Activity extends AppCompatActivity {


    //déclaration des variables pour la suite

    private TextView mot_ok;
    int points = 0;
    Button passer;
    public int counter;
    private TextView minuteurtexte;
    private TextView compteur;
    ArrayList<String> motsatrouver = new ArrayList<String>();
    int pointscompteur;
    TextView rappelteam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //Cette commande permet de forcer l'affichage de l'écran en mode paysage (désirée pour notre jeu)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // on appelle le shared preference global
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        // on récupère la variable du tour (sous groupe Tour1)
        String tour1 = sharedpref.getString("Tour1","");

        //on vérfie si on a l'information
        if (tour1 != ""){
            TextView rappelnom = findViewById(R.id.nomtour);
            //on met la valeur récupérer dans un textview permettant le rappel de l'équipe qui joue
            rappelnom.setText(tour1);
        }

        //on fait disparaitre un bouton qu'on veut voire apparaitre plus tard
        passer = findViewById(R.id.passer);
        passer.setVisibility(View.INVISIBLE);


        //on initialise le jeu avev un texte demandant de cliquer pour lancer
        //on trouve le textview et on lui associe le texte voulu
        TextView motadeviner = findViewById(R.id.devine);
        motadeviner.setText("Cliquer pour lancer");

        //on récupère le nom du thème depuis le sous groupe theme du shared preference
        String nomtheme = sharedpref.getString("THEME","");


    //listes possibles, on prend celle indiqué avant grace au switch et a la donnée récupérée juste avant (celle du thème)
                switch (nomtheme) {
                    case "Profs":

                        //on vide le tableau pour être sur qu'il n'y a pas de données indésirables
                        motsatrouver.clear();

                        //on ajoute toutes nos données de jeu (on peut ajouter/retirer n'importe quel mot et donc modifier les listes a volonté)
                        motsatrouver.add("Winston");
                        motsatrouver.add("Jousset");
                        motsatrouver.add("Laouri Abdelaziz");
                        motsatrouver.add("Cyril Durand");
                        motsatrouver.add("Wolfgang Kuck");
                        motsatrouver.add("Stephan");
                        motsatrouver.add("Lallouche");
                        motsatrouver.add("Darties");
                        motsatrouver.add("Etienne Gibaud");
                        motsatrouver.add("Philippe Laugerette");
                        motsatrouver.add("Machetto");
                        motsatrouver.add("Miguel Angel Rivillo");
                        motsatrouver.add("François Mahou");
                        motsatrouver.add("Eric Barrandon");
                        motsatrouver.add("Mara");
                        motsatrouver.add("Dorveaux");
                        break;

                    case "Matières":
                        motsatrouver.clear();

                        motsatrouver.add("Maths abs");
                        motsatrouver.add("Signaux");
                        motsatrouver.add("OEM");
                        motsatrouver.add("Thermo");
                        motsatrouver.add("Méca flux");
                        motsatrouver.add("CPO");
                        motsatrouver.add("OMI");
                        motsatrouver.add("Tehcno Méca");
                        motsatrouver.add("Mécanique Générale");
                        motsatrouver.add("BDD");
                        motsatrouver.add("CDS");
                        motsatrouver.add("Chimie");
                        motsatrouver.add("Probas");
                        motsatrouver.add("Catia");
                        motsatrouver.add("Droit");
                        motsatrouver.add("Anglais");
                        motsatrouver.add("Espagnol");
                        motsatrouver.add("Allemand");
                        motsatrouver.add("Chinois");
                        motsatrouver.add("Projet Innovation");
                        motsatrouver.add("Matlab");
                        break;

                    case "Associations":
                        motsatrouver.clear();

                        motsatrouver.add("BDE");
                        motsatrouver.add("BDS");
                        motsatrouver.add("BDJ");
                        motsatrouver.add("L1PT");
                        motsatrouver.add("Helphi");
                        motsatrouver.add("CVE");
                        motsatrouver.add("UVA");
                        motsatrouver.add("Apostrophe");
                        motsatrouver.add("Good Vibes");
                        motsatrouver.add("Les tyrans d'eau");
                        motsatrouver.add("Alphinistes");
                        motsatrouver.add("BDA");
                        motsatrouver.add("BDC");
                        motsatrouver.add("BD TECH");
                        motsatrouver.add("EPF Projets");
                        motsatrouver.add("EPF Sud Conseil");
                        motsatrouver.add("BDO");
                        break;

                    case "Soirée":
                        motsatrouver.clear();

                        motsatrouver.add("Bouchon Catalan");
                        motsatrouver.add("Ptit comptoir");
                        motsatrouver.add("Babar");
                        motsatrouver.add("Austra");
                        motsatrouver.add("Antirouille");
                        motsatrouver.add("Mustang");
                        motsatrouver.add("Irish Corner");
                        motsatrouver.add("Jardin du Champ de Mars");
                        motsatrouver.add("WEI");
                        motsatrouver.add("Soirée parrainage");
                        motsatrouver.add("Gala");
                        motsatrouver.add("WED");
                        motsatrouver.add("Séjour Ski");
                        motsatrouver.add("Beaufria");
                        break;

                    //cas ou le thème choisi n'a aucune liste associée (et donc n'exite pas)
                    default:
                        //on envoie un message d'erreur disant que la liste n'existe pas
                        Toast.makeText(this, "Nous ne trouvons pas la liste que vous avez choisie ! ", Toast.LENGTH_SHORT).show();
                        //on renvoie à l'accueil
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);




                }





        //lorsque l'on clique sur l'écran (la textview prend tout l'écran) on interprète la partie du code suivante
        mot_ok = (TextView) findViewById(R.id.devine);
        mot_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //on crée un nombre aléatoire entre 0 et la taille de la liste du thème choisi
                Random random = new Random();
                int taillelist = motsatrouver.size(); //on récupère la taille de la liste
                int alea;
                alea = random.nextInt(taillelist);

                //on incrémente le compteur de points à chaque fois qu'on clique (et donc que le mot est trouvé)
                points++;
                //on stocke la valeur des points gagnés
                  pointscompteur = points-1;

                //on affiche les points dans le textview pour avoir le compte au fur et a mesure
                TextView compteur = findViewById(R.id.comptepoints);
                compteur.setText("Points : " + pointscompteur);

                //pour afficher le mot a deviner on prend un mot au hasard de la liste grace au nombre aléatoire calculé avant
                // ce dernier prendre donc un élément aléatoire de la liste
                TextView motadeviner = findViewById(R.id.devine);
                motadeviner.setText(motsatrouver.get(alea));


                //après le premier clique le compteur est à 1 donc on peut lancer le timer (le "cliquer pour commencer" a été utilisé)
            if (points == 1) {
                minuteurtexte = findViewById(R.id.minuteur);
                //on crée le minuteur avec comme base 30 secondes (30 000 millisecondes) et on avance de 1 secondes a chaque fois (1000 millisecondes)
                new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {

                        //pour chaque seconde on incrémente le minuteur
                        minuteurtexte.setText(String.valueOf(counter));
                        counter++;

                        //si le compteur arrive a 25 on change l'affichage en rouge pour mettre plus de pression et rappeler qu'il reste peu de temps
                        if (counter>=25) {
                            minuteurtexte.setTextColor((Color.parseColor("#FF0000")));

                        }
                    }

                    //lorsque le temps est écoulé on appelle la méthode finmanche
                    public void onFinish() {

                       finmanche();



                    }
                }.start();
                //on fait apparaitre le bouton maintenant
                passer.setVisibility(View.VISIBLE);
            }
            }


        });

    }



    //méthode de fin de manche
    public void finmanche() {

        rappelteam = findViewById(R.id.nomtour);
        //on récupère le nom de l'équipe qui joue (récupérée grâce au sous groupe Tour1 précedemment)
        String rappelnom = rappelteam.getText().toString();
        //on appelle le shared preference global
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        //on récupère les noms de équipes depuis les sous groupes associés
        String nomequipe1 = sharedpref.getString("equipe1","");
        String nomequipe2 = sharedpref.getString("equipe2","");
        //on prépare l'éditeur du shared preference
        SharedPreferences.Editor editor = sharedpref.edit();


        //on compare la valeur du rappel pour voir si c'est le nom de la première équipe si oui alors :
        if (rappelnom.equals(nomequipe1)){
        //on stocke la valeur des points gagnés par l'équipe 1 dans un sous groupe
        editor.putInt("points_equipe1",pointscompteur);
        //on l'envoie
        editor.commit();
        //et on va a l'activité suivante (activité 5)
        Intent intent3 = new Intent(this, Main5Activity.class);
        startActivity(intent3);

        //par contre si le rappel est égale au nom de la deuxième équipe on appelle la méthode finpartie
        } else if(rappelnom.equals(nomequipe2)){
            finpartie();
        }
    }


    //méthode pour terminer la partie est afficher les résultats
    private void finpartie() {
        //utilise le shared preference global
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        //on stocke les points de l'équipe 2 dans un sous groupe
        editor.putInt("points_equipe2",pointscompteur);
        editor.commit();
        //on accède a la dernière activité (la 7)
        Intent intent2 = new Intent(this, Main7Activity.class);
        startActivity(intent2);
    }


    //méthode qui permet de passer un mot
    public void passerunmot(View view){

        //on reprend le code pour avoir un nouveau mot aléatoire
        Random random = new Random();
        int taillelist = motsatrouver.size();
        int alea;
        alea = random.nextInt(taillelist);
        TextView motadeviner = findViewById(R.id.devine);
        //on affiche le nouveau mot ( on a bien passé le mot)
        motadeviner.setText(motsatrouver.get(alea));

    }

}




