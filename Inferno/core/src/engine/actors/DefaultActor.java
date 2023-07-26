package engine.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actors.constants.ActorTypes;
import spritesManager.SpritesManager;
import utils.Checkbox;
import utils.strings.StringUtils;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public abstract class DefaultActor {
    protected Vector<Integer> position = null;
    protected ArrayList<Checkbox> checkboxArray = null;
    protected boolean isCollision = false;
    protected Texture texture;
    protected ActorTypes actorType;
    protected DimensionVector<Integer> dim;
    private String id = StringUtils.generateRandomId();

    public DefaultActor(ActorTypes actorType, Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath, DimensionVector<Integer> dim) {
        this.actorType = actorType;
        this.position = position;
        this.checkboxArray = checkboxArray;
        this.dim = dim;
        this.texture = SpritesManager.loadSprite(texturePath);
    }

    public DefaultActor(ActorTypes actorType, Vector<Integer> position, String texturePath, DimensionVector<Integer> dim, ArrayList<DimensionCordVector> arrayList) {
        this.actorType = actorType;
        this.position = position;
        this.checkboxArray = createCheckboxList(arrayList);
        this.dim = dim;
        this.texture = SpritesManager.loadSprite(texturePath);
    }

    private ArrayList<Checkbox> createCheckboxList(ArrayList<DimensionCordVector> arrayList) {
        ArrayList<Checkbox> payload = new ArrayList<>();
        for (DimensionCordVector vector : arrayList) {
            payload.add(new Checkbox(id, new Vector<>(vector.x, vector.y), new DimensionVector<>(vector.width, vector.height)));
        }
        return payload;
    }

    // setters
    protected void setPosition(Vector<Integer> position) {
        this.position = position;
    }

    public void setIsCollision(boolean v) {
        this.isCollision = v;
    }

    // getters
    protected Vector<Integer> getPosition() {
        return position;
    }


    public ArrayList<Checkbox> getCheckboxArray() {
        return checkboxArray;
    }

    public void draw(SpriteBatch sb) {
    }

}
