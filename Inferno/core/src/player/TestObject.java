package player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import spritesManager.SpritesManager;
import utils.Checkbox;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class TestObject {
    TextureRegion txt;
    public ArrayList<Checkbox> checkboxArrayList = new ArrayList<>();

    public TestObject() {
        checkboxArrayList.add(new Checkbox("test", new Vector<>(400, 400), new DimensionVector<>(400, 400)));

        txt = SpritesManager.test();
    }

    public void draw(SpriteBatch sb) {
        sb.draw(txt, 400, 400, 400, 400);
    }
}
