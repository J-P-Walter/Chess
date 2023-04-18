package chessGame;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
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
    @DisplayName("Center of board")
    void knight_center_test(){
        Knight knight = new Knight('N', 'W', 7, 2, 4, 4);

        board.getBoard()[knight.getCurrRow()][knight.getCurrCol()] = knight;

        Assertions.assertEquals(8, knight.getMoves().size());
        Assertions.assertTrue(knight.getMoves().contains(new ArrayList<Integer>() {
            {
                add(2);
                add(3);
            }
        }));
        Assertions.assertTrue(knight.getMoves().contains(new ArrayList<Integer>() {
            {
                add(6);
                add(5);
            }
        }));
    }

    @Test
    @DisplayName("Edge tests")
    void knight_edge_test(){
        Knight knight1 = new Knight('N', 'W', 0, 0, 0, 4);
        Knight knight2 = new Knight('N', 'W', 0, 0, 7, 5);
        Knight knight3 = new Knight('N', 'W', 0, 0, 3, 0);
        Knight knight4 = new Knight('N', 'W', 0, 0, 4, 7);

        board.getBoard()[knight1.getCurrRow()][knight1.getCurrCol()] = knight1;
        board.getBoard()[knight2.getCurrRow()][knight2.getCurrCol()] = knight2;
        board.getBoard()[knight3.getCurrRow()][knight3.getCurrCol()] = knight3;
        board.getBoard()[knight4.getCurrRow()][knight4.getCurrCol()] = knight4;

        Assertions.assertEquals(4, knight1.getMoves().size());
        Assertions.assertEquals(4, knight2.getMoves().size());
        Assertions.assertEquals(4, knight3.getMoves().size());
        Assertions.assertEquals(4, knight4.getMoves().size());
    }

    @Test
    @DisplayName("Corner test")
    void knight_corner_test() {
        Knight knight1 = new Knight('N', 'W', 0, 0, 0, 0);
        Knight knight2 = new Knight('N', 'W', 0, 0, 7, 0);
        Knight knight3 = new Knight('N', 'W', 0, 0, 0, 7);
        Knight knight4 = new Knight('N', 'W', 0, 0, 7, 7);

        board.getBoard()[knight1.getCurrRow()][knight1.getCurrCol()] = knight1;
        board.getBoard()[knight2.getCurrRow()][knight2.getCurrCol()] = knight2;
        board.getBoard()[knight3.getCurrRow()][knight3.getCurrCol()] = knight3;
        board.getBoard()[knight4.getCurrRow()][knight4.getCurrCol()] = knight4;

        Assertions.assertEquals(2, knight1.getMoves().size());
        Assertions.assertEquals(2, knight2.getMoves().size());
        Assertions.assertEquals(2, knight3.getMoves().size());
        Assertions.assertEquals(2, knight4.getMoves().size());
    }

    @Test
    @DisplayName("Blocked test")
    void knight_blocked_test(){
        Knight knight = new Knight('N', 'W', 0, 0, 4, 4);
        Pawn pawn1 = new Pawn('P', 'W', 6, 6, 2, 3);
        Pawn pawn2 = new Pawn('P', 'W', 6, 6, 2, 5);
        Pawn pawn3 = new Pawn('P', 'W', 6, 6, 5, 6);
        Pawn pawn4 = new Pawn('P', 'W', 6, 6, 6, 3);

        board.getBoard()[knight.getCurrRow()][knight.getCurrCol()] = knight;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;
        board.getBoard()[pawn3.getCurrRow()][pawn3.getCurrCol()] = pawn3;
        board.getBoard()[pawn4.getCurrRow()][pawn4.getCurrCol()] = pawn4;

        Assertions.assertEquals(4, knight.getMoves().size());
    }

    @Test
    @DisplayName("Take test")
    void knight_take_test(){
        Knight knight = new Knight('N', 'W', 7, 2, 4, 4);
        Pawn pawn1 = new Pawn('P', 'B', 6, 6, 3, 2);
        Pawn pawn2 = new Pawn('P', 'B', 6, 6, 6, 5);

        board.getBoard()[knight.getCurrRow()][knight.getCurrCol()] = knight;
        board.getBoard()[pawn1.getCurrRow()][pawn1.getCurrCol()] = pawn1;
        board.getBoard()[pawn2.getCurrRow()][pawn2.getCurrCol()] = pawn2;

        Assertions.assertEquals(8, knight.getMoves().size());

    }
}