package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main6Activity extends AppCompatActivity {

    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        retour = (Button) findViewById(R.id.retouracc);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reglement();
            }
        });





    }
    public void reglement() {
        Intent intent2 = new Intent(this, Main2Activity.class);
        startActivity(intent2);
    }





    }

