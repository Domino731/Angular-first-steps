package engine.actors.groundItem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import utils.vectors.Vector;

import java.util.ArrayList;

public class GroundItem {
    private Vector<Integer> position;
    private TextureRegion txt;
    private ArrayList<Vector<Integer>> positions = new ArrayList<>();
    private int positionIndex = 0;
    private boolean isAvailableToPick = false;

    public GroundItem(int positionX, int positionY, TextureRegion txt) {
        position = new Vector<>(positionX, positionY);
        this.txt = txt;
        // f(x) = x2
        positions.add(new Vector<>(position.x - 3, position.y + 9));
        positions.add(new Vector<>(position.x - 2, position.y + 4));
        positions.add(new Vector<>(position.x - 1, position.y + 1));
        positions.add(new Vector<>(position.x + 0, position.y + 0));
        positions.add(new Vector<>(position.x + 1, position.y + 1));
        positions.add(new Vector<>(position.x + 2, position.y + 4));
        positions.add(new Vector<>(position.x + 3, position.y + 9));
    }

    public void update() {
        if (positionIndex < positions.size() - 1) {
            positionIndex++;
            position = positions.get(positionIndex);
        } else {
            isAvailableToPick = true;
        }
    }

    public void draw(SpriteBatch sb) {
        sb.draw(txt, position.x, position.y, GroundItemConstants.size, GroundItemConstants.size);
    }
}
