package pieces;
import chess.*;

/**
 * Pawn a subclass of Piece
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */

public class Pawn extends Piece {
    // declares that this is its first time moving
    public boolean isFirstMove ;
    private char promotion;


    //public boolean EnPassant;

    /**
     * Pawn constructor
     */
    public Pawn() {
        isFirstMove = true;
        //twomovesup = false;
    }

    /**
     * method to see if a move is valid for a pawn
     * @param startSq
     * @param endSq
     * @param b
     * @param turn
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param enPassantFormation
     * @return true or false
     */
    public boolean isMoveValid (Square startSq, Square endSq, Board b, Chess.Turn turn, int x1, int y1, int x2, int y2, boolean enPassantFormation) {

        if (startSq == null) {;return false; }
        if (turn == Chess.Turn.WHITE && startSq.player.equals("b")) {
            return false;
        } else if (turn == Chess.Turn.BLACK && startSq.player.equals("w")) {
            return false;
        }

        if (Math.abs(y2-y1) > 2) {
            //cannot move vertically more than two spaces
            return false;
        } else if (Math.abs(x2-x1) >1) {
            //cannot move horizontally more than one space
            return false;
        } else if (endSq != null && startSq.player.equals(endSq.player)) {
            //cannot move to a space occupied by own piece
            return false;
        } else if (!isFirstMove && (Math.abs(y2-y1) == 2)) {
            //cannot move two spaces if not on first move
            return false;
        } else if (x2-x1 == 0 && endSq != null) {
            //cannot move vertically to a spot occupied by any piece
            return false;
        } else if (Math.abs(x1-x2) == 0 && Math.abs(y1-y2) == 2) {
            if (y1 -y2 > 0) {
                if (b.square[8-y1+1][x1-1] != null) {
                    return false;
                }
            } else {
                if (b.square[8-y1-1][x1-1] != null) {
                    return false;
                }
            }
        } else if (turn == Chess.Turn.WHITE && y2-y1 < 0) {
            //if white's turn, cannot move vertically down
            return false;
        } else if (turn == Chess.Turn.BLACK && y2 -y1 > 0) {
            //if black's turn, cannot move vertically up
            return false;
        } else if (y2-y1 == 0) {
            //cannot move horizontally ever
            return false;
        }


        if (Math.abs(y2-y1) == 1 && Math.abs(x2-x1) == 1 && endSq == null) {
            //pawn is moving diagonally to an empty space (either not allowed or en passant which is valid
            if (!enPassantFormation) {
                return false;
            } else if (turn == Chess.Turn.WHITE && y2-y1 < 0) {
                return false;
            } else if (turn == Chess.Turn.BLACK && y2-y1 > 0) {
                return false;
            }
        }
        //if it reached the conditions for a promotion

        isFirstMove = false;
        return true;

    }


}
