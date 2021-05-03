package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    private Button retour;
    TextView regles;

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


        regles = findViewById(R.id.regles);
        String txtregles = "1. Constituez des équipes et entrez le nom de vos équipes dans les cadres prévus\n" +
                "2. Un membre de l’équipe 1 choisi un des thèmes proposés\n" +
                "3. Ce dernier place le téléphone sur son front (de sorte que l’écran soit visible pour toute son équipe)\n" +
                "4. Les membres de son équipe tentent de lui faire deviner le mot/nom affiché\n" +
                "5. Une fois que ce joueur trouve le mot/nom à deviner, il clique sur l’écran et valide 1 point, puis passe au mot/nom suivant et ce pendant un temps total de 30 secondes\n" +
                "6. Lorsque la partie de l’équipe 1 est terminée, c’est au tour de l’équipe 2 de commencer sa partie en suivant ces mêmes règles\n" +
                "7. Que la meilleure équipe gagne!";

        regles.setText(txtregles);



    }
    public void reglement() {
        Intent intent2 = new Intent(this, Main2Activity.class);
        startActivity(intent2);
    }





    }

