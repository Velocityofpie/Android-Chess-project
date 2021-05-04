/**
 * @author Joshua Hernandez
 * @author John Lavin
 */

package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import chess.Square;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

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

    Button btnAI;

    TextView txtTurn;

    String input = "";
    String output = "";
    String initialPiece;
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
                System.out.println("yahoo");
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

                btnAI = findViewById(R.id.btnAI);




                txtTurn = findViewById(R.id.txtTurn);
                txtTurn.setText(R.string.whiteTurn);

                //create a new chess game
                chess.Chess game = new chess.Chess();

                //create an array of the buttons
                ImageButton[][] imageButtons = {
                        {btn_a8, btn_b8, btn_c8, btn_d8, btn_e8, btn_f8, btn_g8, btn_h8},
                        {btn_a7, btn_b7, btn_c7, btn_d7, btn_e7, btn_f7, btn_g7, btn_h7},
                        {btn_a6, btn_b6, btn_c6, btn_d6, btn_e6, btn_f6, btn_g6, btn_h6},
                        {btn_a5, btn_b5, btn_c5, btn_d5, btn_e5, btn_f5, btn_g5, btn_h5},
                        {btn_a4, btn_b4, btn_c4, btn_d4, btn_e4, btn_f4, btn_g4, btn_h4},
                        {btn_a3, btn_b3, btn_c3, btn_d3, btn_e3, btn_f3, btn_g3, btn_h3},
                        {btn_a2, btn_b2, btn_c2, btn_d2, btn_e2, btn_f2, btn_g2, btn_h2},
                        {btn_a1, btn_b1, btn_c1, btn_d1, btn_e1, btn_f1, btn_g1, btn_h1}
                };

                ArrayList<ImageButton> buttonArrayList = new ArrayList<ImageButton>();

                for (int i = 0; i < imageButtons.length; i++) {
                    for (int j = 0; j < imageButtons[0].length; j++) {
                        buttonArrayList.add(imageButtons[i][j]);
                    }
                }


                btn_a1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a1.getContentDescription());
                        input = (String) btn_a1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a2.getContentDescription());
                        input = (String) btn_a2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a3.setOnClickListener(new View.OnClickListener() {
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
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a4.getContentDescription());
                        input = (String) btn_a4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a5.getContentDescription());
                        input = (String) btn_a5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a6.getContentDescription());
                        input = (String) btn_a6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a7.getContentDescription());
                        input = (String) btn_a7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_a8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_a8.getContentDescription());
                        input = (String) btn_a8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b1.getContentDescription());
                        input = (String) btn_b1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b2.getContentDescription());
                        input = (String) btn_b2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b3.getContentDescription());
                        input = (String) btn_b3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b4.getContentDescription());
                        input = (String) btn_b4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b5.getContentDescription());
                        input = (String) btn_b5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b6.getContentDescription());
                        input = (String) btn_b6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b7.getContentDescription());
                        input = (String) btn_b7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_b8.getContentDescription());
                        input = (String) btn_b8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c1.getContentDescription());
                        input = (String) btn_c1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c2.getContentDescription());
                        input = (String) btn_c2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c3.getContentDescription());
                        input = (String) btn_c3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c4.getContentDescription());
                        input = (String) btn_c4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c5.getContentDescription());
                        input = (String) btn_c5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c6.getContentDescription());
                        input = (String) btn_c6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c7.getContentDescription());
                        input = (String) btn_c7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_c8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_c8.getContentDescription());
                        input = (String) btn_c8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d1.getContentDescription());
                        input = (String) btn_d1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d2.getContentDescription());
                        input = (String) btn_d2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d3.getContentDescription());
                        input = (String) btn_d3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d4.getContentDescription());
                        input = (String) btn_d4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d5.getContentDescription());
                        input = (String) btn_d5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d5.getContentDescription());
                        input = (String) btn_d5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d6.getContentDescription());
                        input = (String) btn_d6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d7.getContentDescription());
                        input = (String) btn_d7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_d8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_d8.getContentDescription());
                        input = (String) btn_d8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e1.getContentDescription());
                        input = (String) btn_e1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e2.getContentDescription());
                        input = (String) btn_e2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e3.getContentDescription());
                        input = (String) btn_e3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e4.getContentDescription());
                        input = (String) btn_e4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e5.getContentDescription());
                        input = (String) btn_e5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e6.getContentDescription());
                        input = (String) btn_e6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e7.getContentDescription());
                        input = (String) btn_e7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_e8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_e8.getContentDescription());
                        input = (String) btn_e8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f1.getContentDescription());
                        input = (String) btn_f1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f2.getContentDescription());
                        input = (String) btn_f2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f3.getContentDescription());
                        input = (String) btn_f3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f4.getContentDescription());
                        input = (String) btn_f4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f5.getContentDescription());
                        input = (String) btn_f5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f6.getContentDescription());
                        input = (String) btn_f6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f7.getContentDescription());
                        input = (String) btn_f7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_f8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_f8.getContentDescription());
                        input = (String) btn_f8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g1.getContentDescription());
                        input = (String) btn_g1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g2.getContentDescription());
                        input = (String) btn_g2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g3.getContentDescription());
                        input = (String) btn_g3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g4.getContentDescription());
                        input = (String) btn_g4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g5.getContentDescription());
                        input = (String) btn_g5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g6.getContentDescription());
                        input = (String) btn_g6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g7.getContentDescription());
                        input = (String) btn_g7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_g8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_g8.getContentDescription());
                        input = (String) btn_g8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h1.getContentDescription());
                        input = (String) btn_h1.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h2.getContentDescription());
                        input = (String) btn_h2.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h3.getContentDescription());
                        input = (String) btn_h3.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h4.getContentDescription());
                        input = (String) btn_h4.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h5.getContentDescription());
                        input = (String) btn_h5.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h6.getContentDescription());
                        input = (String) btn_h6.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h7.getContentDescription());
                        input = (String) btn_h7.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });

                btn_h8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(btn_h8.getContentDescription());
                        input = (String) btn_h8.getContentDescription();
                        if (output.equals("")) {
                            output += input;
                        } else if (output.length() == 2) {
                            output += " " + input;
                            System.out.println(output);
                            boolean moved = game.movePiece(output);
                            if (moved) {
                                printButtons(imageButtons, game.newboard);
                                output = "";
                            }
                        }
                        if (game.turn == chess.Chess.Turn.BLACK) {
                            txtTurn.setText(R.string.blackTurn);
                        } else {
                            txtTurn.setText(R.string.whiteTurn);
                        }
                    }
                });


                btnAI.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        output = "";
                        boolean moved = game.movePiece("ai");
                        if (moved) {
                            printButtons(imageButtons, game.newboard);
                        }
                    }
                });





            }
        });

        gamesPlayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.saved_games);
            }
        });
    }
//    int presscounter =0;
//    @Override
//    public void onBackPressed() {
//        presscounter++;
//        if(presscounter==2)
//            super.onBackPressed();
//    }
    private ImageButton getImageButton(ImageButton[][] buttons, String target) {

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if (target.equals(buttons[i][j].getContentDescription())) {
                    return buttons[i][j];
                }
            }
        }
        return buttons[0][0];
    }

    public void printButtons(ImageButton[][] arr, chess.Board board) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ImageButton currButton = arr[i][j];
                if (board.square[i][j] != null) {
                    Piece p = board.square[i][j].piece;
                    String player = board.square[i][j].player;

                    if (player.equals("w")) {
                        if (p instanceof Pawn) {
                            currButton.setImageResource(R.drawable.wp);
                        } else if (p instanceof Knight) {
                            currButton.setImageResource(R.drawable.wn);
                        } else if (p instanceof Rook) {
                            currButton.setImageResource(R.drawable.wr);
                        } else if (p instanceof Bishop) {
                            currButton.setImageResource(R.drawable.wb);
                        } else if (p instanceof Queen) {
                            currButton.setImageResource(R.drawable.wq);
                        } else if (p instanceof King) {
                            currButton.setImageResource(R.drawable.wk);
                        }
                    } else if (player.equals("b")) {
                        if (p instanceof Pawn) {
                            currButton.setImageResource(R.drawable.bp);
                        } else if (p instanceof Knight) {
                            currButton.setImageResource(R.drawable.bn);
                        } else if (p instanceof Rook) {
                            currButton.setImageResource(R.drawable.br);
                        } else if (p instanceof Bishop) {
                            currButton.setImageResource(R.drawable.bb);
                        } else if (p instanceof Queen) {
                            currButton.setImageResource(R.drawable.bq);
                        } else if (p instanceof King) {
                            currButton.setImageResource(R.drawable.bk);
                        }
                    }
                } else {
                    currButton.setImageResource(R.drawable.nullimg);
                }
            }
        }
    }
}