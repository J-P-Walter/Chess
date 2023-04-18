package chessGame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {
        Board board = Board.getInstance();
        ArrayList<ArrayList<Integer>> moves = new ArrayList<>();

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
