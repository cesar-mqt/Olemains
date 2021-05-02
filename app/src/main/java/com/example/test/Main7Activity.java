package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        TextView resultatsequip1;
        TextView resultatsequip2;
        TextView victoire;

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        int pointsfin1 = sharedpref.getInt("points_equipe1",0);
        int pointsfin2 = sharedpref.getInt("points_equipe2",0);
        String nomequipe1 = sharedpref.getString("equipe1","");
        String nomequipe2 = sharedpref.getString("equipe2","");
        victoire = findViewById(R.id.gagnant);

        if (pointsfin1>pointsfin2) {
            String resultat1 = "Le gagnant est : " + "\n" + nomequipe1;
            victoire.setText(resultat1);
        } else if (pointsfin1<pointsfin2) {
            String resultat1 = "Le gagnant est : " + "\n" + nomequipe2;
            victoire.setText(resultat1);
        }else if (pointsfin1==pointsfin2){
            String resultat1 = "EGALITE";
            victoire.setText(resultat1);
        }

        resultatsequip1 = findViewById(R.id.result1);
        resultatsequip2 = findViewById(R.id.result2);

        resultatsequip1.setText(nomequipe1 + " a obtenu : " + "\n" + pointsfin1 + " points");
        resultatsequip2.setText(nomequipe2 + " a obtenu : " + "\n" + pointsfin2 + " points");






    }

    public void nouvellepartie(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        SharedPreferences sharedpref = getSharedPreferences("donnees", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.remove("points_equipe1").commit();
        editor.remove("points_equipe2").commit();
        startActivity(intent);

    }


}
