package Main;
// Draws the play area
// Manages Tetrominoes
// handles gameplay actions such as deleting lines, adding scores, etc.
//

import Mino.*;
import java.awt.*;
import java.util.ArrayList;
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
    Mino NextMino;
    final int NEXT_MINO_X;
    final int NEXT_MINO_Y;
    public static ArrayList<Block> staticBlocks = new ArrayList<Block>();

    public static int dropInterval = 60; // mino drops every 60 frames (1 second)

    public PlayManager(){
        // Main play Area frame
        left_x = (GamePanel.WIDTH/2) - (WIDTH/2); // (1280/2) - (360/2) = 460
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = top_y +  Block.SIZE;

        NEXT_MINO_X = right_x + 175;
        NEXT_MINO_Y = top_y + 500;

        NextMino = pickMino();
        NextMino.setXY(NEXT_MINO_X, NEXT_MINO_Y);

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
        if(!currentMino.active){
            staticBlocks.add(currentMino.block[0]);
            staticBlocks.add(currentMino.block[1]);
            staticBlocks.add(currentMino.block[2]);
            staticBlocks.add(currentMino.block[3]);

            currentMino.deactivating = false;

            currentMino = NextMino;
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            NextMino = pickMino();
            NextMino.setXY(NEXT_MINO_X, NEXT_MINO_Y);

            checkDelete();

        }else{
            currentMino.update();
        }
    }

    private void checkDelete(){
        int x = left_x;
        int y = top_y;
        int blockCount = 0;

        while(x < right_x && y < bottom_y){
            for (int i = 0; i < staticBlocks.size(); i++) {
                if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y){
                    blockCount++;
                }
            }
            x += Block.SIZE;

            if(x == right_x){
                if(blockCount == 12){
                    for (int i = staticBlocks.size() - 1; i > -1 ; i--) {
                        if (staticBlocks.get(i).y == y){
                            staticBlocks.remove(i);
                        }
                    }

                    for (int i = 0; i < staticBlocks.size(); i++) {
                        if (staticBlocks.get(i).y < y){
                            staticBlocks.get(i).y += Block.SIZE;
                        }
                    }
                }
                blockCount = 0;
                x = left_x;
                y += Block.SIZE;
            }
        }
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

        // draw next mino
        NextMino.draw(graphics);

        // draw static blocks
        for (Block staticBlock : staticBlocks) {
            staticBlock.draw(graphics);
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
