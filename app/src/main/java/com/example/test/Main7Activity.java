package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        TextView fin1;
        TextView fin2;

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        int pointsfin1 = sharedpref.getInt("points_equipe1",0);
        int pointsfin2 = sharedpref.getInt("points_equipe2",0);

        fin1 = findViewById(R.id.pointequipe1fin);
        fin2 = findViewById(R.id.pointequipe2fin);



            if (pointsfin1 != 0 && pointsfin2 != 0){

                String resultat1 = "L'équipe 1 à : " + pointsfin1;
                fin1.setText(resultat1);

                String resultat2 = "L'équipe 2 à : " + pointsfin2;
                fin2.setText(resultat2);



            }




    }
}
