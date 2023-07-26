package engine.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actors.constants.ActorTypes;
import spritesManager.SpritesManager;
import utils.Checkbox;
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

    public DefaultActor(ActorTypes actorType, Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath, DimensionVector<Integer> dim) {
        this.actorType = actorType;
        this.position = position;
        System.out.println("DEFAULT ACTORL: ");
        System.out.println(checkboxArray);
        this.checkboxArray = checkboxArray;
        this.dim = dim;
        this.texture = SpritesManager.loadSprite(texturePath);
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
