/**
 * @author Joshua Hernandez
 * @author John Lavin
 */

package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Chess extends AppCompatActivity {

    Button playerVplayer, gamesPlayed;
    ImageButton btn_a1, btn_b1, btn_c1, btn_d1, btn_e1, btn_f1, btn_g1, btn_h1,
            btn_a2, btn_b2, btn_c2, btn_d2, btn_e2, btn_f2, btn_g2, btn_h2,
            btn_a3, btn_b3, btn_c3, btn_d3, btn_e3, btn_f3, btn_g3, btn_h3,
            btn_a4, btn_b4, btn_c4, btn_d4, btn_e4, btn_f4, btn_g4, btn_h4,
            btn_a5, btn_b5, btn_c5, btn_d5, btn_e5, btn_f5, btn_g5, btn_h5,
            btn_a6, btn_b6, btn_c6, btn_d6, btn_e6, btn_f6, btn_g6, btn_h6,
            btn_a7, btn_b7, btn_c7, btn_d7, btn_e7, btn_f7, btn_g7, btn_h7,
            btn_a8, btn_b8, btn_c8, btn_d8, btn_e8, btn_f8, btn_g8, btn_h8;

    TextView txtTurn;

    String output = "";
    boolean gameStillRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_interface);

        playerVplayer = findViewById(R.id.playerVplayer);
        gamesPlayed = findViewById(R.id.gamesPlayed);

        playerVplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.play_chess);
                btn_a1 = findViewById(R.id.btn1a);
                btn_a2 = findViewById(R.id.btn2a);
                btn_a3 = findViewById(R.id.btn3a);
                btn_a4 = findViewById(R.id.btn4a);
                btn_a5 = findViewById(R.id.btn5a);
                btn_a6 = findViewById(R.id.btn6a);
                btn_a7 = findViewById(R.id.btn7a);
                btn_a8 = findViewById(R.id.btn8a);
                btn_b1 = findViewById(R.id.btn1b);
                btn_b2 = findViewById(R.id.btn2b);
                btn_b3 = findViewById(R.id.btn3b);
                btn_b4 = findViewById(R.id.btn4b);
                btn_b5 = findViewById(R.id.btn5b);
                btn_b6 = findViewById(R.id.btn6b);
                btn_b7 = findViewById(R.id.btn7b);
                btn_b8 = findViewById(R.id.btn8b);
                btn_c1 = findViewById(R.id.btn1c);
                btn_c2 = findViewById(R.id.btn2c);
                btn_c3 = findViewById(R.id.btn3c);
                btn_c4 = findViewById(R.id.btn4c);
                btn_c5 = findViewById(R.id.btn5c);
                btn_c6 = findViewById(R.id.btn6c);
                btn_c7 = findViewById(R.id.btn7c);
                btn_c8 = findViewById(R.id.btn8c);
                btn_d1 = findViewById(R.id.btn1d);
                btn_d2 = findViewById(R.id.btn2d);
                btn_d3 = findViewById(R.id.btn3d);
                btn_d4 = findViewById(R.id.btn4d);
                btn_d5 = findViewById(R.id.btn5d);
                btn_d6 = findViewById(R.id.btn6d);
                btn_d7 = findViewById(R.id.btn7d);
                btn_d8 = findViewById(R.id.btn8d);
                btn_e1 = findViewById(R.id.btn1e);
                btn_e2 = findViewById(R.id.btn2e);
                btn_e3 = findViewById(R.id.btn3e);
                btn_e4 = findViewById(R.id.btn4e);
                btn_e5 = findViewById(R.id.btn5e);
                btn_e6 = findViewById(R.id.btn6e);
                btn_e7 = findViewById(R.id.btn7e);
                btn_e8 = findViewById(R.id.btn8e);
                btn_f1 = findViewById(R.id.btn1f);
                btn_f2 = findViewById(R.id.btn2f);
                btn_f3 = findViewById(R.id.btn3f);
                btn_f4 = findViewById(R.id.btn4f);
                btn_f5 = findViewById(R.id.btn5f);
                btn_f6 = findViewById(R.id.btn6f);
                btn_f7 = findViewById(R.id.btn7f);
                btn_f8 = findViewById(R.id.btn8f);
                btn_g1 = findViewById(R.id.btn1g);
                btn_g2 = findViewById(R.id.btn2g);
                btn_g3 = findViewById(R.id.btn3g);
                btn_g4 = findViewById(R.id.btn4g);
                btn_g5 = findViewById(R.id.btn5g);
                btn_g6 = findViewById(R.id.btn6g);
                btn_g7 = findViewById(R.id.btn7g);
                btn_g8 = findViewById(R.id.btn8g);
                btn_h1 = findViewById(R.id.btn1h);
                btn_h2 = findViewById(R.id.btn2h);
                btn_h3 = findViewById(R.id.btn3h);
                btn_h4 = findViewById(R.id.btn4h);
                btn_h5 = findViewById(R.id.btn5h);
                btn_h6 = findViewById(R.id.btn6h);
                btn_h7 = findViewById(R.id.btn7h);
                btn_h8 = findViewById(R.id.btn8h);
                txtTurn = findViewById(R.id.txtTurn);

                txtTurn.setText("White's turn");

                //create a new chess game
                chess.Chess game = new chess.Chess();






















            }
        });

        gamesPlayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.saved_games);
            }
        });
    }
    int presscounter =0;
    @Override
    public void onBackPressed() {
        presscounter++;
        if(presscounter==2)
            super.onBackPressed();
    }
}