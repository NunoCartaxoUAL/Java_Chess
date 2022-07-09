package Models;

public class Pawn extends Piece {
    public Pawn(int px, int py,char letter, char side) {
        super(px, py, letter, side);
    }
    public boolean validMove(int[] inicialPos, int[] finalPos, Piece[][] board) {
        //TODO en passant
        //TODO first move
        int difx = finalPos[0]-inicialPos[0];
        boolean checkPos;
        if (this.getSide()=='b'){
            checkPos = (difx == -1) ;
        }else{
            checkPos = (difx == 1);
        }
        boolean checkObstruction = moveObstructed(inicialPos,finalPos,board);
        return checkPos && !checkObstruction;
    }

    @Override
    public boolean moveObstructed(int[] inicialPos, int[] finalPos, Piece[][] board) {
        var p = board[finalPos[0]][finalPos[1]];
        int difx = Math.abs(finalPos[0]-inicialPos[0]);
        int dify = Math.abs(finalPos[1]-inicialPos[1]);
        int sum = difx+dify;
        if (p!=null){
            if (p.getSide()!=this.getSide()){
                if (sum==2){
                    return false;
                }
            }
        }else{
            if (sum==1){
                return false;
            }
        }
        return true;
    }
}
