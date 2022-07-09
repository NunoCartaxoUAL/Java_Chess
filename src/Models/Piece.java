package Models;

public class Piece {

    private int[] position= new int[2];
    private char letter;
    private char side;

    public Piece(final int px,final int py,final char letter,final char side) {
        this.position[0] = px;
        this.position[1] = py;
        this.letter=letter;
        this.side = side;
    }


    public char getletter() {
        return letter;
    }

    public char getSide() {
        return side;
    }

    public void setPosition(final int px, final int py) {
        this.position[0] = px;
        this.position[1] = py;
    }

    @Override
    public String toString() {
        return "[" +
                "" + side +
                "" + letter +
                ']';
    }

    public boolean validMove(int[] inicialPos, int[] finalPos, Piece[][] board) {
        return true;
    }

    public boolean moveObstructed(int[] inicialPos, int[] finalPos, Piece[][] board) {
        return true;
    }
}