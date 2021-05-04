package chess;
import java.util.ArrayList;
import java.util.List;


import pieces.*;
/**
 * builds the 8 by 8 board for the chess game 
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */
public class Board {

    /**
     * Create a 2d array of Squares to store pieces
     */
    public Square[][] square;

    /**
     * adds the pieces on to the board for it to start
     */

    public Board() {

        //8x8 board
        square = new Square[8][8];

//        public Map<Location, Square> getLocationSquareMap() {
//            return locationSquareMap;
//        }
//
//        public List<AbstractPiece> getLightPieces() {
//            return lightPieces;
//        }
//
//        public List<AbstractPiece> getDarkPieces() {
//            return darkPieces;
//        }

        //Blacks pieces
        square[0][0] = new Square(new Rook(), "b");
        square[0][1] = new Square(new Knight(), "b");
        square[0][2] = new Square(new Bishop(), "b");
        square[0][3] = new Square(new Queen(), "b");
        square[0][4] = new Square(new King(), "b");
        square[0][5] = new Square(new Bishop(), "b");
        square[0][6] = new Square(new Knight(), "b");
        square[0][7] = new Square(new Rook(), "b");

        for(int i = 0; i < 8; i++) {
            square[1][i] = new Square(new Pawn(), "b");
        }

        //Whites pieces
        square[7][0] = new Square(new Rook(), "w");
        square[7][1] = new Square(new Knight(), "w");
        square[7][2] = new Square(new Bishop(), "w");
        square[7][3] = new Square(new Queen(), "w");
        square[7][4] = new Square(new King(), "w");
        square[7][5] = new Square(new Bishop(), "w");
        square[7][6] = new Square(new Knight(), "w");
        square[7][7] = new Square(new Rook(), "w");

        for(int i = 0; i < 8; i++) {
            square[6][i] = new Square(new Pawn(), "w");
        }


    }

    public Board(Board sample) {
        //this constructor creates a copy of a sample board
        square = new Square[8][8];

        //loop through the sample board and copy new pieces
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {

                Square currSq = sample.square[i][j];
                if (currSq == null) {continue;}
                if (currSq.player.equals("w") && currSq.piece instanceof Pawn) {
                    this.square[i][j] = new Square(new Pawn(), "w");
                } else if (currSq.player.equals("w") && currSq.piece instanceof Rook) {
                    this.square[i][j] = new Square(new Rook(), "w");
                } else if (currSq.player.equals("w") && currSq.piece instanceof Bishop) {
                    this.square[i][j] = new Square(new Bishop(), "w");
                } else if (currSq.player.equals("w") && currSq.piece instanceof Knight) {
                    this.square[i][j] = new Square(new Knight(), "w");
                } else if (currSq.player.equals("w") && currSq.piece instanceof Queen) {
                    this.square[i][j] = new Square(new Queen(), "w");
                } else if (currSq.player.equals("w") && currSq.piece instanceof King) {
                    this.square[i][j] = new Square(new King(), "w");


                } else if (currSq.player.equals("b") && currSq.piece instanceof Pawn) {
                    this.square[i][j] = new Square(new Pawn(), "b");
                } else if (currSq.player.equals("b") && currSq.piece instanceof Rook) {
                    this.square[i][j] = new Square(new Rook(), "b");
                } else if (currSq.player.equals("b") && currSq.piece instanceof Bishop) {
                    this.square[i][j] = new Square(new Bishop(), "b");
                } else if (currSq.player.equals("b") && currSq.piece instanceof Knight) {
                    this.square[i][j] = new Square(new Knight(), "b");
                } else if (currSq.player.equals("b") && currSq.piece instanceof Queen) {
                    this.square[i][j] = new Square(new Queen(), "b");
                } else if (currSq.player.equals("b") && currSq.piece instanceof King) {
                    this.square[i][j] = new Square(new King(), "b");
                }


            }
        }


    }

    /**
     * Prints out the formated chess board
     */
    public void printBoard() {
        /**
         * Printout all the ## for every other square
         */
        boolean placer = false;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(square[i][j] == null && placer)
                    System.out.print("## ");
                else if(square[i][j] == null)
                    System.out.print("   ");
                else
                    System.out.print(square[i][j] + " ");

                placer = !placer;
            }
            System.out.println(8 - i);
            placer = !placer;
        }
        System.out.println(" a  b  c  d  e  f  g  h\n");
    }



}
