package chess;


import pieces.*;

import java.util.Scanner;

/**
 * main method for running the chess game
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */
public class Chess {

    public Board newboard;
    public enum Turn { WHITE, BLACK };
    public Turn turn;


    boolean draw=false, drawWasOffered=false;
    boolean GameisRunning=true;
    boolean enPassantFormation = false;
    boolean underCheckWhite = false;
    boolean underCheckBlack = false;

    /**
     * makes a new board to be created to start the game
     */
    public Chess() {
        newboard = new Board();
        turn = Turn.WHITE;
    }


    public boolean movePiece(String input) {
        //try {
        if (turn == Turn.WHITE) {
            System.out.print("White's move: ");
        }
        //Black's turn
        else {
            System.out.print("Black's move: ");
        }


        if (input.equals("resign")) {
            GameisRunning = false;
            if (turn == Turn.WHITE) {
                System.out.print("Black wins");
                return true;
            } else {
                System.out.print("White wins");
                return true;
            }

        }

        String[] fromTo = input.split(" ");
        //draw accepted
        if (input.equals("draw") && drawWasOffered){
            //System.out.println("test");
            draw = true;
            endGame(turn, draw);
        }
        else {
            draw=false;
        }



        if (input.length() == 11 && input.substring(6, 11).equals("draw?")){
            drawWasOffered= true;
        }
        else{
            drawWasOffered = false;
        }

        if (input.equals("ai")) {
            //for white piece
            for (int i=0; i<8; i++) {
                for (int j=0; j<8; j++) {
                    //loop until a white piece is found
                    if (newboard.square[i][j] != null) {
                        if (newboard.square[i][j].player.equals("w")) {
                            Piece p = newboard.square[i][j].piece;

                            if (p instanceof Pawn) {
                                //try moving forward
                                try {
                                    if (((Pawn) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j], newboard, turn, j+1, 8-i, j+1, 8-i+1, false)) {
                                        newboard.square[i-1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving diagonally left
                                try {
                                    if (((Pawn) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j-1], newboard, turn, j+1, 8-i, j, 8-i+1, false)) {
                                        newboard.square[i-1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving diagonally right
                                try {
                                    if (((Pawn) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i+1, false)) {
                                        newboard.square[i-1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                            } else if (p instanceof Rook) {
                                //try moving one space up
                                try {
                                     if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j], newboard, turn, j+1, 8-i, j+1, 8-i+1, false)) {
                                         newboard.square[i-1][j] = newboard.square[i][j];
                                         newboard.square[i][j] = null;
                                         turn = Turn.BLACK;
                                         return true;
                                     }
                                } catch (Exception e) {}

                                //try moving one space down
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j], newboard, turn, j+1, 8-i, j+1, 8-i-1, false)) {
                                        newboard.square[i+1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving left
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i][j-1], newboard, turn, j+1, 8-i, j, 8-i, false)) {
                                        newboard.square[i][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving right
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i, false)) {
                                        newboard.square[i][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                            } else if (p instanceof Bishop) {
                                //try moving up right
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i+1, false)) {
                                        newboard.square[i-1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving up left
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j-1], newboard, turn, j+1, 8-i, j, 8-i+1, false)) {
                                        newboard.square[i-1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down left
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j-1], newboard, turn, j+1, 8-i, j, 8-i-1, false)) {
                                        newboard.square[i+1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down right
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i-1, false)) {
                                        newboard.square[i+1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                            } else if (p instanceof Queen) {
                                //try moving one space up
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j], newboard, turn, j+1, 8-i, j+1, 8-i+1, false)) {
                                        newboard.square[i-1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving one space down
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j], newboard, turn, j+1, 8-i, j+1, 8-i-1, false)) {
                                        newboard.square[i+1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving left
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i][j-1], newboard, turn, j+1, 8-i, j, 8-i, false)) {
                                        newboard.square[i][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving right
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i, false)) {
                                        newboard.square[i][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving up right
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i+1, false)) {
                                        newboard.square[i-1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving up left
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j-1], newboard, turn, j+1, 8-i, j, 8-i+1, false)) {
                                        newboard.square[i-1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down left
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j-1], newboard, turn, j+1, 8-i, j, 8-i-1, false)) {
                                        newboard.square[i+1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down right
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i-1, false)) {
                                        newboard.square[i+1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.BLACK;
                                        return true;
                                    }
                                } catch (Exception e) {}
                            }


                        } else if (newboard.square[i][j].player.equals("b")) {
                            Piece p = newboard.square[i][j].piece;

                            if (p instanceof Pawn) {
                                //try moving forward
                                try {
                                    if (((Pawn) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j], newboard, turn, j+1, 8-i, j+1, 8-i-1, false)) {
                                        newboard.square[i+1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving diagonally left
                                try {
                                    if (((Pawn) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j-1], newboard, turn, j+1, 8-i, j, 8-i-1, false)) {
                                        newboard.square[i+1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving diagonally right
                                try {
                                    if (((Pawn) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i-1, false)) {
                                        newboard.square[i+1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                            } else if (p instanceof Rook) {
                                //try moving one space up
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j], newboard, turn, j+1, 8-i, j+1, 8-i+1, false)) {
                                        newboard.square[i-1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving one space down
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j], newboard, turn, j+1, 8-i, j+1, 8-i-1, false)) {
                                        newboard.square[i+1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving left
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i][j-1], newboard, turn, j+1, 8-i, j, 8-i, false)) {
                                        newboard.square[i][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving right
                                try {
                                    if (((Rook) p).isMoveValid(newboard.square[i][j], newboard.square[i][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i, false)) {
                                        newboard.square[i][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                            } else if (p instanceof Bishop) {
                                //try moving up right
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i+1, false)) {
                                        newboard.square[i-1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving up left
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j-1], newboard, turn, j+1, 8-i, j, 8-i+1, false)) {
                                        newboard.square[i-1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down left
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j-1], newboard, turn, j+1, 8-i, j, 8-i-1, false)) {
                                        newboard.square[i+1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down right
                                try {
                                    if (((Bishop) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i-1, false)) {
                                        newboard.square[i+1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                            } else if (p instanceof Queen) {
                                //try moving one space up
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j], newboard, turn, j+1, 8-i, j+1, 8-i+1, false)) {
                                        newboard.square[i-1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving one space down
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j], newboard, turn, j+1, 8-i, j+1, 8-i-1, false)) {
                                        newboard.square[i+1][j] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving left
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i][j-1], newboard, turn, j+1, 8-i, j, 8-i, false)) {
                                        newboard.square[i][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving right
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i, false)) {
                                        newboard.square[i][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving up right
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i+1, false)) {
                                        newboard.square[i-1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving up left
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i-1][j-1], newboard, turn, j+1, 8-i, j, 8-i+1, false)) {
                                        newboard.square[i-1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down left
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j-1], newboard, turn, j+1, 8-i, j, 8-i-1, false)) {
                                        newboard.square[i+1][j-1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}

                                //try moving down right
                                try {
                                    if (((Queen) p).isMoveValid(newboard.square[i][j], newboard.square[i+1][j+1], newboard, turn, j+1, 8-i, j+1+1, 8-i-1, false)) {
                                        newboard.square[i+1][j+1] = newboard.square[i][j];
                                        newboard.square[i][j] = null;
                                        turn = Turn.WHITE;
                                        return true;
                                    }
                                } catch (Exception e) {}
                            }
                        }
                    }
                }
            }
        }

        int[] arr = findTheKings(newboard);
        int wKrow = arr[0]; int wKcol = arr[1]; int bKrow = arr[2]; int bKcol = arr[3];

        char ch1 = fromTo[0].charAt(0);
        char ch2 = fromTo[0].charAt(1);
        int x1 = ch1 - 96; //file of chosenPiece (i.e. a=1, b=2,...)
        int y1 = ch2 - 48; //rank of chosenPiece

        char ch3 = fromTo[1].charAt(0);
        char ch4 = fromTo[1].charAt(1);
        int x2 = ch3 - 96; //file of desiredLocation (i.e. a=1, b=2,...)
        int y2 = ch4 - 48; //rank of desiredLocation

        Square chosenPiece = newboard.square[8 - y1][x1 - 1];
        Square desiredLocation = newboard.square[8 - y2][x2 - 1];

        if (chosenPiece == null) {
            System.out.println("Illegal move, try again");
            return false;
        } else if (turn == Turn.WHITE && chosenPiece.player.equals("b")) {
            System.out.println("Illegal move, try again");
            return false;
        } else if (turn == Turn.BLACK && chosenPiece.player.equals("w")) {
            System.out.println("Illegal move, try again");
            return false;
        } else if (fromTo.length == 3) {
            char p = fromTo[2].charAt(0);
            if (!(p == 'R' || p == 'N' || p == 'B' || p == 'Q' || (input.length() == 11 && input.substring(6, 11).equals("draw?")))) {
                System.out.println("Illegal move, try again");
                return false;
            }
        }





        //get the selected piece. check if the move is valid
        boolean isMoveValid = false;
        if (chosenPiece.piece instanceof Pawn) {
            Pawn p = (Pawn) chosenPiece.piece;
            isMoveValid = p.isMoveValid(chosenPiece, desiredLocation, newboard, turn, x1, y1, x2, y2, enPassantFormation);


        } else if (chosenPiece.piece instanceof Knight) {
            Knight n = (Knight) chosenPiece.piece;
            isMoveValid = n.isMoveValid(chosenPiece, desiredLocation, newboard, turn, x1, y1, x2, y2, enPassantFormation);

        } else if (chosenPiece.piece instanceof Rook) {
            Rook r = (Rook) chosenPiece.piece;
            isMoveValid = r.isMoveValid(chosenPiece, desiredLocation, newboard, turn, x1, y1, x2, y2, enPassantFormation);

        } else if (chosenPiece.piece instanceof Bishop) {
            Bishop b = (Bishop) chosenPiece.piece;
            isMoveValid = b.isMoveValid(chosenPiece, desiredLocation, newboard, turn, x1, y1, x2, y2, enPassantFormation);

        } else if (chosenPiece.piece instanceof Queen) {
            Queen q = (Queen) chosenPiece.piece;
            isMoveValid = q.isMoveValid(chosenPiece, desiredLocation, newboard, turn, x1, y1, x2, y2, enPassantFormation);

        } else {
            King k = (King) chosenPiece.piece;
            isMoveValid = k.isMoveValid(chosenPiece, desiredLocation, newboard, turn, x1, y1, x2, y2, enPassantFormation);



        }

        if (isMoveValid) {
            newboard.square[8 - y2][x2 - 1] = chosenPiece;
            newboard.square[8 - y1][x1 - 1] = null;



            //check if pawn must be promoted
            if (turn == Turn.WHITE && chosenPiece.piece instanceof Pawn && y2==8) {
                //white pawn is in top row
                if (fromTo.length == 3) {
                    char promote = fromTo[2].charAt(0);
                    if (promote == 'R') {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Rook(), "w");
                    } else if (promote == 'N') {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Knight(), "w");
                    } else if (promote == 'B') {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Bishop(), "w");
                    } else {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Queen(), "w");
                    }
                } else {
                    newboard.square[8 - y2][x2 - 1] = null;
                    newboard.square[8 - y2][x2 - 1] = new Square(new Queen(), "w");
                }
            } else if (turn == Turn.BLACK && chosenPiece.piece instanceof Pawn && y2 == 1) {
                //black pawn is in bottom row
                if (fromTo.length == 3) {
                    char promote = fromTo[2].charAt(0);
                    if (promote == 'R') {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Rook(), "b");
                    } else if (promote == 'N') {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Knight(), "b");
                    } else if (promote == 'B') {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Bishop(), "b");
                    } else {
                        newboard.square[8 - y2][x2 - 1] = null;
                        newboard.square[8 - y2][x2 - 1] = new Square(new Queen(), "b");
                    }
                } else {
                    newboard.square[8 - y2][x2 - 1] = null;
                    newboard.square[8 - y2][x2 - 1] = new Square(new Queen(), "b");
                }
            }

            if (chosenPiece.piece instanceof King && Math.abs(x1-x2) == 2) {
                //castling, need to move the rook
                if (turn == Turn.WHITE) {
                    if (x1-x2 < 0) {
                        //moving right
                        Square rookSq = newboard.square[7][7];
                        newboard.square[7][7] = null;
                        newboard.square[7][5] = rookSq;
                    } else {
                        //moving left
                        Square rookSq = newboard.square[7][0];
                        newboard.square[7][0] = null;
                        newboard.square[7][3] = rookSq;
                    }
                } else { //black is castling
                    if (x1-x2 < 0) {
                        //moving right
                        Square rookSq = newboard.square[0][7];
                        newboard.square[0][7] = null;
                        newboard.square[0][5] = rookSq;
                    } else {
                        //moving left
                        Square rookSq = newboard.square[0][0];
                        newboard.square[0][0] = null;
                        newboard.square[0][3] = rookSq;
                    }
                }
            }

            if (chosenPiece.piece instanceof Pawn) {
                if (turn == Turn.WHITE) {
                    //for white's turn, check if theres a black pawn below to see if en passant occurred
                    if (newboard.square[8 - y2 + 1][x2 - 1] != null) {
                        if (newboard.square[8 - y2 + 1][x2 - 1].player.equals("b") && newboard.square[8 - y2 + 1][x2 - 1].piece instanceof Pawn && enPassantFormation) {
                            //if true need to get rid of piece and make en passant false
                            newboard.square[8 - y2 + 1][x2 - 1] = null;
                        }
                    }
                } else {
                    // for black's turn, check if there's a white pawn above to see if en passant occurred
                    if (newboard.square[8 - y2 - 1][x2 - 1] != null) {
                        if (newboard.square[8 - y2 - 1][x2 - 1].player.equals("w") && newboard.square[8 - y2 - 1][x2 - 1].piece instanceof Pawn && enPassantFormation) {
                            //if true need to get rid of piece and make en passant false
                            newboard.square[8 - y2 - 1][x2 - 1] = null;
                        }
                    }
                }
            }
            enPassantFormation = false;

            if (Math.abs(y2 - y1) == 2 && chosenPiece.piece instanceof Pawn) {
                //check if pawn moved two spaces vertically then check if en passant formation is made by checking if there is an opposing pawn next to it
                if (turn == Turn.WHITE) {
                    if (x2 == 1) {
                        if (newboard.square[8 - y2][x2 - 1 + 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 + 1].player.equals("b") && newboard.square[8 - y2][x2 - 1 + 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                    } else if (x2 == 8) {
                        if (newboard.square[8 - y2][x2 - 1 - 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 - 1].player.equals("b") && newboard.square[8 - y2][x2 - 1 - 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                    } else {
                        if (newboard.square[8 - y2][x2 - 1 + 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 + 1].player.equals("b") && newboard.square[8 - y2][x2 - 1 + 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                        if (newboard.square[8 - y2][x2 - 1 - 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 - 1].player.equals("b") && newboard.square[8 - y2][x2 - 1 - 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                    }
                } else {
                    if (x2 == 1) {
                        if (newboard.square[8 - y2][x2 - 1 + 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 + 1].player.equals("w") && newboard.square[8 - y2][x2 - 1 + 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                    } else if (x2 == 8) {
                        if (newboard.square[8 - y2][x2 - 1 - 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 - 1].player.equals("w") && newboard.square[8 - y2][x2 - 1 - 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                    } else {
                        if (newboard.square[8 - y2][x2 - 1 + 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 + 1].player.equals("w") && newboard.square[8 - y2][x2 - 1 + 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                        if (newboard.square[8 - y2][x2 - 1 - 1] != null) {
                            if (newboard.square[8 - y2][x2 - 1 - 1].player.equals("w") && newboard.square[8 - y2][x2 - 1 - 1].piece instanceof Pawn) {
                                enPassantFormation = true;
                            }
                        }
                    }
                }
            }

        } else {
            System.out.println("Illegal move, try again");
            return false;
        }

        if (turn == Turn.BLACK) {
            boolean selfCheck = CheckingForcheck(newboard, bKrow, bKcol, Turn.WHITE);
            if (selfCheck) {
                newboard.square[8 - y1][x1 - 1] = chosenPiece;
                newboard.square[8 - y2][x2 - 1] = desiredLocation;
                System.out.println("Illegal move, try again");
                return false;
            }
        } else {
            boolean selfCheck = CheckingForcheck(newboard, wKrow, wKcol, Turn.BLACK);
            if (selfCheck) {
                newboard.square[8 - y1][x1 - 1] = chosenPiece;
                newboard.square[8 - y2][x2 - 1] = desiredLocation;
                System.out.println("Illegal move, try again");
                return false;
            }
        }


        newboard.printBoard();
        Board example = newboard; //copy of main board


        underCheckWhite = CheckingForcheck(example, wKrow, wKcol, turn);
        underCheckBlack = CheckingForcheck(example, bKrow, bKcol, turn);

        if (turn == Turn.BLACK && underCheckWhite) {
            King k = (King) newboard.square[wKrow][wKcol].piece;
            boolean canMoveOut = k.canMoveOut(newboard.square[wKrow][wKcol], newboard, turn, wKcol + 1, 8-wKrow, underCheckWhite);

            if (!canMoveOut) {
                boolean canBlock = blockCheck(newboard, turn);
                if (!canBlock) {
                    System.out.println("Checkmate");
                    endGame(turn, draw);
                } else {
                    System.out.println("Check3");
                }
            } else {
                System.out.println("Check4");
            }
        } else if (turn == Turn.WHITE && underCheckBlack) {
            King k = (King) newboard.square[bKrow][bKcol].piece;
            boolean canMoveOut = k.canMoveOut(newboard.square[bKrow][bKcol], newboard, turn, x1, x2, underCheckBlack);
            if (!canMoveOut) {
                boolean canBlock = blockCheck(newboard, turn);
                if (!canBlock) {
                    System.out.println("Checkmate");
                    endGame(turn, draw);
                } else {
                    System.out.println("Check1");
                }

            } else {
                System.out.println("Check2");
            }
        }

            /*} catch (Exception e) {
                System.err.println("Not a valid input, try again.");
                continue;
            } */




        if (turn == Turn.WHITE) {
            turn = Turn.BLACK;
        } else {
            turn = Turn.WHITE;
        }
        return true;
    }

    /**
     * method to see if a king is in check
     * @param b board
     * @param kRow row location
     * @param kCol col location
     * @param t turn
     * @return true or false
     */
    public static boolean CheckingForcheck(Board b, int kRow, int kCol, Turn t){
        String underAttack, attacker;
        if (t == Turn.BLACK) {
             underAttack = "w";  attacker = "b";
        } else {
             underAttack = "b";  attacker = "w";
        }

        //WHITE KING
        //check for a rook or queen in the vertical directions
        //up
        for (int r = kRow - 1; r >= 0; r--) {
            if (b.square[r][kCol] != null) {
                if (b.square[r][kCol].player.equals(underAttack)) {
                    break;
                }
                if (b.square[r][kCol].player.equals(attacker) && ((b.square[r][kCol].piece instanceof Rook) || (b.square[r][kCol].piece instanceof Queen))) {
                    return true;
                }
            }
        }
        //down
        for (int r = kRow + 1; r < 8; r++) {
            if (b.square[r][kCol] != null) {
                if (b.square[r][kCol].player.equals(underAttack)) {
                    break;
                }
                if (b.square[r][kCol].player.equals(attacker) && ((b.square[r][kCol].piece instanceof Rook) || (b.square[r][kCol].piece instanceof Queen))) {
                    return true;
                }
            }
        }

        //check for a rook or queen in horizontal directions
        //right
        for (int c = kCol + 1; c < 8; c++) {
            if (b.square[kRow][c] != null) {
                if (b.square[kRow][c].player.equals(underAttack)) {
                    break;
                }
                if (b.square[kRow][c].player.equals(attacker) && ((b.square[kRow][c].piece instanceof Rook) || (b.square[kRow][c].piece instanceof Queen))) {
                    return true;
                }
            }
        }
        //left
        for (int c = kCol - 1; c >= 0; c--) {
            if (b.square[kRow][c] != null) {
                if (b.square[kRow][c].player.equals(underAttack)) {
                    break;
                }
                if (b.square[kRow][c].player.equals(attacker) && ((b.square[kRow][c].piece instanceof Rook) || (b.square[kRow][c].piece instanceof Queen))) {
                    return true;
                }
            }
        }

        //check for a Queen or a bishop in the diagonal directions
        //up right
        for (int r = kRow-1, c = kCol+1; r >= 0 && c < 8; r--, c++) {
            if (b.square[kRow-1][kCol+1] != null) {
                if (b.square[kRow-1][kCol+1].player.equals(attacker) && b.square[kRow-1][kCol+1].piece instanceof Pawn) {
                    //check if there is a pawn that could take king
                    return true;
                }
            }
            if (b.square[r][c] != null) {
                if (b.square[r][c].player.equals(underAttack)) {
                    break;
                }
                if (b.square[r][c].player.equals(attacker) && ((b.square[r][c].piece instanceof Queen) || (b.square[r][c].piece instanceof Bishop))) {
                    return true;
                }
            }
        }
        //up left
        for (int r = kRow-1, c = kCol-1; r >= 0 && c >= 0; r--, c--) {
            if (b.square[kRow-1][kCol-1] != null) {
                if (b.square[kRow-1][kCol-1].player.equals(attacker) && b.square[kRow-1][kCol-1].piece instanceof Pawn) {
                    //check if there is a pawn that could take king
                    return true;
                }
            }

            if (b.square[r][c] != null) {
                if (b.square[r][c].player.equals(underAttack)) {
                    break;
                }
                if (b.square[r][c].player.equals(attacker) && ((b.square[r][c].piece instanceof Queen) || (b.square[r][c].piece instanceof Bishop))) {
                    return true;
                }
            }
        }
        //down left
        for (int r = kRow+1, c = kCol-1; r < 8 && c >= 0; r++, c--) {
            if (b.square[r][c] != null) {
                if (b.square[r][c].player.equals(underAttack)) {
                    break;
                }
                if (b.square[r][c].player.equals(attacker) && ((b.square[r][c].piece instanceof Queen) || (b.square[r][c].piece instanceof Bishop))) {
                    return true;
                }
            }
        }
        //down right
        for (int r = kRow+1, c = kCol+1; r < 8 && c < 8; r++, c++) {
            if (b.square[r][c] != null) {
                if (b.square[r][c].player.equals(underAttack)) {
                    break;
                }
                if (b.square[r][c].player.equals(attacker) && ((b.square[r][c].piece instanceof Queen) || (b.square[r][c].piece instanceof Bishop))) {
                    return true;
                }
            }
        }

        //check for a knight in 8 spots
        //up 1 right 2
        try {
            if (b.square[kRow - 1][kCol + 2].player.equals(attacker) && b.square[kRow - 1][kCol + 2].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //up 2 right 1
        try {
            if (b.square[kRow - 2][kCol + 1].player.equals(attacker) && b.square[kRow - 2][kCol + 1].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //up 1 left 2
        try {
            if (b.square[kRow - 1][kCol - 2].player.equals(attacker) && b.square[kRow - 1][kCol - 2].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //up 2 left 1
        try {
            if (b.square[kRow - 2][kCol - 1].player.equals(attacker) && b.square[kRow - 2][kCol - 1].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //down 1 right 2
        try {
            if (b.square[kRow + 1][kCol + 2].player.equals(attacker) && b.square[kRow + 1][kCol + 2].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //down 2 right 1
        try {
            if (b.square[kRow + 2][kCol + 1].player.equals(attacker) && b.square[kRow + 2][kCol + 1].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //down 1 left 2
        try {
            if (b.square[kRow + 1][kCol - 2].player.equals(attacker) && b.square[kRow + 1][kCol - 2].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }
        //down 2 left 1
        try {
            if (b.square[kRow + 2][kCol - 1].player.equals(attacker) && b.square[kRow + 2][kCol - 1].piece instanceof Knight) {
                return true;
            }
        } catch (Exception e) {

        }

        return  false;
    }

    /**
     * method to find location of kings on a board
     * @param b board
     * @return array with integers of row and col values for each king
     */
    public static int[] findTheKings(Board b) {
        int W_King_ROW = 0,W_King_COL = 0, B_King_ROW = 0,B_King_COL = 0;
        //find the kings
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                Square s = b.square[i][j];
                if (s != null) {
                    if((s.piece instanceof King) && s.player.equals("w")){
                        W_King_ROW = i;
                        W_King_COL = j;
                    }
                    else if((s.piece instanceof  King) && s.player.equals("b")){
                        B_King_ROW = i;
                        B_King_COL = j;
                    }
                }

            }
        }
        int[] coordinates = new int[4];
        coordinates[0] = W_King_ROW; coordinates[1] = W_King_COL; coordinates[2] = B_King_ROW; coordinates[3] = B_King_COL;
        return coordinates;
    }

    /**
     * method to print out the winner of the game
     * @param turn
     * @param draw
     */
    public static void endGame(Turn turn, boolean draw) {
        if (draw){
            System.out.println("Draw");
        }
        else if (turn == Turn.WHITE)  {
            System.out.println("White wins");
        }
        else {
            System.out.println("Black wins");
        }

        System.exit(0);
    }


    /**
     * method to determine if a checkmate occurs or not
     * @param b board
     * @param t turn
     * @return true or false
     */
    public boolean blockCheck(Board b, Turn t) {

        Board testBoard = b;

        //initialize who the attacker is and find the king that is under attack and get its location
        String attacker = ""; String underAttack = "";
        int krow = 0; int kcol = 0;
        int[] arr = findTheKings(b);
        if (t == Turn.WHITE) {
            attacker = "w";
            underAttack = "b";
            krow = arr[2];
            kcol = arr[3];
        } else {
            attacker = "b";
            underAttack = "w";
            krow = arr[0];
            kcol = arr[1];
        }

        //loop through the squares and skip any space that is null or is an attacking piece
        //check if by moving each piece you can get the board to not be in check anymore
        for (int i = 0; i < 8; i++) {
            for (int j=0; j <8; j++) {
                Square currSq = b.square[i][j];
                if (currSq != null && currSq.player.equals(underAttack)) {
                    //check if curr is a pawn
                    if (currSq.piece instanceof Pawn) {
                        Pawn currPiece = (Pawn) currSq.piece;
                        //try moving the pawn in all directions and see if board is still in check
                        try {
                            //move down one
                            if (currPiece.isMoveValid(currSq, b.square[i + 1][j], b, t, j + 1, 8 - i, j + 1, 8 - i - 1, false)) {
                                Square desiredSq = null;
                                if (b.square[i + 1][j] != null) {
                                    desiredSq = new Square(b.square[i + 1][j].piece, b.square[i + 1][j].player);
                                }

                                testBoard.square[i + 1][j] = currSq;
                                testBoard.square[i][j] = null;
                                boolean isCheck = CheckingForcheck(testBoard, krow, kcol, t);
                                //move pieces back
                                testBoard.square[i][j] = currSq;
                                testBoard.square[i + 1][j] = desiredSq;
                                if (!isCheck) {
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                        }

                        //move up one
                        try {
                            if (currPiece.isMoveValid(currSq, b.square[i - 1][j], b, t, j + 1, 8 - i, j + 1, 8 - i + 1, false)) {
                                System.out.println("up valid");
                                Square desiredSq = null;
                                if (b.square[i - 1][j] != null) {
                                    desiredSq = new Square(b.square[i - 1][j].piece, b.square[i - 1][j].player);
                                }
                                testBoard.square[i - 1][j] = currSq;
                                testBoard.square[i][j] = null;
                                boolean isCheck = CheckingForcheck(testBoard, krow, kcol, t);
                                //move pieces back
                                testBoard.square[i][j] = currSq;
                                testBoard.square[i - 1][j] = desiredSq;
                                if (!isCheck) {
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                        }

                        //move up left
                        try {
                            if (currPiece.isMoveValid(currSq, b.square[i - 1][j - 1], b, t, j + 1, 8 - i, j, 8 - i + 1, false)) {
                                Square desiredSq = null;
                                if (b.square[i - 1][j - 1] != null) {
                                    desiredSq = new Square(b.square[i - 1][j - 1].piece, b.square[i - 1][j - 1].player);
                                }
                                testBoard.square[i - 1][j - 1] = currSq;
                                testBoard.square[i][j] = null;
                                boolean isCheck = CheckingForcheck(testBoard, krow, kcol, t);
                                //move pieces back
                                testBoard.square[i][j] = currSq;
                                testBoard.square[i - 1][j - 1] = desiredSq;
                                if (!isCheck) {
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                        }

                        //move up right
                        try {
                            System.out.println("1");
                            System.out.println(currPiece.isMoveValid(currSq, b.square[i - 1][j + 1], b, t, j + 1, 8 - i, j + 1 + 1, 8 - i + 1, false));
                            if (currPiece.isMoveValid(currSq, b.square[i - 1][j + 1], b, t, j + 1, 8 - i, j + 1 + 1, 8 - i + 1, false)) {
                                System.out.println("2");
                                Square desiredSq = null;
                                if (b.square[i - 1][j + 1] != null) {
                                    desiredSq = new Square(b.square[i - 1][j + 1].piece, b.square[i - 1][j + 1].player);
                                }
                                testBoard.square[i - 1][j + 1] = currSq;
                                testBoard.square[i][j] = null;
                                boolean isCheck = CheckingForcheck(testBoard, krow, kcol, t);
                                //move pieces back
                                testBoard.square[i][j] = currSq;
                                testBoard.square[i - 1][j + 1] = desiredSq;
                                if (!isCheck) {
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                        }

                        //move down left
                        try {
                            if (currPiece.isMoveValid(currSq, b.square[i + 1][j - 1], b, t, j + 1, 8 - i, j + 1 - 1, 8 - i - 1, false)) {
                                Square desiredSq = null;
                                if (b.square[i + 1][j - 1] != null) {
                                    desiredSq = new Square(b.square[i + 1][j - 1].piece, b.square[i + 1][j - 1].player);
                                }
                                testBoard.square[i + 1][j - 1] = currSq;
                                testBoard.square[i][j] = null;
                                boolean isCheck = CheckingForcheck(testBoard, krow, kcol, t);
                                //move pieces back
                                testBoard.square[i][j] = currSq;
                                testBoard.square[i + 1][j - 1] = desiredSq;
                                if (!isCheck) {
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                        }

                        //move down right
                        try {
                            if (currPiece.isMoveValid(currSq, b.square[i + 1][j + 1], b, t, j + 1, 8 - i, j + 1 + 1, 8 - i - 1, false)) {
                                Square desiredSq = null;
                                if (b.square[i + 1][j + 1] != null) {
                                    desiredSq = new Square(b.square[i + 1][j + 1].piece, b.square[i + 1][j + 1].player);
                                }
                                testBoard.square[i + 1][j + 1] = currSq;
                                testBoard.square[i][j] = null;
                                boolean isCheck = CheckingForcheck(testBoard, krow, kcol, t);
                                //move pieces back
                                testBoard.square[i][j] = currSq;
                                testBoard.square[i + 1][j + 1] = desiredSq;
                                if (!isCheck) {
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                        }


                    }
                }
            }
        }

        /*
        int krow = 0; int kcol = 0;
        int[] arr = findTheKings(b);
        if (t == Turn.WHITE) {
            krow = arr[0];
            kcol = arr[1];
        } else {
            krow = arr[2];
            kcol = arr[3];
        }

        //for white, loop through board and see if piece can make undercheck false
        if (t == Turn.WHITE) {
            for (int i = 0, j = 0; i > 0 && j > 0; i++, j++) {
                if (b.square[i][j] != null) {
                    if (b.square[i][j].player.equals("w")) {
                        if (b.square[i][j].piece instanceof Pawn) {
                            Pawn p = (Pawn) b.square[i][j].piece;
                            try {
                                if (p.isMoveValid(b.square[i][j], b.square[i - 1][j], b, t, i, j, i - 1, j, false)) {
                                    newboard.square[i - 1][j] = b.square[i][j];
                                    newboard.square[i][j] = null;
                                    boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                    if (!ischeck) {
                                        return true;
                                    }
                                } else if (p.isMoveValid(b.square[i][j], b.square[i - 1][j + 1], b, t, i, j, i - 1, j + 1, false)) {
                                    newboard.square[i - 1][j + 1] = b.square[i][j];
                                    newboard.square[i][j] = null;
                                    boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                    if (!ischeck) {
                                        return true;
                                    }
                                } else if (p.isMoveValid(b.square[i][j], b.square[i - 1][j-1], b, t, i, j, i - 1, j-1, false)) {
                                    newboard.square[i - 1][j-1] = b.square[i][j];
                                    newboard.square[i][j] = null;
                                    boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                    if (!ischeck) {
                                        return true;
                                    }
                                }
                            } catch (Exception e){

                            }
                        } else if (b.square[i][j].piece instanceof Rook) {
                            Rook r= (Rook) b.square[i][j].piece;
                            //check blocking right
                            for (int c = j+1; c < 8; c++) {
                                try {
                                    if (r.isMoveValid(b.square[i][j], b.square[i][c], b, t, c, 8-i, c+1, 8-i, false)) {
                                        newboard.square[i][c] = b.square[i][j];
                                        newboard.square[i][j] = null;
                                        boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                        if (!ischeck) {
                                            return true;
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                            //check blocking left
                            for (int c = j-1; c >= 0; c--) {
                                try {
                                    if (r.isMoveValid(b.square[i][j], b.square[i][c], b, t, c, 8-i, c+1, 8-i, false)) {
                                        newboard.square[i][c] = b.square[i][j];
                                        newboard.square[i][j] = null;
                                        boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                        if (!ischeck) {
                                            return true;
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                            //check blocking down
                            for (int ro = i+1; ro < 8; ro++) {
                                try {
                                    if (r.isMoveValid(b.square[i][j], b.square[ro][j], b, t, j+1, 8-i, j+1, 8-ro, false)) {
                                        newboard.square[i][j] = b.square[i][j];
                                        newboard.square[i][j] = null;
                                        boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                        if (!ischeck) {
                                            return true;
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                            //check blocking up
                            for (int ro = i-1; ro >= 0; ro--) {
                                try {
                                    if (r.isMoveValid(b.square[i][j], b.square[ro][j], b, t, j+1, 8-i, j+1, 8-ro, false)) {
                                        newboard.square[ro][j] = b.square[i][j];
                                        newboard.square[i][j] = null;
                                        boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                        if (!ischeck) {
                                            return true;
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                        } else if(b.square[i][j].piece instanceof Bishop) {
                            Bishop bish = (Bishop) b.square[i][j].piece;

                            //up right
                            for (int r = i-1, c = j+1; r >= 0 && c < 8; r--, c++) {
                                try {
                                    if (bish.isMoveValid(b.square[i][j], b.square[r][c], b, t, j+1, 8-i, 8-c, r, false)) {
                                        newboard.square[r][c] = b.square[i][j];
                                        newboard.square[i][j] = null;
                                        boolean ischeck = CheckingForcheck(b, krow, kcol, t);
                                        if (!ischeck) {
                                            return true;
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                            //up left
                            for (int r = i-1, c = j-1; r >= 0 && c >= 0; r--, c--) {
                                try {
                                    if (bish.isMoveValid(b.square[i][j], b.square[r][c], b, t, j+1, 8-i, 8-c, r, false)) {
                                        newboard.square[r][c] = b.square[i][j];
                                        newboard.square[i][j] = null;
                                        boolean ischeck = CheckingForcheck(b, krow, kcol, Turn.BLACK);
                                        if (!ischeck) {
                                            return true;
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                        }
                    }
                }
            }
        }

         */

        return false;
    }

    public void setBoard(Board b) {
        this.newboard = b;
    }
}
