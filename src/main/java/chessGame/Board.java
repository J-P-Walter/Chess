package chessGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
    private static Board instance = null;

    private char[][] board;
    public Piece[] pieces = new Piece[32];


    private Board(){
        board = new char[8][8];
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
        System.out.println(pieces.length);
        placePieces();
        printBoard();
    }

    private void setup() throws FileNotFoundException {
        File file = new File("data/ChessSetup.txt");
        try{
            Scanner sc = new Scanner(file);
            int idx = 0;
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] piece = line.split(", ");

                switch(piece[0]){
                    case "P":
                        Pawn p = new Pawn(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        pieces[idx] = p;
                        break;
                    case "R":
                        Rook r = new Rook(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        pieces[idx] = r;
                        break;
                    case "N":
                        Knight n = new Knight(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        pieces[idx] = n;
                        break;
                    case "B":
                        Bishop b = new Bishop(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        pieces[idx] = b;
                        break;
                    case "Q":
                        Queen q = new Queen(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        pieces[idx] = q;
                        break;
                    case "K":
                        King k = new King(piece[0].charAt(0), piece[1].charAt(0), Integer.parseInt(piece[2]),
                                Integer.parseInt(piece[3]), Integer.parseInt(piece[2]), Integer.parseInt(piece[3]));
                        pieces[idx] = k;
                        break;
                }
                idx += 1;
            }
        } catch (FileNotFoundException e){
            System.err.println("Error: file not found");
            e.printStackTrace();
        }
    }
    public char[][] getBoard() {
        return board;
    }

    public void resetBoard(){
        board = new char[8][8];
        pieces = new Piece[32];
    }

    public void placePieces(){
       for (Piece p : pieces){
           if (p != null) {
               board[p.getCurrRow()][p.getCurrCol()] = p.getName();
           }
       }
    }

    public void printBoard(){
        for (char[]row : board){
            for (char col : row){
                if (col == 0){
                    System.out.print('-');
                }
                else {
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }

}

