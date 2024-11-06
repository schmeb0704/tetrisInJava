package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static final int WIDTH = 1260;
    public static final int HEIGHT = 720;

    public GamePanel(){
        //panel settings
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);
    }


}
