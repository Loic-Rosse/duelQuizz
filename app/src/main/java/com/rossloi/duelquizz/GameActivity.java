package com.rossloi.duelquizz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.rossloi.duelquizz.Controllers.QuestionManager;
import com.rossloi.duelquizz.Models.Question;

public class GameActivity extends AppCompatActivity {

    /**
     *  Déclaration
     */
    private TextView namePlayer1;
    private TextView namePlayer2;
    private TextView scorePlayer1;
    private TextView scorePlayer2;
    private TextView questionPlayer1;
    private TextView questionPlayer2;

    private Button replay;
    private Button menu;
    private Button answerPlayer1;
    private Button answerPlayer2;

    public Integer pointPlayer1 = 0;
    public Integer pointPlayer2 = 0;

    Runnable questionRunnable = null;
    public ConstraintLayout game;
    public Question questionAffichee;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
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

        game = findViewById(R.id.game);

        // Question des joueurs
        questionPlayer1 = findViewById(R.id.question1);
        questionPlayer2 = findViewById(R.id.question2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        namePlayer1.setText(intent.getStringExtra("player1"));
        namePlayer2.setText(intent.getStringExtra("player2"));
        tempsQuestion();
        answerPlayer1.setEnabled(false);
        answerPlayer2.setEnabled(false);
        replay.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);

        //Lors d'un click sur le bouton menu l'utilisateur est renvoyé au menu (disponible a la fin du jeu)
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                namePlayer1.setVisibility(View.VISIBLE);
                namePlayer2.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        //Lors d'un click sur le bouton restart l'utilisateur rejoue (disponible a la fin du jeu)
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("joueur1", namePlayer1.getText().toString());
                intent.putExtra("joueur2", namePlayer2.getText().toString());
                startActivity(intent);
            }
        });

        //Bouton du joueur 1 pour répondre aux questions (disponible durant le jeu)
        answerPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionAffichee.getReponse() == 1) {
                    answerPlayer1.setEnabled(false);
                    answerPlayer2.setEnabled(false);
                    pointPlayer1++;
                    scorePlayer1.setText(pointPlayer1.toString());
                } else if (pointPlayer1 > 0) {
                    pointPlayer1--;
                    scorePlayer1.setText(pointPlayer1.toString());
                }
            }
        });

        //Bouton du joueur 2 pour répondre aux questions (disponible durant le jeu)
        answerPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionAffichee.getReponse() == 1) {
                    answerPlayer1.setEnabled(false);
                    answerPlayer2.setEnabled(false);
                    pointPlayer2++;
                    scorePlayer2.setText(pointPlayer2.toString());
                } else {
                    if (pointPlayer2 > 0) {
                        pointPlayer2--;
                        scorePlayer2.setText(pointPlayer2.toString());
                    }
                }
            }
        });
    }

    /**
     * s'occupe du défilement et de l'affichage des questions
     */
    public void tempsQuestion() {
        QuestionManager qm = new QuestionManager(this);
        Handler handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                if (qm.isLastQuestion()) {
                    handler.removeCallbacks(this);
                    game.setVisibility(View.GONE);
                    pointPlayer1 = 0;
                    pointPlayer2 = 0;
                    replay.setVisibility(View.VISIBLE);
                    menu.setVisibility(View.VISIBLE);
                } else {
                    questionAffichee = qm.getRandomQuestion();
                    questionPlayer1.setText(questionAffichee.getQuestion());
                    questionPlayer2.setText(questionAffichee.getQuestion());
                    answerPlayer1.setEnabled(true);
                    answerPlayer2.setEnabled(true);

                    handler.postDelayed(this, 2000);
                }
            }
        };
        handler.postDelayed(questionRunnable, 2000);
    }

}

