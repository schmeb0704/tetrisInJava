package Mino;

import Main.KeyHandler;
import Main.PlayManager;

import java.awt.*;

public class Mino {
    public Block block[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;

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
        if(KeyHandler.downPressed){
            block[0].y += Block.SIZE;
            block[1].y += Block.SIZE;
            block[2].y += Block.SIZE;
            block[3].y += Block.SIZE;

            autoDropCounter = 0;
            KeyHandler.downPressed = false;
        }

        if(KeyHandler.leftPressed){

            block[0].x -= Block.SIZE;
            block[1].x -= Block.SIZE;
            block[2].x -= Block.SIZE;
            block[3].x -= Block.SIZE;

            autoDropCounter = 0;
            KeyHandler.leftPressed = false;
        }

        if(KeyHandler.rightPressed){

            block[0].x += Block.SIZE;
            block[1].x += Block.SIZE;
            block[2].x += Block.SIZE;
            block[3].x += Block.SIZE;

            autoDropCounter = 0;
            KeyHandler.rightPressed = false;
        }
        autoDropCounter++;// when counter increases, mino goes down on block height

        if(autoDropCounter == PlayManager.dropInterval){
            block[0].y += Block.SIZE;
            block[1].y += Block.SIZE;
            block[2].y += Block.SIZE;
            block[3].y += Block.SIZE;
            autoDropCounter = 0;
        }

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
