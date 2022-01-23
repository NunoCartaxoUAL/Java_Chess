package Models;


import java.util.Arrays;

public class Board {

    private Piece[][] Board = new Piece[8][8];

    public void putPiece(final Piece piece,final int px,final int py){
        this.Board[py][px] = piece;
    }

    public Piece getPiece(final int px,final int py){
        return this.Board[py][px];
    }

    public void movePiece(final int ipx ,final int ipy ,final int fpx ,final int fpy ){
        var piece = this.Board[ipy][ipx];
        //TODO check if move is valid
        //TODO check if there is piece at position (eat or move)
        this.Board[fpy][fpx] = piece;
    }
    public Piece[][] getBoard() {
        return Board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "Board=" + Arrays.toString(Board) +
                '}';
    }
}