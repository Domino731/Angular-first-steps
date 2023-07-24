package engine.actors.movableDefaultActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.Checkbox;
import utils.vectors.Vector;

import java.util.ArrayList;

public class MovableDefaultActor extends DefaultActor {
    protected boolean isMoving = false, isAttacking = false;
    protected boolean left, up, right, down;
    protected int speed = 1;
    private TextureRegion[][] textureRegions;

    public MovableDefaultActor(Vector<Integer> position, ArrayList<Checkbox> checkboxArray, String texturePath) {
        super(ActorTypes.DYNAMIC, position, checkboxArray, texturePath);
    }
}
