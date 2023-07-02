package Engine2;

import javax.swing.*;

public class GameWindow {

    public GameWindow(GamePanel gamePanel){
        JFrame jframe = new JFrame();
        jframe.setSize(400, 400);
        jframe.add(gamePanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        // set visible needs to at the bottom to avoid graphic bugs
        jframe.setVisible(true);
    }


}
