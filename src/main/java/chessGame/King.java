package chessGame;

import java.util.ArrayList;

public class King extends Piece{
    public King(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {
        //King can move 8 directions, cardinal and diagonal
        Board board = Board.getInstance();
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();

        //Up
        if (currRow-1 >= 0){
            if (board.getBoard()[currRow-1][currCol] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol);
                    }
                });
            }
            else if (board.getBoard()[currRow-1][currCol].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol);
                    }
                });
            }
        }
        //Down
        if (currRow+1 < board.getBoard().length){
            if (board.getBoard()[currRow+1][currCol] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol);
                    }
                });
            }
            else if (board.getBoard()[currRow+1][currCol].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol);
                    }
                });
            }
        }

        //Left
        if (currCol-1 >= 0){
            if (board.getBoard()[currRow][currCol-1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow);
                        add(currCol-1);
                    }
                });
            }
            else if (board.getBoard()[currRow][currCol-1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow);
                        add(currCol-1);
                    }
                });
            }
        }

        //Right
        if (currCol+1 <board.getBoard().length){
            if (board.getBoard()[currRow][currCol+1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow);
                        add(currCol+1);
                    }
                });
            }
            else if (board.getBoard()[currRow][currCol+1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow);
                        add(currCol+1);
                    }
                });
            }
        }

        //Up-left
        if (currRow-1 >= 0 && currCol-1 >= 0){
            if (board.getBoard()[currRow-1][currCol-1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol-1);
                    }
                });
            }
            else if (board.getBoard()[currRow-1][currCol-1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol-1);
                    }
                });
            }
        }

        //Up-right
        if (currRow-1 >= 0 && currCol+1 <board.getBoard().length){
            if (board.getBoard()[currRow-1][currCol+1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol+1);
                    }
                });
            }
            else if (board.getBoard()[currRow-1][currCol+1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol+1);
                    }
                });
            }
        }

        //Down-left
        if (currRow+1 < board.getBoard().length && currCol-1 >= 0){
            if (board.getBoard()[currRow+1][currCol-1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol-1);
                    }
                });
            }
            else if (board.getBoard()[currRow+1][currCol-1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol-1);
                    }
                });
            }
        }

        //Down-right
        if (currRow+1 < board.getBoard().length && currCol+1 < board.getBoard().length){
            if (board.getBoard()[currRow+1][currCol+1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol+1);
                    }
                });
            }
            else if (board.getBoard()[currRow+1][currCol+1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol+1);
                    }
                });
            }
        }
        return moves;
    }
}
