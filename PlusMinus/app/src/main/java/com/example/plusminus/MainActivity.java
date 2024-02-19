package com.example.plusminus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    // Attributs pour les éléments de notre IHM
    TextView textView;
    EditText editText;
    Button button;
    TextView felicitation;
    EditText inputMin;
    EditText inputMax;
    Button buttonValider;
    Button buttonRestart;
    Button buttonFinish;

    // Attributs pour les nombres aléatoires
    int nbAleatoire;
    int max = 100;
    int min = 1;
    int nbEssais = 0;
    int input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genererNombre();

        // On récupère les éléments de notre IHM
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        felicitation = findViewById(R.id.felicitationText);
        inputMin = findViewById(R.id.textViewMin);
        inputMax = findViewById(R.id.textViewMax);
        buttonValider = findViewById(R.id.buttonMinMax);
        buttonRestart = findViewById(R.id.buttonRestart);
        buttonFinish = findViewById(R.id.buttonFinish);


        // On met en place un écouteur d'événement sur le bouton
       button.setOnClickListener(this::check);

       // On met en place un écouteur d'événement sur le bouton de validation du min et du max
       buttonValider.setOnClickListener(this::setMinMax);

         // On met en place un écouteur d'événement sur le bouton de restart
        buttonRestart.setOnClickListener(this::restart);

        // On met en place un écouteur d'événement sur le bouton de finish
        buttonFinish.setOnClickListener(this::finish);


    }

    // Méthode pour générer le nombre aléatoire
    public void genererNombre() {
        nbAleatoire = (int) (Math.random() * (max - min + 1)) + min;
    }

    // Méthode pour vérifier si le nombre est bon
    public void check(View view) {
        // on vérifie si le min et le max est set

        if (min == 0 && max == 0){
            textView.setText(R.string.text_view_errorMinMax);
            return;
        }



        // On incrémente le nombre d'essais
        nbEssais++;

        // On récupère le nombre entré par l'utilisateur
        try {
            input = Integer.parseInt(editText.getText().toString());
        } catch (NumberFormatException e) {
            textView.setText(R.string.text_view_exception);
            return;
        }
        editText.setText("");

        // gestion des erreurs
        if (input < 1 || input > 100) {
            textView.setText(R.string.text_view_error);
            return;
        }

        // On compare le nombre entré avec le nombre aléatoire
        if (input > nbAleatoire) {
            textView.setText(R.string.text_view_moins);
        } else if (input < nbAleatoire) {
            textView.setText(R.string.text_view_plus);
        } else{
            textView.setText("Bravo, vous avez trouvé le nombre en " + nbEssais + " essais !");
            button.setEnabled(false);
            feliciter();
        }
    }

    // Fonction pour set le min et le max quand on clique sur le bouton valider
    private void setMinMax(View view){

        try {
            min = Integer.parseInt(inputMin.getText().toString());
            max = Integer.parseInt(inputMax.getText().toString());
        } catch (NumberFormatException e) {
            textView.setText(R.string.text_view_errorMinMax);
            return;
        }
        inputMin.setText("");
        inputMax.setText("");
        textView.setText(R.string.textViewStart2);
        buttonValider.setEnabled(false);
        genererNombre();
    }

    // Féliciter l'utilisateur ou non
    private void feliciter(){
        if (nbEssais < Math.log10(max)){
            felicitation.setText(R.string.felicitation);
        }else{
            felicitation.setText(R.string.felicitation2);
        }
    }

    // Recommencer une partie
    private void restart(View view){
        button.setEnabled(true);
        buttonValider.setEnabled(true);
        textView.setText(R.string.textViewStart);
        felicitation.setText("");
        nbEssais = 0;
        genererNombre();
    }

    // Finir l'application
    private void finish(View view){
        finish();
    }
}