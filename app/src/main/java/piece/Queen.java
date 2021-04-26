package piece;

import chess.Board;
import chess.Chess;
import chess.Square;

/**
 * Queen a subclass of Piece
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */

public class Queen extends Piece{

    /**
     * method to check if a move is valid for a queen
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
        } else if (endSq != null) {
            if (turn == Chess.Turn.WHITE && endSq.player.equals("w")) {
                return false;
            } else if (turn == Chess.Turn.BLACK && endSq.player.equals("b")) {
                return false;
            }
        }

        int moveXspace = Math.abs(x1 - x2);
        int moveYspace = Math.abs(y1 - y2);

        if (moveXspace != 0) {
            if (moveYspace != 0) {
                if (moveXspace != moveYspace) {
                    //if x and y moves are not zero, they must be equal to be diagonal
                    return false;
                } else {
                    //move diagonally using bishop moves
                    //Bishop moves
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
                }
            } else {
                //moveXspace is nonzero and moveYspace is zero
                //this is horizontal rook movement
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
            }
        } else {
            //moveXspace is 0 and moveYspace is nonzero (we know nonzero since if y were zero would be an error caught earlier)
            //this is vertical rook movement
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
        }

        return true;

    }
}

