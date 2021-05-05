package com.example.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.main.Chess;

import java.io.IOException;
import java.util.ArrayList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class watch_game {
//
//    ArrayList<Match> matches;
//    Button playerVplayer, gamesPlayed, btnDraw;
//    ImageButton btn_a1, btn_b1, btn_c1, btn_d1, btn_e1, btn_f1, btn_g1, btn_h1,
//            btn_a2, btn_b2, btn_c2, btn_d2, btn_e2, btn_f2, btn_g2, btn_h2,
//            btn_a3, btn_b3, btn_c3, btn_d3, btn_e3, btn_f3, btn_g3, btn_h3,
//            btn_a4, btn_b4, btn_c4, btn_d4, btn_e4, btn_f4, btn_g4, btn_h4,
//            btn_a5, btn_b5, btn_c5, btn_d5, btn_e5, btn_f5, btn_g5, btn_h5,
//            btn_a6, btn_b6, btn_c6, btn_d6, btn_e6, btn_f6, btn_g6, btn_h6,
//            btn_a7, btn_b7, btn_c7, btn_d7, btn_e7, btn_f7, btn_g7, btn_h7,
//            btn_a8, btn_b8, btn_c8, btn_d8, btn_e8, btn_f8, btn_g8, btn_h8;
//    TextView txtTurn;
//
//    private Button btnNext;
//    private Button btnBack;
//    ArrayList<chess.Board> moves = new ArrayList<chess.Board>();
//    boolean gameStillRunning = true;
//    @Override
//    protected void onCreate (Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.watch_game);
//
//        try {
//            matches = readMatches();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        playerVplayer = findViewById(R.id.playerVplayer);
//        gamesPlayed = findViewById(R.id.gamesPlayed);
//
//
//    public void onclick(View v){
//        if(btnNext.getText().equals("Exit to Match Menu")){
//            finish();
//        }
//        Button clicked = (Button) v;
//        if(clicked != btnNext){
//            return;
//        }
//        printButtons(wMatch.getNextMove());
//        btnBack.setEnabled(true);
//        if(wMatch.getCurrentMove() + 1 == wMatch.getTotalNumberOfMoves()){
//            txtCount.setText(wMatch.getEndMessage());
//            btnNext.setText("Exit to Match Menu");
//        }
//    }
//    public void onclick(View v){
//        Button clicked = (Button) v;
//        if(clicked != btnBack){
//            return;
//        }
//        printButtons(wMatch.getPrevMove());
//        btnBack.setEnabled(wMatch.getCurrentMove() != 0);
//        btnNext.setEnabled(true);
//        btnNext.setText("Next");
//    }
//
//    public void printButtons (ImageButton[][]arr, chess.Board board){
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                ImageButton currButton = arr[i][j];
//                if (board.square[i][j] != null) {
//                    Piece p = board.square[i][j].piece;
//                    String player = board.square[i][j].player;
//
//                    if (player.equals("w")) {
//                        if (p instanceof Pawn) {
//                            currButton.setImageResource(R.drawable.wp);
//                        } else if (p instanceof Knight) {
//                            currButton.setImageResource(R.drawable.wn);
//                        } else if (p instanceof Rook) {
//                            currButton.setImageResource(R.drawable.wr);
//                        } else if (p instanceof Bishop) {
//                            currButton.setImageResource(R.drawable.wb);
//                        } else if (p instanceof Queen) {
//                            currButton.setImageResource(R.drawable.wq);
//                        } else if (p instanceof King) {
//                            currButton.setImageResource(R.drawable.wk);
//                        }
//                    } else if (player.equals("b")) {
//                        if (p instanceof Pawn) {
//                            currButton.setImageResource(R.drawable.bp);
//                        } else if (p instanceof Knight) {
//                            currButton.setImageResource(R.drawable.bn);
//                        } else if (p instanceof Rook) {
//                            currButton.setImageResource(R.drawable.br);
//                        } else if (p instanceof Bishop) {
//                            currButton.setImageResource(R.drawable.bb);
//                        } else if (p instanceof Queen) {
//                            currButton.setImageResource(R.drawable.bq);
//                        } else if (p instanceof King) {
//                            currButton.setImageResource(R.drawable.bk);
//                        }
//                    }
//                } else {
//                    currButton.setImageResource(R.drawable.nullimg);
//                }
//            }
//        }
//    }

}



