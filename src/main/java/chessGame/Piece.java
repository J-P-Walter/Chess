package chessGame;

import java.awt.Color;

public abstract class Piece {
    protected char name;
    protected Color color;
    protected int startRow, startCol;
    protected int currRow, currCol;

    public Piece(char name, char color, int startRow, int startCol, int currRow, int currCol){
        this.name = name;
        if (color == 'W'){
            this.color = Color.WHITE;
        } else {
            this.color = Color.BLACK;
        }
        this.startRow = startRow;
        this.startCol = startCol;
        this.currRow = startRow;
        this.currCol = startCol;
    }

    protected abstract void getMoves();

    public void move(int newRow, int newCol){
        currRow = newRow;
        currCol = newCol;
    }

    public int getCurrRow(){
        return currRow;
    }
    public int getCurrCol(){
        return currCol;
    }
    public char getName(){
        return name;
    }
}
