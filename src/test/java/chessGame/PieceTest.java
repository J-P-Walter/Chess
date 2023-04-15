package chessGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private static Board board = Board.getInstance();

    @BeforeEach
    void setUp() {
        board.resetBoard();
    }

    @Test
    void test(){
        board.printBoard();
    }
}