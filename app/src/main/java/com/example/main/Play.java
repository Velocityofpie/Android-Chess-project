package com.example.main;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Play extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_a1, btn_b1, btn_c1, btn_d1, btn_e1, btn_f1, btn_g1, btn_h1,
            btn_a2, btn_b2, btn_c2, btn_d2, btn_e2, btn_f2, btn_g2, btn_h2,
            btn_a3, btn_b3, btn_c3, btn_d3, btn_e3, btn_f3, btn_g3, btn_h3,
            btn_a4, btn_b4, btn_c4, btn_d4, btn_e4, btn_f4, btn_g4, btn_h4,
            btn_a5, btn_b5, btn_c5, btn_d5, btn_e5, btn_f5, btn_g5, btn_h5,
            btn_a6, btn_b6, btn_c6, btn_d6, btn_e6, btn_f6, btn_g6, btn_h6,
            btn_a7, btn_b7, btn_c7, btn_d7, btn_e7, btn_f7, btn_g7, btn_h7,
            btn_a8, btn_b8, btn_c8, btn_d8, btn_e8, btn_f8, btn_g8, btn_h8;

    TextView txtTurn;

    String input = "";
    String output = "";
    ImageButton initialPiece;
    boolean gameStillRunning = true;
    //create a new chess game
    chess.Chess game = new chess.Chess();

    public void start() {

        setContentView(R.layout.play_chess);
        txtTurn = findViewById(R.id.txtTurn);
        txtTurn.setText(R.string.whiteTurn);



        ImageButton[][] imageButtons = {
                {btn_a1, btn_b1, btn_c1, btn_d1, btn_e1, btn_f1, btn_g1, btn_h1},
                {btn_a2, btn_b2, btn_c2, btn_d2, btn_e2, btn_f2, btn_g2, btn_h2},
                {btn_a3, btn_b3, btn_c3, btn_d3, btn_e3, btn_f3, btn_g3, btn_h3},
                {btn_a4, btn_b4, btn_c4, btn_d4, btn_e4, btn_f4, btn_g4, btn_h4},
                {btn_a5, btn_b5, btn_c5, btn_d5, btn_e5, btn_f5, btn_g5, btn_h5},
                {btn_a6, btn_b6, btn_c6, btn_d6, btn_e6, btn_f6, btn_g6, btn_h6},
                {btn_a7, btn_b7, btn_c7, btn_d7, btn_e7, btn_f7, btn_g7, btn_h7},
                {btn_a8, btn_b8, btn_c8, btn_d8, btn_e8, btn_f8, btn_g8, btn_h8}
        };

        for (int i = 0; i < imageButtons.length; i++) {
            for (int j = 0; j < imageButtons[0].length; j++) {
                ImageButton ib = imageButtons[i][j];
                ib.setOnClickListener(this);

            }
        }

    }


    @Override
    public void onClick(View v) {
            System.out.println(btn_a3.getContentDescription());
            input = (String) btn_a3.getContentDescription();
            if (output.equals("")) {
                output += input;
            } else if (output.length() == 2) {
                output += " " + input;
                System.out.println(output);
                boolean moved = game.movePiece(output);
                if (moved) {
                    output = "";
                    System.out.println("it moved to a3");
                    btn_a3.setImageResource(R.drawable.wp);

                }
            }
    }
}
