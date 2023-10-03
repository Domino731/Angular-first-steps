package constants.actors.EnvironmentActor;

import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import constants.actors.groundItem.GroundItem;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.actorsManager.ActorsManager;
import engine.utils.Draw;
import utils.vectors.Vector;

import java.util.ArrayList;

import static engine.utils.PositionUtils.convertTilePosition;

public class EnvironmentActor extends DefaultActor {
    private boolean isDestroyed = false;
    private Draw currentDraw;
    private final ActorsManager actorsManager;
    private ArrayList<GroundItem> items = new ArrayList<>();
    private ArrayList<ActionCollision> itemsCollisions = new ArrayList<>();
    private boolean isCollisionWithNextStage = false;

    public EnvironmentActor(Vector<Integer> position, ActorsManager actorsManager) {
        super(ActorTypes.DYNAMIC, convertTilePosition(position));
        this.actorsManager = actorsManager;
    }

}
