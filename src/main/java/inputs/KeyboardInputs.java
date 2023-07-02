package inputs;

import Engine2.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                System.out.println('W');
                this.gamePanel.changeYDelta(-5);
                break;
            case KeyEvent.VK_S:
                System.out.println('S');
                this.gamePanel.changeYDelta(-5);

                break;
            case KeyEvent.VK_A:
                System.out.println('A');
                this.gamePanel.changeXDelta(5);
                break;
            case KeyEvent.VK_D:
                System.out.println('D');
                this.gamePanel.changeXDelta(5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
//                gamePanel.getEngine().getPlayer().setUp(false);
//                gamePanel.getEngine().getPlayerClass().setUp(false);
                break;
            case KeyEvent.VK_S:
//                gamePanel.getEngine().getPlayer().setDown(false);
//                gamePanel.getEngine().getPlayerClass().setDown(false);
                break;
            case KeyEvent.VK_A:
//                gamePanel.getEngine().getPlayer().setLeft(false);
//                gamePanel.getEngine().getPlayerClass().setLeft(false);
                break;
            case KeyEvent.VK_D:
//                gamePanel.getEngine().getPlayer().setRight(false);
//                gamePanel.getEngine().getPlayerClass().setRight(false);
                break;
        }
    }
}