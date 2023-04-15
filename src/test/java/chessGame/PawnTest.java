package chessGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    private static Board board = Board.getInstance();

    @BeforeEach
    void setUp() {
        board.resetBoard();
    }

    @Test
    @DisplayName("Testing moving forward")
    void moveForward(){
        Pawn whitePawn = new Pawn('P', 'W', 5, 4, 6, 4);
        Pawn blackPawn = new Pawn('P', 'B', 3, 3, 3, 3);
        board.pieces[0] = whitePawn;
        board.pieces[1] = blackPawn;


//        board.placePieces();
//        board.printBoard();
        int[][] whiteMoves = new int[1][2];
        whiteMoves[0][0] = 4;
        whiteMoves[0][1] = 4;

        int[][] blackMoves = new int[1][2];
        blackMoves[0][0] = 4;
        blackMoves[0][1] = 3;

        Assertions.assertArrayEquals(whiteMoves, whitePawn.getMoves());
        Assertions.assertArrayEquals(blackMoves, blackPawn.getMoves());


    }

    @Test
    @DisplayName("Testing first move two squares")
    void moveTwo(){}

    @Test
    @DisplayName("Testing attacking")
    void attack(){}

    @Test
    @DisplayName("Testing En passant")
    void enPassant(){}

    @Test
    @DisplayName("Testing promotion")
    void promotion(){}
}