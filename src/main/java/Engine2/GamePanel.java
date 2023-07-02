package Engine2;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int xDelta = 0, yDelta = 0;

    public GamePanel(){
        MouseInputs mouseInputs = new MouseInputs();
       addKeyListener(new KeyboardInputs(this));
       addMouseListener(mouseInputs);
       addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value){
        this.xDelta += value;
//        System.out.println("repaint");
        repaint();
    }
    public void changeYDelta(int value){
        this.yDelta += value;
//        System.out.println("repaint");
        repaint();
    }

    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.drawRect(10 + xDelta, 10 + yDelta, 100, 100);
       g.setColor(Color.RED);
    }
}
