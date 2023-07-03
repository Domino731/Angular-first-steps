package engine.inputs;

import engine.EnginePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private EnginePanel enginePanel;

    public KeyboardInputs(EnginePanel enginePanel) {
        this.enginePanel = enginePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                enginePanel.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_A:
                enginePanel.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
                enginePanel.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
                enginePanel.getGame().getPlayer().setRight(false);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                enginePanel.getGame().getPlayer().setUp(true);
                break;
            case KeyEvent.VK_A:
                enginePanel.getGame().getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_S:
                enginePanel.getGame().getPlayer().setDown(true);
                break;
            case KeyEvent.VK_D:
                enginePanel.getGame().getPlayer().setRight(true);
                break;
        }
    }
}
