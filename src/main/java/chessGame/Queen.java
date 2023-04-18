package chessGame;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {
        //Reused code from Rook and Bishop since those have been tested
        //and the queen really just follows the same rule, might be a way to refactor
        //and look prettier
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
            } else {
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

        //Up left
        int idx = 1;
        while(currRow-idx >= 0  && currCol-idx >= 0){
            if (board.getBoard()[currRow-idx][currCol-idx] == null){
                int finalIdx = idx;
                moves.add(new ArrayList<>() {{
                    add(currRow - finalIdx);
                    add(currCol - finalIdx);
                }});
            } else if (board.getBoard()[currRow-idx][currCol-idx].getColor() != color) {
                int finalIdx = idx;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow - finalIdx);
                        add(currCol - finalIdx);
                    }
                });
                break;
            } else {
                break;
            }
            idx++;
        }

        //Up right
        idx = 1;
        while(currRow-idx >= 0  && currCol+idx < board.getBoard().length){
            if (board.getBoard()[currRow-idx][currCol+idx] == null){
                int finalIdx = idx;
                moves.add(new ArrayList<>() {{
                    add(currRow - finalIdx);
                    add(currCol + finalIdx);
                }});
            } else if (board.getBoard()[currRow-idx][currCol+idx].getColor() != color) {
                int finalIdx = idx;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow - finalIdx);
                        add(currCol + finalIdx);
                    }
                });
                break;
            } else {
                break;
            }
            idx++;
        }

        //Down left
        idx = 1;
        while(currRow+idx < board.getBoard().length && currCol-idx >= 0){
            if (board.getBoard()[currRow+idx][currCol-idx] == null){
                int finalIdx = idx;
                moves.add(new ArrayList<>() {{
                    add(currRow + finalIdx);
                    add(currCol - finalIdx);
                }});
            } else if (board.getBoard()[currRow+idx][currCol-idx].getColor() != color) {
                int finalIdx = idx;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow + finalIdx);
                        add(currCol - finalIdx);
                    }
                });
                break;
            } else {
                break;
            }
            idx++;
        }

        //Down right
        idx = 1;
        while(currRow+idx < board.getBoard().length && currCol+idx < board.getBoard().length){
            if (board.getBoard()[currRow+idx][currCol+idx] == null){
                int finalIdx = idx;
                moves.add(new ArrayList<>() {{
                    add(currRow + finalIdx);
                    add(currCol + finalIdx);
                }});
            } else if (board.getBoard()[currRow+idx][currCol+idx].getColor() != color) {
                int finalIdx = idx;
                moves.add(new ArrayList<>() {
                    {
                        add(currRow + finalIdx);
                        add(currCol + finalIdx);
                    }
                });
                break;
            } else {
                break;
            }
            idx++;
        }

        return moves;
    }
}
