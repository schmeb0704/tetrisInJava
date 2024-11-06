package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame("Simple Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        //add game panel
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
