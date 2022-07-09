package Views;

import Models.Board;

import java.util.Scanner;

public class CLI {
    private final Board board;
    public CLI() {
        board = new Board();
        Scanner sc = new Scanner(System.in);
        String[] input;
        while (true){
            System.out.println(board);
            System.out.print(">");
            input = sc.nextLine().split(" ");
            String first = input[0];
            switch (first){
                case "move"->{
                    if ((input.length==3)&&(input[1].length()==2)&&(input[2].length()==2)) {
                        //System.out.println(board);,o
                        String from = input[1];
                        String to = input[2];
                        if (!board.pieceExists(from)){
                            System.out.println("No Piece to move in this tile");
                        }else if(!board.withinBoard(from,to)){
                            System.out.println("Please select a position within the board");
                        }else if (!board.validMoveForPiece(from,to)){
                            System.out.println("Invalid Move for this Piece");
                        } else {
                            board.movePiece(from,to);
                        }
                    }
                }


            }

        }
    }
}
