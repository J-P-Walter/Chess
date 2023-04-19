package chessGame;


import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGame implements ActionListener {
    static Board board;

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private static final String COLS = "ABCDEFGH";

    private Color turn = Color.WHITE;

    public ChessGame() {
        board = Board.getInstance();
        board.initialize();
        initializeGui();
    }

    //Using modified version of https://stackoverflow.com/questions/21142686/making-a-robust-resizable-swing-chess-gui
    //For the gui
    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
//        JToolBar tools = new JToolBar();
//        tools.setFloatable(false);
//        gui.add(tools, BorderLayout.PAGE_START);

        chessBoard = new JPanel(new GridLayout(0, 9)) {
            /**
             * Override the preferred size to return the largest it can, in
             * a square shape.  Must (must, must) be added to a GridBagLayout
             * as the only component (it uses the parent as a guide to size)
             * with no GridBagConstaint (so it is centered).
             */
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
        ));
        // Set the BG to be ochre
        Color ochre = new Color(204,119,34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                b.setName(ii + " " + jj);
                if (board.getBoard()[ii][jj] != null){
                    b.setText(String.valueOf(board.getBoard()[ii][jj].getName()));
                    b.addActionListener(this);
                }
                if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                            SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        Player whitePlayer = new Player(Color.WHITE);
        Player blackPlayer = new Player(Color.BLACK);

        JFrame f = new JFrame("Chess");
        f.add(game.getGui());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setMinimumSize(f.getSize());
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] clicked = ((JButton) e.getSource()).getName().split(" ");

        if (board.getBoard()[Integer.parseInt(clicked[0])][Integer.parseInt(clicked[1])].getColor() == turn){
            System.out.println(board.getBoard()[Integer.parseInt(clicked[0])][Integer.parseInt(clicked[1])].getMoves());
        }
    }
}