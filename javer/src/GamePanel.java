package javer.src;

import javer.src.inputs.KeyboardInputs;
import javer.src.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private Engine engine;

    public GamePanel(Engine engine){
        this.engine = engine;
        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        System.out.println("GamePanel created");
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        engine.render(g);
    }

    private void setPanelSize(){
        Dimension size = new Dimension(Engine.GAME_WIDTH, Engine.GAME_HEIGHT);
        setPreferredSize( size);
    }

    public Engine getEngine(){
        return engine;
    }
}
