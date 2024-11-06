package Main;
// Draws the play area
// Manages Tetrominoes
// handles gameplay actions such as deleting lines, adding scores, etc.
//

import java.awt.*;

public class PlayManager {
    // main play area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int right_x;
    public static int left_x;
    public static int top_y;
    public static int bottom_y;

    public PlayManager(){
        // Main play Area frame
        left_x = (GamePanel.WIDTH/2) - (WIDTH/2); // (1280/2) - (360/2) = 460
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;
    }

    public void update(){

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
    }

}