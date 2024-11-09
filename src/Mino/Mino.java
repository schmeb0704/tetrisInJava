package Mino;

import Main.KeyHandler;
import Main.PlayManager;

import java.awt.*;

public class Mino {
    public Block block[] = new Block[4];
    public Block tempB[] = new Block[4];
    int autoDropCounter = 0;
    public int direction = 1;
    boolean leftCollision, rightCollision, bottomCollision;
    public boolean active = true;
    public boolean deactivating;
    private int deactivateCounter = 0;

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
    public void getDirection1(){}
    public void getDirection2(){}
    public void getDirection3(){}
    public void getDirection4(){}
    public void checkMovementCollision(){
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        // check if mino blocks collide with static blocks
        checkStaticBlockCollision();


        // check left collision
        for(int i = 0; i < block.length; i++){
            if(block[i].x == PlayManager.left_x){
                leftCollision = true;
            }
        }
        // check right collision
        for(int i = 0; i < block.length; i++){
            if(block[i].x + Block.SIZE == PlayManager.right_x){
                rightCollision = true;
            }
        }
        // check bottom collision
        for(int i = 0; i < block.length; i++){
            if(block[i].y + Block.SIZE == PlayManager.bottom_y){
                bottomCollision = true;
            }
        }
    }
    public void checkRotationCollision(){
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        // check if mino blocks collide with static blocks
        checkStaticBlockCollision();


        // check left collision
        for(int i = 0; i < block.length; i++){
            if(tempB[i].x < PlayManager.left_x){
                leftCollision = true;
            }
        }
        // check right collision
        for(int i = 0; i < block.length; i++){
            if(tempB[i].x + Block.SIZE >  PlayManager.right_x){
                rightCollision = true;
            }
        }
        // check bottom collision
        for(int i = 0; i < block.length; i++){
            if(tempB[i].y + Block.SIZE > PlayManager.bottom_y){
                bottomCollision = true;
            }
        }

    }
    private void checkStaticBlockCollision(){

        for(Block staticBlock : PlayManager.staticBlocks){
            int target_x = staticBlock.x;
            int target_y = staticBlock.y;

            // check bottom collision
            for (Block value : block) {
                if (value.y + Block.SIZE == target_y && value.x == target_x) {
                    bottomCollision = true;
                }
            }

            for (Block value : block) {
                if (value.x - Block.SIZE == target_x && value.y == target_y) {
                    leftCollision = true;
                }
            }

            for (Block value : block) {
                if (value.x + Block.SIZE == target_x && value.y == target_y) {
                    rightCollision = true;
                }
            }
        }

    }
    public void updateXY(int direction){
        checkRotationCollision();
        if(!leftCollision && !rightCollision && !bottomCollision){
            this.direction = direction;
            block[0].x = tempB[0].x;
            block[0].y = tempB[0].y;
            block[1].x = tempB[1].x;
            block[1].y = tempB[1].y;
            block[2].x = tempB[2].x;
            block[2].y = tempB[2].y;
            block[3].x = tempB[3].x;
            block[3].y = tempB[3].y;
        }
    }
    public void  update(){
        if(deactivating){
            deactivating();
        }
        if(KeyHandler.upPressed){
            switch (direction){
                case 1: getDirection2();break;
                case 2: getDirection3();break;
                case 3: getDirection4();break;
                case 4: getDirection1();break;
            }
            KeyHandler.upPressed = false;
        }

        checkMovementCollision();

        if(KeyHandler.downPressed){
            if(bottomCollision == false){
                block[0].y += Block.SIZE;
                block[1].y += Block.SIZE;
                block[2].y += Block.SIZE;
                block[3].y += Block.SIZE;

                autoDropCounter = 0;
            }
            KeyHandler.downPressed = false;
        }

        if(KeyHandler.leftPressed){
            if(leftCollision == false){
                block[0].x -= Block.SIZE;
                block[1].x -= Block.SIZE;
                block[2].x -= Block.SIZE;
                block[3].x -= Block.SIZE;

                autoDropCounter = 0;
            }
            KeyHandler.leftPressed = false;
        }

        if(KeyHandler.rightPressed){
            if(rightCollision == false){
                block[0].x += Block.SIZE;
                block[1].x += Block.SIZE;
                block[2].x += Block.SIZE;
                block[3].x += Block.SIZE;

                autoDropCounter = 0;
            }
            KeyHandler.rightPressed = false;
        }

        if(bottomCollision){
            deactivating = true;
        }else {
            autoDropCounter++;// when counter increases, mino goes down on block height

            if(autoDropCounter == PlayManager.dropInterval){
                block[0].y += Block.SIZE;
                block[1].y += Block.SIZE;
                block[2].y += Block.SIZE;
                block[3].y += Block.SIZE;
                autoDropCounter = 0;
            }

        }
    }
    private void deactivating(){
        deactivateCounter++;

        if(deactivateCounter == 45){
            deactivateCounter = 0;
            checkMovementCollision();

            if(bottomCollision){
                active = false;
            }
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
