package com.rossloi.duelquizz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    /**
     *  Déclaration
     */
    private TextView namePlayer1;
    private TextView namePlayer2;
    private TextView scorePlayer1;
    private TextView scorePlayer2;
    private

    private Button replay;
    private Button menu;
    private Button answerPlayer1;
    private Button answerPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /**
         *   Implémentation des ID
         */
        // Nom des joueurs
        namePlayer1 = findViewById(R.id.txt_namePlayer1);
        namePlayer2 = findViewById(R.id.txt_namePlayer2);

        // Score des joueurs
        scorePlayer1 = findViewById(R.id.txt_score1);
        scorePlayer2 = findViewById(R.id.txt_score2);

        // Bouton menu et rejouer
        replay = findViewById(R.id.bt_replay);
        menu = findViewById(R.id.bt_menu);

        // Bouton de réponse
        answerPlayer1 = findViewById(R.id.bt_player1);
        answerPlayer2 = findViewById(R.id.bt_player2);

    }
    protected void onStart(){
        super.onStart();
        replay.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);
    }
}
