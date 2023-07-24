package engine.actors;

import com.badlogic.gdx.graphics.Texture;
import engine.actors.constants.ActorTypes;
import spritesManager.SpritesManager;
import utils.Checkbox;
import utils.vectors.Vector;

import java.util.ArrayList;

public abstract class DefaultActor {
    protected Vector<Integer> position = null;
    protected ArrayList<Checkbox> checkboxArray = null;
    protected boolean isCollision = false;
    protected Texture texture;
    protected ActorTypes actorType;

    public DefaultActor(ActorTypes actorType, Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath) {
        this.actorType = actorType;
        this.position = position;
        this.checkboxArray = checkboxArray;
        this.texture = SpritesManager.loadSprite(texturePath);
    }

    // getters
    public Vector<Integer> getPosition() {
        return position;
    }

    public ArrayList<Checkbox> getCheckboxArray() {
        return checkboxArray;
    }

}
