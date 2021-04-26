package com.example.test;

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


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

         

        }
        public void accueil() {
            Intent intent2 = new Intent(this, Main2Activity.class);
            startActivity(intent2);
        }
    }
