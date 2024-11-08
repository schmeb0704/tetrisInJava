package Mino;

import java.awt.*;

public class Mino_Square extends Mino {
    public Mino_Square(){
        create(Color.YELLOW);
    }

    @Override
    public void setXY(int x, int y) {
        block[0].x = x;
        block[0].y = y;
        block[1].x = block[0].x;
        block[1].y = block[0].y + Block.SIZE ;
        block[2].x = block[0].x + Block.SIZE;
        block[2].y = block[0].y;
        block[3].x = block[0].x + Block.SIZE;
        block[3].y = block[0].y + Block.SIZE;
    }

}
