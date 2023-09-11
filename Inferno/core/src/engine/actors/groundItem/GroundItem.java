package engine.actors.groundItem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import utils.vectors.Vector;

public class GroundItem {
    private Vector<Integer> position;
    private TextureRegion txt;

    public GroundItem(int positionX, int positionY, TextureRegion txt) {
        position = new Vector<>(positionX, positionY);
        this.txt = txt;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(txt, position.x, position.y, GroundItemConstants.size, GroundItemConstants.size);
    }
}
