package chessGame;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {
        //Four cases for rook movement, up, down, left, and right
        //Simply iterate over, stopping when reaching the edge of the board or another piece of either team
        Board board = Board.getInstance();
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();

        //Left
        int left = 1;
        while (currCol-left >=0){
            if (board.getBoard()[currRow][currCol-left] == null) {
                int tempLeft = left;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow);
                        add(currCol - tempLeft);
                    }
                });
            }
            else if (board.getBoard()[currRow][currCol-left].getColor() != color){
                int tempLeft = left;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow);
                        add(currCol - tempLeft);
                    }
                });
                break;
            }
            else {
                break;
            }
            left++;
        }
        //Right
        int right = 1;
        while (currCol+right < board.getBoard().length){
            if (board.getBoard()[currRow][currCol+right] == null){
                int tempRight = right;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow);
                        add(currCol + tempRight);
                    }
                });
            }
            else if (board.getBoard()[currRow][currCol+right].getColor() != color){
                int tempRight = right;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow);
                        add(currCol + tempRight);
                    }
                });
                break;
            } else {
                break;
            }
            right++;
        }
        //Up
        int up = 1;
        while (currRow-up >=0){
            if (board.getBoard()[currRow-up][currCol] == null){
                int tempUp = up;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow - tempUp);
                        add(currCol);
                    }
                });
            }
            else if (board.getBoard()[currRow-up][currCol].getColor() != color){
                int tempUp = up;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow - tempUp);
                        add(currCol);
                    }
                });
                break;
            }
            else {
                break;
            }
            up++;
        }
        //Down
        int down = 1;
        while (currRow+down < board.getBoard().length){
            if (board.getBoard()[currRow+down][currCol] == null){
                int tempDown = down;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow + tempDown);
                        add(currCol);
                    }
                });
            }
            else if (board.getBoard()[currRow+down][currCol].getColor() != color){
                int tempDown = down;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow + tempDown);
                        add(currCol);
                    }
                });
                break;
            } else {
                break;
            }
            down++;
        }
        return moves;
    }
}
