package javer.src.engine;

import java.awt.*;

public class EngineGraphic {
    // positions
    int posX, posY;
    // size
    int width, height;

    public EngineGraphic(int posX, int posY, int width, int height){
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        System.out.println("EngineGraphic created");
    }

    // render object
    public void render(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(posX, posY, width, height);
    }
}
