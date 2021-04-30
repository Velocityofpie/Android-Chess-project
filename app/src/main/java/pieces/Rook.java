package pieces;
import chess.*;

/**
 * Rook a subclass of Piece
 *
 * @author Joshua Hernandez
 * @author John Lavin 
 * 
 */
public class Rook extends Piece {

    public boolean isFirstMove = true;

    /**
     * method to see if a move is valid for a rook
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

        //Moving down
        if (moveXspace == 0 && moveYspace > 0) {
            if (y1 > y2) {
                for (int i = 8-y1+1; i < 8-y2; i++) {
                    if (b.square[i][x1-1] != null){
                        return false;
                    }
                }
            }
        }

        //Moving up
        if (moveXspace == 0 && moveYspace > 0) {
            if (y1 < y2) {
                for (int i = 8-y1-1; i > 8-y2; i--) {
                    if (b.square[i][x1-1] != null) {
                        return false;
                    }
                }
            }
        }

        //Moving right
        if (moveXspace > 0 && moveYspace == 0) {
            if (x1 < x2) {
                for (int i = x1; i < x2-1; i++) {
                    if (b.square[8-y1][i] != null) {

                        return false;
                    }
                }
            }
        }

        //Moving left
        if (moveXspace > 0 && moveYspace == 0) {
            if (x1 > x2) {
                for (int i = x1-2; i > x2-1; i--) {
                    if (b.square[8-y1][i] != null) {
                        return false;
                    }
                }
            }
        }

        isFirstMove = false;
        return true;
    }

}