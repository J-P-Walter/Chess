package chessGame;

import java.awt.*;

public class ChessGame {
    static Board board;

    public ChessGame() {
        board = Board.getInstance();
        board.initialize();
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        Player whitePlayer = new Player(Color.WHITE);
        Player blackPlayer = new Player(Color.BLACK);
    }

    public void startGame(Player whitePlayer, Player blackplayer){
        Player currentPlayer = whitePlayer;

        while (true){
            if (currentPlayer.getInCheck()){
                //if player in check
                //check all own pieces move, check if that all those results still check
                //if yes, checkmate, break
                //else, return get valid moves
                System.out.println("CHECK");
                break;
            }
            else {
                //else check all own pieces move, check if move results in check, build valid moves
                //make move
                //if move puts opponent in check, mark it
            }



            //switch players
        }
    }


}