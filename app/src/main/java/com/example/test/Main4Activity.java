package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main4Activity extends AppCompatActivity {

    private TextView mot_ok;
    int points = 0;
public int counter;

    private TextView minuteurtexte;
    private TextView compteur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        TextView motadeviner = findViewById(R.id.devine);
        motadeviner.setText("Cliquer pour lancer");


        mot_ok = (TextView) findViewById(R.id.devine);
        mot_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startstop(); //lancement timer


                ArrayList<String> motsatrouver = new ArrayList<String>();
                motsatrouver.add("Chateau de Versaille");
                motsatrouver.add("Montpellier");
                motsatrouver.add("Jousset");
                motsatrouver.add("Winston");
                motsatrouver.add("Dorveaux");
                motsatrouver.add("Stephan");
                motsatrouver.add("Jean Jacques Goldman");

                Random random = new Random();
                int taillelist = motsatrouver.size();
                int alea;
                alea = random.nextInt(taillelist);


                points++;
                int pointscompteur = points-1;

                TextView compteur = findViewById(R.id.comptepoints);
                compteur.setText("Points : " + pointscompteur);

                TextView motadeviner = findViewById(R.id.devine);
                motadeviner.setText(motsatrouver.get(alea));

            if (points == 1) {
                minuteurtexte = findViewById(R.id.minuteur);
                new CountDownTimer(30000, 1000) { // adjust the milli seconds here

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

    public void finmanche() {
        Intent intent3 = new Intent(this, Main5Activity.class);
        startActivity(intent3);
    }


}




