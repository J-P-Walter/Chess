package chessGame;

public class Board {
    private static Board instance = null;

    private String[][] board;



    private Board(){
        board = new String[8][8];
    }
    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        };
        return instance;
    }

    public String[][] getBoard() {
        return board;
    }

    public void resetBoard(){
        board = new String[8][8];
    }
}

