package chessGame;

import java.awt.*;
import java.util.ArrayList;



public class Pawn extends Piece {
    public Pawn(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {
        //5 Cases for pawn movement: move forward 1, move forward 2, attack diagonally, en passant, promotion
        //Probably won't handle promotion here tho
        Board board = Board.getInstance();

        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
        int direction;
        if (color == Color.WHITE) {
            direction = -1;
        } else {
            direction = 1;
        }

        //Pawns can only move forward, so checking to make sure that they can't go out of bounds row-wise
        //Will probably become irrelevant since the pawn should promote if it reaches that row, but just in case
        if (currRow + direction >= 0 && currRow + direction < board.getBoard().length) {
            //Moving directly forward 1 square unimpeded
            if (board.getBoard()[currRow + direction][currCol] == null) {
                moves.add(new ArrayList<>() {
                    {
                        add(currRow + direction);
                        add(currCol);
                    }
                });
            }

            //Moving forward two as first move, makes sure landing square and square in between is open
            if (currCol == startCol && currRow == startRow){
                if (board.getBoard()[currRow + direction + direction][currCol] == null &&
                        board.getBoard()[currRow + direction][currCol] == null) {
                    moves.add(new ArrayList<>() {
                        {
                            add(currRow + direction + direction);
                            add(currCol);
                        }
                    });
                }
            }

           //Attacking left
           if (currCol-1 >= 0 && board.getBoard()[currRow+direction][currCol-1] != null){
               if (board.getBoard()[currRow+direction][currCol-1].getColor() != color) {
//                   moves.add(new int[]{currRow + direction, currCol - 1});
                   moves.add(new ArrayList<>() {
                       {
                           add(currRow + direction);
                           add(currCol - 1);
                       }
                   });
               }
           }
           //Attacking right
            if (currCol+1 < board.getBoard().length && board.getBoard()[currRow+direction][currCol+1] != null){
                if (board.getBoard()[currRow+direction][currCol+1].getColor() != color) {
                    moves.add(new ArrayList<>() {
                        {
                            add(currRow + direction);
                            add(currCol + 1);
                        }
                    });
                }
            }




        }
        return moves;
    }
}
