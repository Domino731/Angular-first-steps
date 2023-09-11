package engine.actors.groundItem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import utils.vectors.Vector;

public class GroundItem {
    private Vector<Integer> position;
    private TextureRegion txt;
    private int positionIndex = 0;
    private boolean isAvailableToPick = false;
    private int x; // Współrzędna X przedmiotu
    private int y; // Współrzędna Y przedmiotu
    private double vx; // Prędkość X przedmiotu
    private double vy; // Prędkość Y przedmiotu
    private double gravity; // Siła grawitacji działająca na przedmiot
    private boolean isOnGround; // Flaga określająca, czy przedmiot znajduje się na ziemi

    public GroundItem(int positionX, int positionY, TextureRegion txt) {
        position = new Vector<>(positionX, positionY);
        this.txt = txt;
        // f(x) = x2

        // NEW
        this.x = positionX;
        this.y = positionY;
        this.vx = 0; // Przyjmujemy, że początkowa prędkość X wynosi 0
        this.vy = 30;
        this.gravity = 5.0;
        this.isOnGround = false;
    }

    public void update(double deltaTime) {
        updatePosition(deltaTime);
    }

    public void draw(SpriteBatch sb) {
        System.out.println(x);
        System.out.println(y);
        sb.draw(txt, x, y, GroundItemConstants.size, GroundItemConstants.size);
    }


    public void updatePosition(double deltaTime) {
        if (!isOnGround) {
            vy += gravity * deltaTime;
            x += vx * deltaTime;
            y += vy * deltaTime;

            if (y <= 0) {
                y = 0;
                isOnGround = true;
                vy = 0;
            }
        }
    }
}
