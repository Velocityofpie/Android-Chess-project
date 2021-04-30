package pieces;

import chess.Board;
import chess.Chess;
import chess.Square;

/**
 *  Knight a subclass of Piece
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */

public class Knight extends Piece{

    /**
     * method to see if a move is valid for a knight
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
    public boolean isMoveValid(Square startSq, Square endSq, Board b, Chess.Turn turn, int x1, int y1, int x2, int y2, boolean enPassantFormation) {

        if (startSq == null) {
            return false;
        }
        if (turn == Chess.Turn.WHITE && startSq.player.equals("b")) {
            return false;
        } else if (turn == Chess.Turn.BLACK && startSq.player.equals("w")) {
            return false;
        }
        int moveXspace = Math.abs(x1 - x2);
        int moveYspace = Math.abs(y1 - y2);

        if(endSq != null && startSq.player.equals(endSq.player)) {
            return false;
        }
        //Left or right 1, up or down 2
        if(moveXspace == 1 && moveYspace == 2) {
            return true;
        }
        //Left or right 2, up or down 1
        if(moveXspace == 2 && moveYspace == 1){
            return true;
        }

        return false;
    }
}

