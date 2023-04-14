package chessGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private static Board board = Board.getInstance();

    @BeforeEach
    void setUp() {
        board.resetBoard();
    }

    @Test
    void testInstance(){
        Assertions.assertNotNull(board);
    }
    @Test
    @DisplayName("Testing Board Dimensions")
    void testDimensions(){
        Assertions.assertEquals(8, board.getBoard().length);
        Assertions.assertEquals(8, board.getBoard()[0].length);
    }

    @Test
    @DisplayName("Testing singleton, @BeforeEach resets board for every test")
    void singletonTest1(){
        board.getBoard()[0][0] = "a";
        Assertions.assertEquals("a", board.getBoard()[0][0]);
    }
    @Test
    @DisplayName("Testing singleton, @BeforeEach resets board for every test")
    void singletonTest2(){
        Assertions.assertEquals(null, board.getBoard()[0][0]);
    }
}