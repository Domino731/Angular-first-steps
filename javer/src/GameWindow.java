package javer.src;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

// window which is responsible for game content
public class GameWindow {
    private JFrame jFrame;
    public GameWindow(int width, int height, GamePanel gamePanel){
          jFrame = new JFrame();

          jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          jFrame.add(gamePanel);
          jFrame.setLocationRelativeTo(null);
          jFrame.setResizable(false);
          jFrame.pack();
          jFrame.setVisible(true);
          jFrame.addWindowFocusListener(new WindowFocusListener() {
              @Override
              public void windowGainedFocus(WindowEvent e) {
              }

              @Override
              public void windowLostFocus(WindowEvent e) {
                  gamePanel.getEngine().windowFocusLost();
              }
          });

          System.out.println("Game window created " + width + " x " + height);
    }
}
