package chessGame;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class PawnTest {
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
    @DisplayName("Testing moving forward, not first move, unimpeded")
    void pawn_move_forward_once_unimpeded(){
        Pawn whitePawn = new Pawn('P', 'W', 6, 4, 5, 4);
        Pawn blackPawn = new Pawn('P', 'B', 1, 3, 3, 3);
        board.getBoard()[whitePawn.getCurrRow()][whitePawn.getCurrCol()] = whitePawn;
        board.getBoard()[blackPawn.getCurrRow()][blackPawn.getCurrCol()] = blackPawn;
//        board.printBoard();
//        System.out.println("\n");

        ArrayList<ArrayList<Integer>> whiteMoves = new ArrayList<>();
        whiteMoves.add(new ArrayList<>() {
            {
                add(4);
                add(4);
            }
        });

        ArrayList<ArrayList<Integer>> blackMoves = new ArrayList<>();
        blackMoves.add(new ArrayList<>() {
            {
                add(4);
                add(3);
            }
        });

        Assertions.assertEquals(whiteMoves.get(0), whitePawn.getMoves().get(0));
        Assertions.assertEquals(blackMoves.get(0), blackPawn.getMoves().get(0));
    }

    @Test
    @DisplayName("Testing blocked moving forward")
    void pawn_move_forward_impeded(){
        Pawn whitePawn = new Pawn('P', 'W', 6, 4, 5, 4);
        Pawn blackPawn = new Pawn('P', 'B', 2, 4, 4, 4);
        board.getBoard()[whitePawn.getCurrRow()][whitePawn.getCurrCol()] = whitePawn;
        board.getBoard()[blackPawn.getCurrRow()][blackPawn.getCurrCol()] = blackPawn;
//        board.printBoard();
//        System.out.println("\n");

        Assertions.assertTrue(whitePawn.getMoves().isEmpty());
        Assertions.assertTrue(blackPawn.getMoves().isEmpty());
    }

    @Test
    @DisplayName("Testing first move forward two squares, unimpeded")
    void pawn_move_two(){
        Pawn whitePawn = new Pawn('P', 'W', 6, 6, 6, 6);
        Pawn blackPawn = new Pawn('P', 'B', 1, 2, 1, 2);
        Pawn whiteBlockerPawn = new Pawn('P', 'W', 6, 5, 3, 2);
        board.getBoard()[whitePawn.getCurrRow()][whitePawn.getCurrCol()] = whitePawn;
        board.getBoard()[blackPawn.getCurrRow()][blackPawn.getCurrCol()] = blackPawn;
        board.getBoard()[whiteBlockerPawn.getCurrRow()][whiteBlockerPawn.getCurrCol()] = whiteBlockerPawn;


        Assertions.assertEquals(2, whitePawn.getMoves().size());
        Assertions.assertTrue(whitePawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(5);
                add(6);
            }
        }));
        Assertions.assertTrue(whitePawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(4);
                add(6);
            }
        }));

        Assertions.assertEquals(1, blackPawn.getMoves().size());
        Assertions.assertTrue(blackPawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(2);
                add(2);
            }
        }));
    }

    @Test
    @DisplayName("Testing attacking left and right for pawns")
    void pawn_take(){
        Pawn whitePawn = new Pawn('P', 'W', 6, 5, 5, 5);
        Pawn blackPawn = new Pawn('P', 'B', 2, 4, 4, 4);
        board.getBoard()[whitePawn.getCurrRow()][whitePawn.getCurrCol()] = whitePawn;
        board.getBoard()[blackPawn.getCurrRow()][blackPawn.getCurrCol()] = blackPawn;
//        board.printBoard();
//        System.out.println("\n");

        Assertions.assertEquals(2, whitePawn.getMoves().size());
        Assertions.assertTrue(whitePawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(4);
                add(4);
            }
        }));
        Assertions.assertTrue(whitePawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(4);
                add(5);
            }
        }));

        Assertions.assertEquals(2, blackPawn.getMoves().size());
        Assertions.assertTrue(blackPawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(5);
                add(5);
            }
        }));
        Assertions.assertTrue(blackPawn.getMoves().contains(new ArrayList<Integer>() {
            {
                add(5);
                add(4);
            }
        }));
    }

//    @Test
//    @DisplayName("Testing En passant")
//    void pawn_enPassant(){}
//
//    @Test
//    @DisplayName("Testing promotion")
//    void pawn_promotion(){}
}