package Mino;

import java.awt.*;

public class Block extends Rectangle {
    public int x, y;
    public static final int SIZE = 30;
    public Color blockColor;

    public Block(Color blockColor){
        this.blockColor = blockColor;
    }

    public void draw(Graphics2D blockGraphics){
        final int MARGIN = 2;
        blockGraphics.setColor(blockColor);
        blockGraphics.fillRect(x + MARGIN, y + MARGIN, SIZE - (2 * MARGIN), SIZE - (2 * MARGIN));
    }
}
