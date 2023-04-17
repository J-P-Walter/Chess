package chessGame;

import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {


        return null;
    }
}
