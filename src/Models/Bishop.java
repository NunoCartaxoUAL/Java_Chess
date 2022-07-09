package Models;

public class Bishop extends Piece {
    public Bishop(int px, int py,char letter, char side) {
        super(px, py, letter, side);
    }
    public boolean validMove(int[] inicialPos, int[] finalPos, Piece[][] board) {
        int sumx = Math.abs(finalPos[0]-inicialPos[0]);
        int sumy = Math.abs(finalPos[1]-inicialPos[1]);
        if (sumx!=sumy){
            return false;
        }else {
            return !moveObstructed(inicialPos,finalPos,board);
        }
    }
    /*move = [abs(ToCoord[0] - FromCoord[0]), abs(ToCoord[1] - FromCoord[1])]

            # Can only move diagonal
            if move[0] == move[1]:
                return True

            return False*/
    @Override
    public boolean moveObstructed(int[] inicialPos, int[] finalPos,Piece[][] board) {
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
