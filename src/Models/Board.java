package Models;


import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private Piece[][] Board = new Piece[8][8];
    private ArrayList<String> moveHistory = new ArrayList<>();

    public Board() {
        String start =  "rnbqkbnr" +
                        "pppppppp" +
                        "____" +
                        "pppppppp" +
                        "rnbqkbnr";
        Integer readString = 0;
        char side = 'w';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                    switch (start.charAt(readString)){
                        case 'p' -> {
                            Board[i][j] = new Pawn(i,j,start.charAt(readString),side);
                            readString++;
                            break;
                        }
                        case 'q' -> {
                            Board[i][j] = new Queen(i,j,start.charAt(readString),side);
                            readString++;
                            break;
                        }
                        case 'n' -> {
                            Board[i][j] = new Knight(i,j,start.charAt(readString),side);
                            readString++;
                            break;
                        }
                        case 'b' ->{
                            Board[i][j] = new Bishop(i,j,start.charAt(readString),side);
                            readString++;
                            break;
                        }
                        case 'r'->{
                            Board[i][j] = new Rook(i,j,start.charAt(readString),side);
                            readString++;
                            break;
                        }
                        case 'k' ->{
                            Board[i][j] = new King(i,j,start.charAt(readString),side);
                            readString++;
                            break;
                        }
                        case '_' ->{
                            readString++;
                            j=8;
                            break;
                        }
                    }
            }
            if (i==3){side='b';}
        }
        //System.out.println(this);
    }

    public void putPiece(final Piece piece, final int px, final int py){
        this.Board[py][px] = piece;
    }

    public Piece getPiece(final int px,final int py){
        return this.Board[py][px];
    }

    public void movePiece(String from , String to){
        moveHistory.add(from+to);
        System.out.println(moveHistory);
        int[] inicialPos = this.translatePosition(from);
        int[] finalPos = this.translatePosition(to);
        var piece = this.Board[inicialPos[0]][inicialPos[1]];
        this.Board[inicialPos[0]][inicialPos[1]] = null;
        this.Board[finalPos[0]][finalPos[1]] = piece;
    }

    private int [] translatePosition(String pos) {
        int x = pos.charAt(1) -49;
        int y = pos.charAt(0) - 97;
        int[] translated = {x,y};
        return translated;
    }

    public Piece[][] getBoard() {
        return Board;
    }

    @Override
    public String toString() {
        String txt = "8 ";
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (Board[i][j] == null){
                    txt += "[__]";
                }else {
                    txt += Board[i][j];
                }
            }
            txt+="\n"+i+" ";
        }
        txt+="  A   B   C   D   E   F   G   H";
        return "" + txt ;
    }

    public boolean validMoveForPiece(String from, String to) {
        int[] inicialPos = this.translatePosition(from);
        int[] finalPos = this.translatePosition(to);
        var piece = this.Board[inicialPos[0]][inicialPos[1]];
        var board = this.getBoard();
        return piece.validMove(inicialPos,finalPos,board);
    }

    public boolean pieceExists(String from) {
        int[] inicialPos = this.translatePosition(from);
        var piece = this.Board[inicialPos[0]][inicialPos[1]];
        return piece != null;
    }

    public boolean withinBoard(String from, String to) {
        int[] inicialPos = this.translatePosition(from);
        int[] finalPos = this.translatePosition(to);
        boolean check1 = (inicialPos[0]>=0)&&(inicialPos[0]<=7);
        boolean check2 = (inicialPos[1]>=0)&&(inicialPos[1]<=7);
        boolean check3 = (finalPos[0]>=0)&&(finalPos[0]<=7);
        boolean check4 = (finalPos[1]>=0)&&(finalPos[1]<=7);
        return check1 && check2 && check3 && check4;
    }
}