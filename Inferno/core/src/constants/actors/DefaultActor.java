package constants.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.constants.ActorTypes;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.actorsManager.GameTime;
import engine.actionCollision.actorsManager.GameTimeNewMinute;
import spritesManager.SpritesManager;
import utils.Checkbox;
import utils.strings.StringUtils;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public abstract class DefaultActor {
    protected Vector<Integer> position = null;
    private Vector<Integer> mapPosition;
    protected ArrayList<Checkbox> checkboxArray = null;
    protected Checkbox groundCheckbox;
    protected boolean isCollision = false;
    protected Texture texture;
    protected ActorTypes actorType;
    protected DimensionVector<Integer> dim;
    protected ArrayList<ActionCollision> actionCollisions = new ArrayList<>();
    protected int hp = 0;
    private ArrayList<GameTimeNewMinute> minuteActions = new ArrayList<>();

    protected final String id = StringUtils.generateRandomId();

    public DefaultActor(ActorTypes actorType, int positionX, int positionY, String texturePath, DimensionVector<Integer> dim, ArrayList<DimensionCordVector> arrayList, DimensionCordVector dimCordVector) {
        this.actorType = actorType;
        this.position = new Vector<>(positionX * 16, positionY * 16);
        this.mapPosition = new Vector<>(positionX, positionY);
        this.checkboxArray = createCheckboxList(arrayList);
        this.dim = dim;
        if (texturePath != null) {
            this.texture = SpritesManager.loadSprite(texturePath);
        }

        this.groundCheckbox = new Checkbox(id, new Vector<>(position.x + dimCordVector.x, position.y + dimCordVector.y), new DimensionVector<>(dimCordVector.width, dimCordVector.height));
    }

    public void setDim(DimensionVector<Integer> dim) {
        this.dim = new DimensionVector<>(dim.width, dim.height);
    }

    public Vector<Integer> getMapPosition() {
        return mapPosition;
    }

    public DefaultActor(ActorTypes actorType, int positionX, int positionY) {
        this.actorType = actorType;
        this.position = new Vector<>(positionX * 16, positionY * 16);
        this.mapPosition = new Vector<>(positionX, positionY);
    }

    protected void addMinuteAction(GameTimeNewMinute gameTimeNewMinute) {
        minuteActions.add(gameTimeNewMinute);
    }

    public ArrayList<GameTimeNewMinute> getMinuteActions() {
        return minuteActions;
    }

    protected void setGroundCheckbox(DimensionCordVector vector) {
        this.groundCheckbox = new Checkbox(id, new Vector<>(position.x + vector.x, position.y + vector.y), new DimensionVector<>(vector.width, vector.height));
    }

    protected Checkbox getGroundCheckboxTest(DimensionCordVector vector) {
        return new Checkbox(id, new Vector<>(position.x + vector.x, position.y + vector.y), new DimensionVector<>(vector.width, vector.height));
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
