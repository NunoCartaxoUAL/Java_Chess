package Models;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Rook extends Piece {

    public Rook(int px, int py,char letter, char side) {
        super(px, py, letter, side);
    }

    @Override
    public boolean validMove(int[] inicialPos, int[] finalPos, Piece[][] board) {
        //TODO castling
        int difx = finalPos[0]-inicialPos[0];
        int dify = finalPos[1]-inicialPos[1];
        if (!((difx == 0) || (dify == 0))){
            return false;
        }else {
            return !moveObstructed(inicialPos,finalPos,board);
        }
    }

    @Override
    public boolean moveObstructed(int[] inicialPos, int[] finalPos,Piece[][] board) {
        int difx = finalPos[0]-inicialPos[0];
        int dify = finalPos[1]-inicialPos[1];
        int incx = 0;
        int incy = 0;
        var p =board[finalPos[0]][finalPos[1]];
        if (p!=null){
            if(p.getSide()==this.getSide()){
                return true;
            }
        }
        if (difx!=0){
            incx = (difx/Math.abs(difx));
        }
        if (dify!=0){
            incy = (dify/Math.abs(dify));
        }
        while ((finalPos[0]!=inicialPos[0]) || (finalPos[1]!=inicialPos[1])){
            inicialPos[0]+=incx;
            inicialPos[1]+=incy;
            if ((finalPos[0]==inicialPos[0]) && (finalPos[1]==inicialPos[1])){break;}
            p =board[inicialPos[0]][inicialPos[1]];
            if (p!=null){
                return true;
            }
        }
        return false;
    }
}
