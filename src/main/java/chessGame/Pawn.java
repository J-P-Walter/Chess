package chessGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(char name, char color, int startRow, int startCol, int currRow, int currCol) {
        super(name, color, startRow, startCol, currRow, currCol);
    }

    @Override
    protected int[][] getMoves() {
        return null;
    }
}
