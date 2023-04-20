package chessGame;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private static Board board = Board.getInstance();

    @BeforeEach
    void setUp() throws FileNotFoundException {
        board.resetBoard();
    }
//    @AfterEach
//    void printBoard(){
//        board.printBoard();
//        System.out.println("\n");
//    }

    @Test
    @DisplayName("Center of board")
    void bishop_center_test(){
       Bishop bishop = new Bishop('B', 'W', 7, 2, 4, 4);
       board.getBoard()[bishop.getCurrRow()][bishop.getCurrCol()] = bishop;

        Assertions.assertEquals(13, bishop.getMoves().size());
        Assertions.assertTrue(bishop.getMoves().contains(new ArrayList<Integer>() {
            {
                add(0);
                add(0);
            }
        }));
        Assertions.assertTrue(bishop.getMoves().contains(new ArrayList<Integer>() {
            {
                add(1);
                add(7);
            }
        }));
        Assertions.assertTrue(bishop.getMoves().contains(new ArrayList<Integer>() {
            {
                add(7);
                add(7);
            }
        }));
        Assertions.assertTrue(bishop.getMoves().contains(new ArrayList<Integer>() {
            {
                add(7);
                add(1);
            }
        }));
    }
//
    @Test
    @DisplayName("Edge tests")
    void bishop_edge_test(){
        Bishop bishop1 = new Bishop('B', 'W', 0, 0, 0, 4);
        Bishop bishop2 = new Bishop('B', 'W', 0, 0, 7, 5);
        Bishop bishop3 = new Bishop('B', 'W', 0, 0, 3, 0);
        Bishop bishop4 = new Bishop('B', 'W', 0, 0, 4, 7);

        board.getBoard()[bishop1.getCurrRow()][bishop1.getCurrCol()] = bishop1;
        board.getBoard()[bishop2.getCurrRow()][bishop2.getCurrCol()] = bishop2;
        board.getBoard()[bishop3.getCurrRow()][bishop3.getCurrCol()] = bishop3;
        board.getBoard()[bishop4.getCurrRow()][bishop4.getCurrCol()] = bishop4;

        Assertions.assertEquals(7, bishop1.getMoves().size());
        Assertions.assertEquals(7, bishop2.getMoves().size());
        Assertions.assertEquals(7, bishop3.getMoves().size());
        Assertions.assertEquals(7, bishop4.getMoves().size());
    }

    @Test
    @DisplayName("Corner test")
    void bishop_corner_test() {
        Bishop bishop1 = new Bishop('B', 'W', 0, 0, 0, 0);
        Bishop bishop2 = new Bishop('B', 'W', 0, 0, 7, 7);
        Bishop bishop3 = new Bishop('B', 'W', 0, 0, 0, 7);
        Bishop bishop4 = new Bishop('B', 'W', 0, 0, 7, 0);

        board.getBoard()[bishop1.getCurrRow()][bishop1.getCurrCol()] = bishop1;
        board.getBoard()[bishop2.getCurrRow()][bishop2.getCurrCol()] = bishop2;
        board.getBoard()[bishop3.getCurrRow()][bishop3.getCurrCol()] = bishop3;
        board.getBoard()[bishop4.getCurrRow()][bishop4.getCurrCol()] = bishop4;

        Assertions.assertEquals(6, bishop1.getMoves().size());
        Assertions.assertEquals(6, bishop2.getMoves().size());
        Assertions.assertEquals(6, bishop3.getMoves().size());
        Assertions.assertEquals(6, bishop4.getMoves().size());
    }

    @Test
    @DisplayName("Blocked test")
    void bishop_blocked_tests_1(){
        Bishop bishop = new Bishop('B', 'W', 0, 0, 1, 1);
        Pawn pawn1 = new Pawn('P', 'W', 6, 6, 0, 0);
        Pawn pawn2 = new Pawn('P', 'W', 6, 6, 2, 2);
        Pawn pawn3 = new Pawn('P', 'W', 6, 6, 2, 0);
        Pawn pawn4 = new Pawn('P', 'W', 6, 6, 0, 2);

        board.getBoard()[bishop.getCurrRow()][bishop.getCurrCol()] = bishop;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;

        Assertions.assertEquals(0, bishop.getMoves().size());
    }

    @Test
    void bishop_blocked_tests_2(){
        Bishop bishop = new Bishop('B', 'W', 0, 0, 4, 1);
        Pawn pawn1 = new Pawn('P', 'W', 6, 6, 5, 0);
        Pawn pawn2 = new Pawn('P', 'W', 6, 6, 5, 2);

        board.getBoard()[bishop.getCurrRow()][bishop.getCurrCol()] = bishop;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;

        Assertions.assertEquals(5, bishop.getMoves().size());
    }

    @Test
    @DisplayName("Take test")
    void bishop_take_test(){
        Bishop whiteBishop = new Bishop('B', 'W', 0, 0, 0, 2);
        Bishop blackBishop = new Bishop('B', 'B', 0, 0, 6, 6);
        Pawn whitePawn1 = new Pawn('P', 'W', 0, 0, 5, 5);
        Pawn whitePawn2 = new Pawn('P', 'W', 0, 0, 5, 7);
        Pawn whitePawn3 = new Pawn('P', 'W', 0, 0, 7, 5);
        Pawn whitePawn4 = new Pawn('P', 'W', 0, 0, 7, 7);
        Pawn blackPawn1 = new Pawn('P', 'B', 0, 0, 2, 0);
        Pawn blackPawn2 = new Pawn('P', 'B', 0, 0, 3, 5);

        board.getBoard()[whiteBishop.getCurrRow()][whiteBishop.getCurrCol()] = whiteBishop;
        board.getBoard()[blackBishop.getCurrRow()][blackBishop.getCurrCol()] = blackBishop;
        board.getBoard()[whitePawn1.getCurrRow()][whitePawn1.getCurrCol()] = whitePawn1;
        board.getBoard()[whitePawn2.getCurrRow()][whitePawn2.getCurrCol()] = whitePawn2;
        board.getBoard()[whitePawn3.getCurrRow()][whitePawn3.getCurrCol()] = whitePawn3;
        board.getBoard()[whitePawn4.getCurrRow()][whitePawn4.getCurrCol()] = whitePawn4;
        board.getBoard()[blackPawn1.getCurrRow()][blackPawn1.getCurrCol()] = blackPawn1;
        board.getBoard()[blackPawn2.getCurrRow()][blackPawn2.getCurrCol()] = blackPawn2;

        Assertions.assertEquals(5, whiteBishop.getMoves().size());
        Assertions.assertEquals(4, blackBishop.getMoves().size());
    }
}