package chessGame;

import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {
        //Need to check 8 "jumps" knight can do
        Board board = Board.getInstance();
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();

        //Up-up-left
        if (currRow-2 >= 0 && currCol-1 >= 0){
            if (board.getBoard()[currRow-2][currCol-1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-2);
                        add(currCol-1);
                    }
                });
            }
            else if (board.getBoard()[currRow-2][currCol-1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-2);
                        add(currCol-1);
                    }
                });
            }
        }

        //Up-up-right
        if (currRow-2 >= 0 && currCol+1 <board.getBoard().length){
            if (board.getBoard()[currRow-2][currCol+1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-2);
                        add(currCol+1);
                    }
                });
            }
            else if (board.getBoard()[currRow-2][currCol+1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-2);
                        add(currCol+1);
                    }
                });
            }
        }

        //Up-left-left
        if (currRow-1 >= 0 && currCol-2 >= 0){
            if (board.getBoard()[currRow-1][currCol-2] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol-2);
                    }
                });
            }
            else if (board.getBoard()[currRow-1][currCol-2].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol-2);
                    }
                });
            }
        }

        //Up-right-right
        if (currRow-1 >= 0 && currCol+2 < board.getBoard().length){
            if (board.getBoard()[currRow-1][currCol+2] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol+2);
                    }
                });
            }
            else if (board.getBoard()[currRow-1][currCol+2].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow-1);
                        add(currCol+2);
                    }
                });
            }
        }

        //Down-Down-left
        if (currRow+2 < board.getBoard().length && currCol-1 >= 0){
            if (board.getBoard()[currRow+2][currCol-1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+2);
                        add(currCol-1);
                    }
                });
            }
            else if (board.getBoard()[currRow+2][currCol-1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+2);
                        add(currCol-1);
                    }
                });
            }
        }

        //Down-Down-right
        if (currRow+2 < board.getBoard().length && currCol+1 < board.getBoard().length){
            if (board.getBoard()[currRow+2][currCol+1] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+2);
                        add(currCol+1);
                    }
                });
            }
            else if (board.getBoard()[currRow+2][currCol+1].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+2);
                        add(currCol+1);
                    }
                });
            }
        }

        //Down-left-left
        if (currRow+1 < board.getBoard().length && currCol-2 >= 0){
            if (board.getBoard()[currRow+1][currCol-2] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol-2);
                    }
                });
            }
            else if (board.getBoard()[currRow+1][currCol-2].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol-2);
                    }
                });
            }
        }

        //Down-right-right
        if (currRow+1 < board.getBoard().length && currCol+2 < board.getBoard().length){
            if (board.getBoard()[currRow+1][currCol+2] == null){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol+2);
                    }
                });
            }
            else if (board.getBoard()[currRow+1][currCol+2].getColor() != color){
                moves.add(new ArrayList<>(){
                    {
                        add(currRow+1);
                        add(currCol+2);
                    }
                });
            }
        }

        return moves;
    }
}
