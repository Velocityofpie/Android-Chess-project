package chess;
import pieces.*;

/**
 * keep track of the current state of each square on the chess board
 *
 *
 * @author John Lavin and Joshua Hernandez
 */

public class Square {

    /**
     * Chess piece on the square
     */

    public Piece piece;

    /**
     * The player is either the piece white or black
     */

    public String player;
    /**
     * Constructor
     *
     * @param piece what Piece
     * @param player Player's color
     */

    public Square(Piece piece, String player) {
        this.piece = piece;
        this.player = player;
    }

    /**
     *
     * The formatted color and chess piece ( white's pawn: wp or wK)
     */
    @Override
    public String toString() {
        if(piece instanceof King) return player + 'K';
        if(piece instanceof Queen) return player + 'Q';
        if(piece instanceof Rook) return player + 'R';
        if(piece instanceof Knight) return player + 'N';
        if(piece instanceof Bishop) return player + 'B';
        if(piece instanceof Pawn) return player + 'p';
        else return "  ";
    }
}
