package piece;

import chess.Board;
import chess.Chess;
import chess.Square;

/**
 * King a subclass of Piece
 *
 *
 * @author Joshua Hernandez
 * @author John Lavin
 */


public class King extends Piece{

    public boolean isFirstMove = true;

    /**
     * method to see if a move is valid for a king
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

            if (moveXspace > 2 || moveYspace > 1) {
                return false;
            }

            if ((moveXspace ==1 && moveYspace ==0)||(moveXspace ==0 && moveYspace ==1)||(moveXspace ==1 && moveYspace ==1)){
                return true;

            }


            //check if castling
            if (moveXspace == 2 && !isFirstMove) {
                return false;
            } else if (moveXspace ==2 && isFirstMove) {
                //check if trying to castle with left rook or right rook
                if (x1 < x2) {
                    //castling with right rook
                    if (turn == Chess.Turn.WHITE) {
                        if (!(b.square[7][7].piece instanceof Rook)) {
                            return false;
                        } else {
                            Rook r = (Rook) b.square[7][7].piece;
                            if (!r.isFirstMove) {
                                return false;
                            }

                            //confirm there are no pieces between them
                            for (int i = x1; i < x2; i++) {
                                if (b.square[7][i] != null) {
                                    return false;
                                }
                            }

                        }
                    } else {
                        if (!(b.square[0][7].piece instanceof Rook)) {
                            return false;
                        } else {
                            Rook r = (Rook) b.square[0][7].piece;
                            if (!r.isFirstMove) {
                                return false;
                            }

                            //confirm no pieces between them
                            for (int i = x1; i < x2; i++) {
                                if (b.square[0][i] != null) {
                                    return false;
                                }
                            }
                        }
                    }
                } else {
                    //castling with left rook
                    //confirm for turn and if left rook is in first move
                    if (turn == Chess.Turn.WHITE) {
                        if (!(b.square[7][0].piece instanceof Rook)) {
                            return false;
                        } else {
                            Rook r = (Rook) b.square[7][7].piece;
                            if (!r.isFirstMove) {
                                return false;
                            }

                            //confirm there are no pieces between them
                            for (int i = x1-2; i > x2; i--) {
                                if (b.square[7][i] != null) {
                                    return false;
                                }
                            }

                        }
                    } else {
                        if (!(b.square[0][0].piece instanceof Rook)) {
                            return false;
                        } else {
                            Rook r = (Rook) b.square[0][0].piece;
                            if (!r.isFirstMove) {
                                return false;
                            }

                            //confirm no pieces between them
                            for (int i = x1-2; i > x2; i--) {
                                if (b.square[0][i] != null) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }

            isFirstMove = false;
            return true;
        }

    /**
     * method to see if a king can move out of a check
     * @param startSq
     * @param b
     * @param turn
     * @param x1
     * @param y1
     * @param underCheck
     * @return true or false
     */
        public boolean canMoveOut(Square startSq, Board b, Chess.Turn turn, int x1, int y1, boolean underCheck) {

            int row = 8 - y1;
            int col = x1 - 1;

            Board testBoard = b;

            //move king in all directions and call checkingforCheck
            if (row != 7) {
                //check down
                //move down 1
                testBoard.square[row+1][col] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (row != 0) {
                //check up
                //move up 1
                testBoard.square[row-1][col] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (col != 0) {
                //check right
                //move down 1
                testBoard.square[row][col-1] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (col != 7) {
                //check left
                //move left 1
                testBoard.square[row][col+1] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard,row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (row != 0 && col != 7) {
                //if not in top-right
                //check up right
                testBoard.square[row-1][col+1] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (row != 0 && col != 0) {
                //if not in top-left
                //check up left
                testBoard.square[row-1][col-1] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (row != 7 && col != 0) {
                //if not in bottom-left
                //check down left
                testBoard.square[row+1][col-1] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            if (row != 7 && col != 7) {
                //if not in bottom-right
                //check down right
                testBoard.square[row+1][col+1] = startSq;
                testBoard.square[row][col] = null;
                boolean stillCheck = Chess.CheckingForcheck(testBoard, row, col, turn);

                //return true if stillCheck is false;
                if (!stillCheck) {
                    return true;
                }
                testBoard = b;
            }

            return false;
        }
}

