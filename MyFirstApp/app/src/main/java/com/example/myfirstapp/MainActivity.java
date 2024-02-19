package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v2);

        Button button = findViewById(R.id.button);
        button.setText(R.string.button_text2);

        /* Création des view depuis l'activité principale
        // Récupération du layout par son id
        LinearLayout layout = findViewById(R.id.linearLayout);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Création d'un text view
        TextView textView = new TextView(this);
        textView.setHint("Saisir un message ");

        // Création des contraintes
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textView.setLayoutParams(layoutParams);

        // Creation d'un Boutton
        Button button = new Button(this);
        button.setText("Envoyer");
        button.setLayoutParams(layoutParams);

        // Ajout des éléments au layout
        layout.addView(textView);
        layout.addView(button);

         */


    }
}