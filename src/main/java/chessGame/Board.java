package chessGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
    private static Board instance = null;
    private Piece[][] board;

    private Board(){
        board = new Piece[8][8];
    }
    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        };
        return instance;
    }

    public void initialize() {
        try{
            setup();
        } catch (FileNotFoundException e){
            System.err.println("Error: file not found");
            e.printStackTrace();
        }
        printBoard();
    }

    private void setup() throws FileNotFoundException {
        File file = new File("data/ChessSetup.txt");
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] piece = line.split(", ");

                switch(piece[0]) {
                    case "P":
                        Pawn p = new Pawn(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[p.startRow][p.startCol] = p;
                        break;
                    case "R":
                        Rook r = new Rook(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[r.startRow][r.startCol] = r;
                        break;
                    case "N":
                        Knight n = new Knight(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[n.startRow][n.startCol] = n;
                        break;
                    case "B":
                        Bishop b = new Bishop(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[b.startRow][b.startCol] = b;
                        break;
                    case "Q":
                        Queen q = new Queen(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[q.startRow][q.startCol] = q;
                        break;
                    case "K":
                        King k = new King(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[k.startRow][k.startCol] = k;
                        break;
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("Error: file not found");
            e.printStackTrace();
        }
    }
    // Overloaded method to make more complicated tests easier
    private void setUp(String fileName){
        File file = new File(fileName);
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] piece = line.split(", ");

                switch(piece[0]) {
                    case "P":
                        Pawn p = new Pawn(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[p.startRow][p.startCol] = p;
                        break;
                    case "R":
                        Rook r = new Rook(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[r.startRow][r.startCol] = r;
                        break;
                    case "N":
                        Knight n = new Knight(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[n.startRow][n.startCol] = n;
                        break;
                    case "B":
                        Bishop b = new Bishop(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[b.startRow][b.startCol] = b;
                        break;
                    case "Q":
                        Queen q = new Queen(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[q.startRow][q.startCol] = q;
                        break;
                    case "K":
                        King k = new King(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        board[k.startRow][k.startCol] = k;
                        break;
                }
            }
        } catch (FileNotFoundException e){
            System.err.println("Error: file not found");
            e.printStackTrace();
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void resetBoard() throws FileNotFoundException {
        board = new Piece[8][8];
//        setup();
    }

    public void printBoard(){
        for (Piece[] row : board){
            for (Piece p : row){
                if (p == null){
                    System.out.print('-');
                }
                else {
                    System.out.print(p.getName());
                }
            }
            System.out.println();
        }
    }

}

