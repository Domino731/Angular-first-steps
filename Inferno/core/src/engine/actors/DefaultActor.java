package engine.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.actorsManager.GameTime;
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
    protected Checkbox groundCheckbox;
    protected boolean isCollision = false;
    protected Texture texture;
    protected ActorTypes actorType;
    protected DimensionVector<Integer> dim;
    protected ArrayList<ActionCollision> actionCollisions = new ArrayList<>();
    protected int hp = 0;

    protected final String id = StringUtils.generateRandomId();

    public DefaultActor(ActorTypes actorType, Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath, DimensionVector<Integer> dim, DimensionCordVector dimCordVector) {
        this.actorType = actorType;
        this.position = position;
        this.checkboxArray = checkboxArray;
        this.dim = dim;
        this.texture = SpritesManager.loadSprite(texturePath);
        this.groundCheckbox = new Checkbox(id, new Vector<>(position.x + dimCordVector.x, position.y + dimCordVector.y), new DimensionVector<>(dimCordVector.width, dimCordVector.height), new Vector<>(dimCordVector.x, dimCordVector.y));
    }

    public DefaultActor(ActorTypes actorType, Vector<Integer> position, String texturePath, DimensionVector<Integer> dim, ArrayList<DimensionCordVector> arrayList, DimensionCordVector dimCordVector) {
        this.actorType = actorType;
        this.position = position;
        this.checkboxArray = createCheckboxList(arrayList);
        this.dim = dim;
        if (texturePath != null) {
            this.texture = SpritesManager.loadSprite(texturePath);
        }

        this.groundCheckbox = new Checkbox(id, new Vector<>(position.x + dimCordVector.x, position.y + dimCordVector.y), new DimensionVector<>(dimCordVector.width, dimCordVector.height));
    }

    protected void setGroundCheckbox(DimensionCordVector vector) {
        this.groundCheckbox = new Checkbox(id, new Vector<>(position.x + vector.x, position.y + vector.y), new DimensionVector<>(vector.width, vector.height));
    }

    private ArrayList<Checkbox> createCheckboxList(ArrayList<DimensionCordVector> arrayList) {
        ArrayList<Checkbox> payload = new ArrayList<>();
        for (DimensionCordVector vector : arrayList) {
            payload.add(new Checkbox(id, new Vector<>(position.x + vector.x, position.y + vector.y), new DimensionVector<>(vector.width, vector.height), new Vector<Integer>(vector.x, vector.y)));
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

    public ArrayList<ActionCollision> getActionCollisions() {
        return actionCollisions;
    }

    public void update() {
    }

    public void update(float delta, GameTime gameTime) {
    }

    // getters
    public Vector<Integer> getPosition() {
        return position;
    }

    public DimensionVector<Integer> getDim() {
        return dim;
    }

    public ArrayList<Checkbox> getCheckboxArray() {
        return checkboxArray;
    }

    public Checkbox getGroundCheckbox() {
        return groundCheckbox;
    }

    public void draw(SpriteBatch sb) {
    }

}
