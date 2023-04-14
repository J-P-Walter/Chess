package chessGame;

public class ChessGame {
    private static Board board;

    public ChessGame() {
        board = Board.getInstance();
    }
    public static void main(String[] args) {
        ChessGame game = new ChessGame();

    }
}