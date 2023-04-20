package chessGame;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
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
    void king_center_test(){
        King king = new King('K', 'W', 7, 2, 4, 4);

        board.getBoard()[king.getCurrRow()][king.getCurrCol()] = king;

        Assertions.assertEquals(8, king.getMoves().size());
        Assertions.assertTrue(king.getMoves().contains(new ArrayList<Integer>() {
            {
                add(3);
                add(3);
            }
        }));
        Assertions.assertTrue(king.getMoves().contains(new ArrayList<Integer>() {
            {
                add(5);
                add(4);
            }
        }));
    }

    @Test
    @DisplayName("Edge tests")
    void king_edge_test(){
        King king1 = new King('K', 'W', 0, 0, 0, 4);
        King king2 = new King('K', 'W', 0, 0, 7, 5);
        King king3 = new King('K', 'W', 0, 0, 3, 0);
        King king4 = new King('K', 'W', 0, 0, 4, 7);

        board.getBoard()[king1.getCurrRow()][king1.getCurrCol()] = king1;
        board.getBoard()[king2.getCurrRow()][king2.getCurrCol()] = king2;
        board.getBoard()[king3.getCurrRow()][king3.getCurrCol()] = king3;
        board.getBoard()[king4.getCurrRow()][king4.getCurrCol()] = king4;

        Assertions.assertEquals(5, king1.getMoves().size());
        Assertions.assertEquals(5, king2.getMoves().size());
        Assertions.assertEquals(5, king3.getMoves().size());
        Assertions.assertEquals(5, king4.getMoves().size());
    }

    @Test
    @DisplayName("Corner test")
    void king_corner_test() {
        King king1 = new King('K', 'W', 0, 0, 0, 0);
        King king2 = new King('K', 'W', 0, 0, 7, 0);
        King king3 = new King('K', 'W', 0, 0, 0, 7);
        King king4 = new King('K', 'W', 0, 0, 7, 7);

        board.getBoard()[king1.getCurrRow()][king1.getCurrCol()] = king1;
        board.getBoard()[king2.getCurrRow()][king2.getCurrCol()] = king2;
        board.getBoard()[king3.getCurrRow()][king3.getCurrCol()] = king3;
        board.getBoard()[king4.getCurrRow()][king4.getCurrCol()] = king4;

        Assertions.assertEquals(3, king1.getMoves().size());
        Assertions.assertEquals(3, king2.getMoves().size());
        Assertions.assertEquals(3, king3.getMoves().size());
        Assertions.assertEquals(3, king4.getMoves().size());
    }

    @Test
    @DisplayName("Blocked test")
    void king_blocked_test(){
        King king = new King('K', 'W', 0, 0, 4, 4);
        Pawn pawn1 = new Pawn('P', 'W', 6, 6, 3, 3);
        Pawn pawn2 = new Pawn('P', 'W', 6, 6, 3, 4);
        Pawn pawn3 = new Pawn('P', 'W', 6, 6, 5, 4);
        Pawn pawn4 = new Pawn('P', 'W', 6, 6, 5, 5);

        board.getBoard()[king.getCurrRow()][king.getCurrCol()] = king;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;

        Assertions.assertEquals(4, king.getMoves().size());
    }

    @Test
    @DisplayName("Take test")
    void king_take_test(){
        King king = new King('K', 'W', 0, 0, 4, 4);
        Pawn pawn1 = new Pawn('P', 'B', 6, 6, 3, 3);
        Pawn pawn2 = new Pawn('P', 'B', 6, 6, 3, 4);
        Pawn pawn3 = new Pawn('P', 'B', 6, 6, 5, 4);
        Pawn pawn4 = new Pawn('P', 'B', 6, 6, 5, 5);

        board.getBoard()[king.getCurrRow()][king.getCurrCol()] = king;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;

        Assertions.assertEquals(8, king.getMoves().size());

    }
}