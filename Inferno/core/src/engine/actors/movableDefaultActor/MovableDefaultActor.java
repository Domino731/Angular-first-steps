package engine.actors.movableDefaultActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.actors.utils.ActorDirection;
import game.entities.player.PlayerTextures;
import utils.Checkbox;
import utils.TextureData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class MovableDefaultActor extends DefaultActor {
    protected boolean isMoving = false;
    protected ActorDirection direction = new ActorDirection();
    protected byte speed = 1;
    private TextureRegion[][] textureRegions;
    private TextureData textureData;
    protected int aniTick, aniIndex, aniSpeed = 20;
    public Vector<Integer> finalPosition;
    protected int actionIndex;
    protected PlayerTextures playerTextures = new PlayerTextures();
    private String lastDir = "";

    public MovableDefaultActor(int positionX, int positionY, ArrayList<Checkbox> checkboxArray, String texturePath, TextureData textureData, DimensionVector<Integer> dim, DimensionCordVector groundCheckbox) {
        super(ActorTypes.DYNAMIC, new Vector(positionX, positionY), checkboxArray, texturePath, dim, groundCheckbox);
        this.textureData = textureData;
        this.finalPosition = new Vector<>(positionX, positionY);
    }

    public void resetPosition() {
        position.x = finalPosition.x;
        position.y = finalPosition.y;
        checkboxArray.get(0).position.x = finalPosition.x;
        checkboxArray.get(0).position.y = finalPosition.y;
        groundCheckbox.position.x = finalPosition.x + groundCheckbox.absolutePosition.x;
        groundCheckbox.position.y = finalPosition.y + groundCheckbox.absolutePosition.y;
    }

    /**
     * set aniTack & aniIndex to 0
     */
    protected void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    // setters
    public void setRight(boolean v) {
        direction.right = v;
    }

    public void setLeft(boolean v) {
        direction.left = v;
    }

    public void setTop(boolean v) {
        direction.top = v;
    }

    public void setBot(boolean v) {
        direction.bot = v;
    }


}
