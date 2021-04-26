package piece;

import chess.Board;
import chess.Chess;
import chess.Square;

/**
 * Bishop a subclass of Piece
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */

public class Bishop extends Piece{

    /**
     * returns a boolean
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
        } else if (startSq == endSq) {
            //cannot choose the same spot
            return false;
        } else if (endSq != null) {
            if (turn == Chess.Turn.WHITE && endSq.player.equals("w")) {
                return false;
            } else if (turn == Chess.Turn.BLACK && endSq.player.equals("b")) {
                return false;
            }
        }
        int moveXspace = Math.abs(x1 - x2);
        int moveYspace = Math.abs(y1 - y2);

        if (moveXspace != moveYspace) {
            return false;
        }

        //diagonal up right
        if (x1 < x2 && y1 < y2) {
            for (int i = 8-y1-1, j = x1; i > 8-y2 && j < x2-1; i--, j++) {
                if (b.square[i][j] != null) {
                    return false;
                }
            }
        }

        //diagonal up left
        if (x1 > x2 && y1 < y2) {
            for (int i = 8-y1-1, j = x1-2; i > 8-y2 && j > x2; i--, j--) {
                if (b.square[i][j] != null) {
                    return false;
                }
            }
        }

        //diagonal down right
        if (x1 < x2 && y1 > y2) {
            for (int i = 8-y1+1, j = x1; i < 8-y2 && j < x2-1; i++, j++) {
                if (b.square[i][j] != null){
                    return false;
                }
            }
        }

        //diagonal down left
        if (x1 > x2 && y1 > y2) {
            for (int i = 8-y1+1, j = x1-2; i < 8-y2 && j > x2; i++, j--) {
                if (b.square[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }
}

