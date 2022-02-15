package com.rossloi.duelquizz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Déclaration
    private EditText player1;
    private EditText player2;
    private TextView textPlayer1;
    private TextView textPlayer2;
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Implémentation des ID
        player1 = findViewById(R.id.ed_player1);
        textPlayer1 = findViewById(R.id.txt_player1);
        player2 = findViewById(R.id.ed_player2);
        textPlayer2 = findViewById(R.id.txt_player2);
        play = findViewById(R.id.bt_play);

        player1.setOnClickListener(this);
        play.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textPlayer2.setVisibility(View.INVISIBLE);
        player2.setVisibility(View.INVISIBLE);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ed_player1:
                textPlayer2.setVisibility(View.VISIBLE);
                player2.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_play:
        }
    }
}
