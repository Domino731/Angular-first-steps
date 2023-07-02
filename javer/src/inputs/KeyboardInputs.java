package javer.src.inputs;

import javer.src.GamePanel;
import javer.src.utils.Constants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;

    // constructor
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
                gamePanel.getEngine().getPlayer().setUp(true);
                gamePanel.getEngine().getPlayerClass().setUp(true);
                break;
            case KeyEvent.VK_S:
                gamePanel.getEngine().getPlayer().setDown(true);
                gamePanel.getEngine().getPlayerClass().setDown(true);
                break;
            case KeyEvent.VK_A:
                gamePanel.getEngine().getPlayer().setLeft(true);
                gamePanel.getEngine().getPlayerClass().setLeft(true);
                break;
            case KeyEvent.VK_D:
                gamePanel.getEngine().getPlayer().setRight(true);
                gamePanel.getEngine().getPlayerClass().setRight(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.getEngine().getPlayer().setUp(false);
                gamePanel.getEngine().getPlayerClass().setUp(false);
                break;
            case KeyEvent.VK_S:
                gamePanel.getEngine().getPlayer().setDown(false);
                gamePanel.getEngine().getPlayerClass().setDown(false);
                break;
            case KeyEvent.VK_A:
                gamePanel.getEngine().getPlayer().setLeft(false);
                gamePanel.getEngine().getPlayerClass().setLeft(false);
                break;
            case KeyEvent.VK_D:
                gamePanel.getEngine().getPlayer().setRight(false);
                gamePanel.getEngine().getPlayerClass().setRight(false);
                break;
        }
    }
}
