package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView nomdelapremiereequipe;
    Button debutpartie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        debutpartie = (Button) findViewById(R.id.Commencer);
        debutpartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsgo();
            }
        });



       Intent intent = getIntent();
        if (intent != null) {
            String nomteam1 = "";
            if (intent.hasExtra("Equipe1")) {
                nomteam1 = intent.getStringExtra("Equipe1");
            }
            TextView affichageequipe = (TextView) findViewById(R.id.nomequipe_qui_commence);
            affichageequipe.setText(nomteam1 + " Etes vous prêt ?");





       }
    }
    public void letsgo() {
        Intent intent2 = new Intent(this, Main4Activity.class);
        startActivity(intent2);
    }

}
