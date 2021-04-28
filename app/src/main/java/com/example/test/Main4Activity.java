package com.example.test;

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

    private TextView mot_ok;
    int points = 0;
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
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        String tour1 = sharedpref.getString("Tour1","");

        if (tour1 != ""){
            TextView rappelnom = findViewById(R.id.nomtour);
            rappelnom.setText(tour1);
        }





        TextView motadeviner = findViewById(R.id.devine);
        motadeviner.setText("Cliquer pour lancer");


        String nomtheme = sharedpref.getString("THEME","");



                switch (nomtheme) {
                    case "Profs":
                        motsatrouver.clear();

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
                        motsatrouver.add("Miguel Angel Rivillo Ruiz");
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

                    default:
                        Toast.makeText(this, "Nous ne trouvons pas la liste que vous avez choisie ! ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);




                }






        mot_ok = (TextView) findViewById(R.id.devine);
        mot_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startstop(); //lancement timer




                Random random = new Random();
                int taillelist = motsatrouver.size();
                int alea;
                alea = random.nextInt(taillelist);


                points++;
                  pointscompteur = points-1;

                TextView compteur = findViewById(R.id.comptepoints);
                compteur.setText("Points : " + pointscompteur);

                TextView motadeviner = findViewById(R.id.devine);
                motadeviner.setText(motsatrouver.get(alea));


            if (points == 1) {
                minuteurtexte = findViewById(R.id.minuteur);
                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        minuteurtexte.setText(String.valueOf(counter));
                        counter++;
                        if (counter>=25) {
                            minuteurtexte.setTextColor((Color.parseColor("#FF0000")));

                        }
                    }

                    public void onFinish() {

                       finmanche();



                    }
                }.start();
            }
            }


        });

    }

    private void finpartie() {
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putInt("points_equipe2",pointscompteur);
        editor.commit();
        Intent intent2 = new Intent(this, Main7Activity.class);
        startActivity(intent2);
    }


    public void finmanche() {

        rappelteam = findViewById(R.id.nomtour);
        String rappelnom = rappelteam.getText().toString();
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        String nomequipe1 = sharedpref.getString("equipe1","");
        String nomequipe2 = sharedpref.getString("equipe2","");
        SharedPreferences.Editor editor = sharedpref.edit();

        if (rappelnom.equals(nomequipe1)){
        editor.putInt("points_equipe1",pointscompteur);
        editor.commit();
        Intent intent3 = new Intent(this, Main5Activity.class);
        startActivity(intent3);

        } else if(rappelnom.equals(nomequipe2)){
            finpartie();
        }
    }

}




