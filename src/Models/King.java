package Models;

import java.util.Arrays;

public class King extends Piece {

    public King(int px, int py,char letter, char side) {
        super(px, py, letter, side);
    }

    @Override
    public boolean validMove(int[] inicialPos, int[] finalPos, Piece[][] board) {
        //TODO castling
        int difx = Math.abs(finalPos[0]-inicialPos[0]);
        int dify = Math.abs(finalPos[1]-inicialPos[1]);
        boolean checkPos = (difx <= 1) && (dify<=1);
        boolean checkObstruction = moveObstructed(inicialPos,finalPos,board);
        return checkPos && !checkObstruction;
    }

    @Override
    public boolean moveObstructed(int[] inicialPos, int[] finalPos, Piece[][] board) {
        var p = board[finalPos[0]][finalPos[1]];
        if (p!=null){
            if (p.getSide()==this.getSide()){
                return true;
            }
        }
        return false;
    }
}
