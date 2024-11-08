package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public static boolean upPressed, downPressed, rightPressed, leftPressed, pausePressed;
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP){
            upPressed = true;
        } else if(keyCode == KeyEvent.VK_DOWN){
            downPressed = true;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (keyCode == KeyEvent.VK_CONTROL) {
            pausePressed = !pausePressed;
        }
    }
    public void keyReleased(KeyEvent e){}
}
