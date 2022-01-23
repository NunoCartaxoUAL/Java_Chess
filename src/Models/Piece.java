package Models;

import java.util.Arrays;

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

    public int[] setPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "position=" + Arrays.toString(position) +
                ", letter=" + letter +
                ", side=" + side +
                '}';
    }
}