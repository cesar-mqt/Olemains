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

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);

        int pointfin1 = sharedpref.getInt("points_equipe1",0 );
        int pointfin2 = sharedpref.getInt("points_equipe2", 0);

        TextView equipe1points = (TextView) findViewById(R.id.pointequipe1fin);
        equipe1points.setText(pointfin1);

        TextView equipe2points = (TextView) findViewById(R.id.pointequipe2fin);
        equipe2points.setText(pointfin2);


    }
}
