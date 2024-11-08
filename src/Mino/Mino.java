package Mino;

import java.awt.*;

public class Mino {
    public Block block[] = new Block[4];
    public Block tempB[] = new Block[4];

    public void create(Color color){
        block[0] = new Block(color);
        block[1] = new Block(color);
        block[2] = new Block(color);
        block[3] = new Block(color);
        tempB[0] = new Block(color);
        tempB[1] = new Block(color);
        tempB[2] = new Block(color);
        tempB[3] = new Block(color);
    }

    public void setXY(int x, int y){}
    public void updateXY(int direction){}
    public void  update(){

    }
    public void  draw(Graphics2D minoGraphics){

        final int MARGIN = 2;
        minoGraphics.setColor(block[0].blockColor);
        minoGraphics.fillRect(block[0].x+MARGIN, block[0].y+MARGIN, Block.SIZE - (2* MARGIN), Block.SIZE -(2* MARGIN));
        minoGraphics.fillRect(block[1].x+MARGIN, block[1].y+MARGIN, Block.SIZE - (2* MARGIN), Block.SIZE -(2* MARGIN));
        minoGraphics.fillRect(block[2].x+MARGIN, block[2].y+MARGIN, Block.SIZE - (2* MARGIN), Block.SIZE -(2* MARGIN));
        minoGraphics.fillRect(block[3].x+MARGIN, block[3].y+MARGIN, Block.SIZE - (2* MARGIN), Block.SIZE -(2* MARGIN));
    }

}
