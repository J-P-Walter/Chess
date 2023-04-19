package chessGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BoardTest {
    private static Board board = Board.getInstance();

    @BeforeEach
    void setUp() throws FileNotFoundException {
        board.resetBoard();
    }

    @Test
    void test_instance(){
        Assertions.assertNotNull(board);
    }
    @Test
    @DisplayName("Testing Board Dimensions")
    void test_dimensions(){
        Assertions.assertEquals(8, board.getBoard().length);
        Assertions.assertEquals(8, board.getBoard()[0].length);
    }

    @Test
    @DisplayName("Testing singleton, @BeforeEach resets board for every test")
    void singleton_test_part_1(){
        King k = new King('K', 'W', 0, 0, 0, 0);
        board.getBoard()[0][0] = k;
        Assertions.assertEquals('K', board.getBoard()[0][0].getName());
    }
    @Test
    @DisplayName("Testing singleton, @BeforeEach resets board for every test")
    void singleton_test_part_2(){
        Assertions.assertEquals(null, board.getBoard()[0][0]);
    }

}