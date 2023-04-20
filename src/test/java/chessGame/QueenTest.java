package chessGame;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
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
    void queen_center_test(){
        Queen queen = new Queen('Q', 'W', 0, 0, 4, 4);

        board.getBoard()[queen.getCurrRow()][queen.getCurrCol()] = queen;

        Assertions.assertEquals(27, queen.getMoves().size());
    }

    @Test
    @DisplayName("Edge tests")
    void queen_edge_test(){
        Queen queen1 = new Queen('Q', 'W', 0, 0, 0, 3);
        Queen queen2 = new Queen('Q', 'W', 0, 0, 4, 0);
        Queen queen3 = new Queen('Q', 'W', 0, 0, 3, 7);
        Queen queen4 = new Queen('Q', 'W', 0, 0, 7, 4);

        board.getBoard()[queen1.getCurrRow()][queen1.getCurrCol()] = queen1;
        board.getBoard()[queen2.getCurrRow()][queen2.getCurrCol()] = queen2;
        board.getBoard()[queen3.getCurrRow()][queen3.getCurrCol()] = queen3;
        board.getBoard()[queen4.getCurrRow()][queen4.getCurrCol()] = queen4;


        Assertions.assertEquals(21, queen1.getMoves().size());
        Assertions.assertEquals(21, queen2.getMoves().size());
        Assertions.assertEquals(21, queen3.getMoves().size());
        Assertions.assertEquals(21, queen4.getMoves().size());
    }

    @Test
    @DisplayName("Corner test")
    void queen_corner_test(){
        Queen queen1 = new Queen('Q', 'W', 0, 0, 0, 0);
        Queen queen2 = new Queen('Q', 'W', 0, 0, 0, 7);
        Queen queen3 = new Queen('Q', 'W', 0, 0, 7, 0);
        Queen queen4 = new Queen('Q', 'W', 0, 0, 7, 7);

        board.getBoard()[queen1.getCurrRow()][queen1.getCurrCol()] = queen1;
        board.getBoard()[queen2.getCurrRow()][queen2.getCurrCol()] = queen2;
        board.getBoard()[queen3.getCurrRow()][queen3.getCurrCol()] = queen3;
        board.getBoard()[queen4.getCurrRow()][queen4.getCurrCol()] = queen4;


        Assertions.assertEquals(18, queen1.getMoves().size());
        Assertions.assertEquals(18, queen2.getMoves().size());
        Assertions.assertEquals(18, queen3.getMoves().size());
        Assertions.assertEquals(18, queen4.getMoves().size());
    }

    @Test
    @DisplayName("Blocked test")
    void queen_blocked_tests_1(){
        Queen queen = new Queen('Q', 'W', 0, 0, 3, 3);
        Pawn pawn1 = new Pawn('P', 'W', 0,0, 1, 3);
        Pawn pawn2 = new Pawn('P', 'W', 0,0, 1, 5);
        Pawn pawn3 = new Pawn('P', 'W', 0,0, 2, 2);
        Pawn pawn4 = new Pawn('P', 'W', 0,0, 3, 2);
        Pawn pawn5 = new Pawn('P', 'W', 0,0, 3, 6);
        Pawn pawn6 = new Pawn('P', 'W', 0,0, 6, 6);
        Pawn pawn7 = new Pawn('P', 'W', 0,0, 7, 3);

        board.getBoard()[queen.getCurrRow()][queen.getCurrCol()] = queen;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;
        board.getBoard()[pawn5.getCurrRow()][pawn5.getCurrCol()] = pawn5;
        board.getBoard()[pawn6.getCurrRow()][pawn6.getCurrCol()] = pawn6;
        board.getBoard()[pawn7.getCurrRow()][pawn7.getCurrCol()] = pawn7;

        Assertions.assertEquals(12, queen.getMoves().size());
    }

    @Test
    @DisplayName("Take test")
    void queen_take_test(){
        Queen queen = new Queen('Q', 'W', 0, 0, 3, 3);
        Pawn pawn1 = new Pawn('P', 'B', 0,0, 1, 3);
        Pawn pawn2 = new Pawn('P', 'B', 0,0, 1, 5);
        Pawn pawn3 = new Pawn('P', 'B', 0,0, 2, 2);
        Pawn pawn4 = new Pawn('P', 'B', 0,0, 3, 2);
        Pawn pawn5 = new Pawn('P', 'B', 0,0, 3, 6);
        Pawn pawn6 = new Pawn('P', 'B', 0,0, 6, 6);
        Pawn pawn7 = new Pawn('P', 'B', 0,0, 7, 3);

        board.getBoard()[queen.getCurrRow()][queen.getCurrCol()] = queen;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;
        board.getBoard()[pawn5.getCurrRow()][pawn5.getCurrCol()] = pawn5;
        board.getBoard()[pawn6.getCurrRow()][pawn6.getCurrCol()] = pawn6;
        board.getBoard()[pawn7.getCurrRow()][pawn7.getCurrCol()] = pawn7;

        Assertions.assertEquals(19, queen.getMoves().size());
    }
}