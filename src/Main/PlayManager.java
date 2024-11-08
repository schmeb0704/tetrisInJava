package Main;
// Draws the play area
// Manages Tetrominoes
// handles gameplay actions such as deleting lines, adding scores, etc.
//

import Mino.*;
import java.awt.*;
import java.util.Random;

public class PlayManager {
    // main play area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int right_x;
    public static int left_x;
    public static int top_y;
    public static int bottom_y;

    //Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    public static int dropInterval = 60; // mino drops every 60 frames (1 second)

    public PlayManager(){
        // Main play Area frame
        left_x = (GamePanel.WIDTH/2) - (WIDTH/2); // (1280/2) - (360/2) = 460
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = top_y +  Block.SIZE;

        // Set starting Mino
        currentMino = pickMino();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }

    private Mino pickMino(){
        // generate random Mino
        Mino mino = null;
        int i = new Random().nextInt(7);
        mino = switch (i) {
            case 0 -> new Mino_L();
            case 1 -> new Mino_L_Reverse();
            case 2 -> new Mino_Square();
            case 3 -> new Mino_Line_Piece();
            case 4 -> new Mino_T();
            case 5 -> new Mino_Squiggly();
            case 6 -> new Mino_Squiggly_Reverse();
            default -> mino;
        };
        return mino;
    }

    public void update(){
        currentMino.update();
    }

    public void draw(Graphics2D graphics){
        // Draw Play area

        graphics.setColor(Color.white);
        graphics.setStroke(new BasicStroke(4f));
        graphics.drawRect(left_x-4, top_y-4, WIDTH+8, HEIGHT+8);

        // Draw waiting area for next shapes
        int x = right_x + 100;
        int y = bottom_y - 200;
        graphics.drawRect(x, y, 200, 200);
        graphics.setFont(new Font("Arial", Font.PLAIN, 30));
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("NEXT", x+60, y+60);

        //draw currentMino
        if(currentMino != null){
            currentMino.draw(graphics);
        }

        // draw paused text
        graphics.setColor(Color.yellow);
        graphics.setFont(graphics.getFont().deriveFont(50f));
        if(KeyHandler.pausePressed){
            x = left_x + 70;
            y = top_y + 320;
            graphics.drawString("PAUSED", x, y);
        }
    }

}
