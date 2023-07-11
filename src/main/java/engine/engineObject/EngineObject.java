package engine.engineObject;

import engine.utils.vectors.Vector2i;
import engine.utils.vectors.Vector2s;

import java.awt.*;

public abstract class EngineObject implements EngineObjectInterface {
    private Vector2i cords;
    private Vector2s size;
    private String name;

    public EngineObject(String name, Vector2i cords, Vector2s size){
         this.name = name;
         this.cords = cords;
         this.size = size;
    }

    public void render(Graphics g) {

    }
}
