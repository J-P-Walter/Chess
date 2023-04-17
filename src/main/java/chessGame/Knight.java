package chessGame;

import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected ArrayList<ArrayList<Integer>> getMoves() {


        return null;
    }
}
