package chessGame;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    private static Board board = Board.getInstance();

    @BeforeEach
    void setUp() throws FileNotFoundException {
        board.resetBoard();
    }
    @AfterEach
    void printBoard(){
        board.printBoard();
        System.out.println("\n");
    }

    @Test
    @DisplayName("Center of board test")
    void rook_center_test(){
        Rook rook = new Rook('R', 'W', 0, 0, 4, 4);
        board.getBoard()[rook.getCurrRow()][rook.getCurrCol()] = rook;

        Assertions.assertEquals(14, rook.getMoves().size());
        Assertions.assertTrue(rook.getMoves().contains(new ArrayList<Integer>() {
            {
                add(0);
                add(4);
            }
        }));
        Assertions.assertTrue(rook.getMoves().contains(new ArrayList<Integer>() {
            {
                add(4);
                add(0);
            }
        }));
        Assertions.assertTrue(rook.getMoves().contains(new ArrayList<Integer>() {
            {
                add(7);
                add(4);
            }
        }));
        Assertions.assertTrue(rook.getMoves().contains(new ArrayList<Integer>() {
            {
                add(4);
                add(7);
            }
        }));
    }

    @Test
    @DisplayName("Edge tests")
    void rook_edge_test(){
        Rook rook1 = new Rook('R', 'W', 0, 0, 0, 4);
        Rook rook2 = new Rook('R', 'W', 0, 0, 7, 5);
        Rook rook3 = new Rook('R', 'W', 0, 0, 4, 0);
        Rook rook4 = new Rook('R', 'W', 0, 0, 5, 7);

        board.getBoard()[rook1.getCurrRow()][rook1.getCurrCol()] = rook1;
        board.getBoard()[rook2.getCurrRow()][rook2.getCurrCol()] = rook2;
        board.getBoard()[rook3.getCurrRow()][rook3.getCurrCol()] = rook3;
        board.getBoard()[rook4.getCurrRow()][rook4.getCurrCol()] = rook4;

        Assertions.assertEquals(14, rook1.getMoves().size());
        Assertions.assertEquals(14, rook2.getMoves().size());
        Assertions.assertEquals(14, rook3.getMoves().size());
        Assertions.assertEquals(14, rook4.getMoves().size());
    }

    @Test
    @DisplayName("Corner tests")
    void rook_corner_test(){
        Rook rook1 = new Rook('R', 'W', 0, 0, 0, 0);
        Rook rook2 = new Rook('R', 'W', 0, 0, 0, 7);
        Rook rook3 = new Rook('R', 'W', 0, 0, 7, 0);
        Rook rook4 = new Rook('R', 'W', 0, 0, 7, 7);

        board.getBoard()[rook1.getCurrRow()][rook1.getCurrCol()] = rook1;
        board.getBoard()[rook2.getCurrRow()][rook2.getCurrCol()] = rook2;
        board.getBoard()[rook3.getCurrRow()][rook3.getCurrCol()] = rook3;
        board.getBoard()[rook4.getCurrRow()][rook4.getCurrCol()] = rook4;

        Assertions.assertEquals(12, rook1.getMoves().size());
        Assertions.assertEquals(12, rook2.getMoves().size());
        Assertions.assertEquals(12, rook3.getMoves().size());
        Assertions.assertEquals(12, rook4.getMoves().size());
    }

    @Test
    @DisplayName("Blocked tests")
    void rook_blocked_tests_1(){
        Rook rook1 = new Rook('R', 'W', 0, 0, 1, 1);
        Pawn pawn1 = new Pawn('P', 'W', 6, 6, 0, 1);
        Pawn pawn2 = new Pawn('P', 'W', 6, 6, 2, 1);
        Pawn pawn3 = new Pawn('P', 'W', 6, 6, 1, 0);
        Pawn pawn4 = new Pawn('P', 'W', 6, 6, 1, 2);

        board.getBoard()[rook1.getCurrRow()][rook1.getCurrCol()] = rook1;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;

        Assertions.assertEquals(0, rook1.getMoves().size());
    }

    @Test
    void rook_blocked_tests_2(){
        Rook rook1 = new Rook('R', 'W', 0, 0, 4, 1);
        Pawn pawn1 = new Pawn('P', 'W', 6, 6, 5, 1);
        Pawn pawn2 = new Pawn('P', 'W', 6, 6, 4, 2);

        board.getBoard()[rook1.getCurrRow()][rook1.getCurrCol()] = rook1;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;

        Assertions.assertEquals(5, rook1.getMoves().size());
    }
    @Test
    @DisplayName("Take tests")
    void rook_take_tests(){
        Rook whiteRook = new Rook('R', 'W', 0, 0, 3, 4);
        Pawn whitePawn1 = new Pawn('P', 'W', 6, 6, 3, 5);
        Pawn whitePawn2 = new Pawn('P', 'W', 6, 6, 4, 4);
        Pawn blackPawn1 = new Pawn('P', 'B', 0,0, 3, 1);
        Pawn blackPawn2 = new Pawn('P', 'B', 0, 0, 1, 4);

        board.getBoard()[whiteRook.getCurrRow()][whiteRook.getCurrCol()] = whiteRook;
        board.getBoard()[whitePawn1.getCurrRow()][whitePawn1.getCurrCol()] = whitePawn1;
        board.getBoard()[whitePawn2.getCurrRow()][whitePawn2.getCurrCol()] = whitePawn2;
        board.getBoard()[blackPawn1.getCurrRow()][blackPawn1.getCurrCol()] = blackPawn1;
        board.getBoard()[blackPawn2.getCurrRow()][blackPawn2.getCurrCol()] = blackPawn2;

        Assertions.assertEquals(5, whiteRook.getMoves().size());
        Assertions.assertTrue(whiteRook.getMoves().contains(new ArrayList<Integer>() {
            {
                add(3);
                add(1);
            }
        }));
        Assertions.assertTrue(whiteRook.getMoves().contains(new ArrayList<Integer>() {
            {
                add(1);
                add(4);
            }
        }));
    }
}