package Mino;

import java.awt.*;

public class Mino_T extends Mino{
    public Mino_T(){
        create(Color.magenta);
    }

    @Override
    public void setXY(int x, int y) {
        block[0].x = x;
        block[0].y = y;
        block[1].x = block[0].x;
        block[1].y = block[0].y - Block.SIZE;
        block[2].x = block[0].x - Block.SIZE;
        block[2].y = block[0].y;
        block[3].x = block[0].x + Block.SIZE;
        block[3].y = block[0].y;
    }

    @Override
    public void getDirection1() {
        tempB[0].x = block[0].x;
        tempB[0].y = block[0].y;
        tempB[1].x = block[0].x;
        tempB[1].y = block[0].y - Block.SIZE;
        tempB[2].x = block[0].x - Block.SIZE;
        tempB[2].y = block[0].y;
        tempB[3].x = block[0].x + Block.SIZE;
        tempB[3].y = block[0].y;

        updateXY(1);
    }

    @Override
    public void getDirection2() {
        tempB[0].x = block[0].x;
        tempB[0].y = block[0].y;
        tempB[1].x = block[0].x + Block.SIZE;
        tempB[1].y = block[0].y;
        tempB[2].x = block[0].x;
        tempB[2].y = block[0].y - Block.SIZE;
        tempB[3].x = block[0].x;
        tempB[3].y = block[0].y + Block.SIZE;

        updateXY(2);
    }

    @Override
    public void getDirection3() {
        tempB[0].x = block[0].x;
        tempB[0].y = block[0].y;
        tempB[1].x = block[0].x;
        tempB[1].y = block[0].y + Block.SIZE;
        tempB[2].x = block[0].x + Block.SIZE;
        tempB[2].y = block[0].y;
        tempB[3].x = block[0].x - Block.SIZE;
        tempB[3].y = block[0].y;

        updateXY(3);

    }

    @Override
    public void getDirection4() {
        tempB[0].x = block[0].x;
        tempB[0].y = block[0].y;
        tempB[1].x = block[0].x - Block.SIZE;
        tempB[1].y = block[0].y;
        tempB[2].x = block[0].x;
        tempB[2].y = block[0].y + Block.SIZE;
        tempB[3].x = block[0].x;
        tempB[3].y = block[0].y - Block.SIZE;

        updateXY(4);

    }
}
