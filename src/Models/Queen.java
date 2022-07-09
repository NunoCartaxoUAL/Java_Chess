package Models;

public class Queen extends Piece {
    public Queen(int px, int py,char letter, char side) {
        super(px, py, letter, side);
    }
    @Override
    public boolean validMove(int[] inicialPos, int[] finalPos, Piece[][] board) {
        int difx = finalPos[0]-inicialPos[0];
        int dify = finalPos[1]-inicialPos[1];
        int sumx = Math.abs(finalPos[0]-inicialPos[0]);
        int sumy = Math.abs(finalPos[1]-inicialPos[1]);
        if ((!((difx == 0) || (dify == 0))) && (sumx!=sumy)){
            return false;
        }else {
            if (difx==dify){
                return !moveObstructedDiag(inicialPos,finalPos,board);
            }else{
                return !moveObstructedStraight(inicialPos,finalPos,board);
            }
        }
    }

    public boolean moveObstructedStraight(int[] inicialPos, int[] finalPos,Piece[][] board) {
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
    public boolean moveObstructedDiag(int[] inicialPos, int[] finalPos,Piece[][] board) {
        int difx = finalPos[0]-inicialPos[0];
        int dify = finalPos[1]-inicialPos[1];
        int inc1 = (difx/Math.abs(difx));
        int inc2 = (dify/Math.abs(dify));
        var p =board[finalPos[0]][finalPos[1]];
        if (p!=null){
            if(p.getSide()==this.getSide()){
                return true;
            }
        }
        while ((finalPos[0]!=inicialPos[0]) && (finalPos[1]!=inicialPos[1])){
            inicialPos[0]+=inc1;
            inicialPos[1]+=inc2;
            if ((finalPos[0]==inicialPos[0]) && (finalPos[1]==inicialPos[1])){break;}
            p =board[inicialPos[0]][inicialPos[1]];
            if (p!=null){
                return true;
            }
        }
        return false;
    }
}
