package objects.entities.player;

import java.awt.*;

public class Player {
    public Player(){

    }

    public void render(Graphics g){
        g.drawRect(10, 10, 10, 10);
        g.setColor(Color.RED);
    }
}
