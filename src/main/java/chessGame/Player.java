package chessGame;

import java.awt.*;

public class Player {
    private Color color;
    private boolean inCheck = false;
    private boolean isCheckmated = false;

    public Player(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public boolean getInCheck(){
        return inCheck;
    }
    public boolean getIsCheckmated(){
        return isCheckmated;
    }

    public void setInCheck(boolean inCheck) {
        this.inCheck = inCheck;
    }
    public void setCheckmated(){
        isCheckmated = true;
    }
}
