package sokoban;

import javax.swing.JFrame;


public final class Sokoban extends JFrame {

    private final int OFFSET = 30;
    static level Wevel = new level();
    
    

    public Sokoban() {
        
        InitUI();
    }

    public void InitUI() {
        
        Board board = new Board();
        add(board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
    }


    public static void main(String[] args) {
        Wevel.setLevel(7);
        Sokoban sokoban = new Sokoban();
        sokoban.setVisible(true);
        
    }
}