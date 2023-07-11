package engine.engineObject;

import engine.utils.vectors.Vector2i;
import engine.utils.vectors.Vector2s;

import java.awt.*;

public interface EngineObjectInterface {
    Vector2i cords = null;
    Vector2s size = null;
    String name = null;

    public void render(Graphics g);
}
