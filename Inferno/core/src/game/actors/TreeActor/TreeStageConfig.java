package game.actors.TreeActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.fonts.actionCollision.ActionCollision;
import engine.fonts.actionCollision.ActionTypes;
import engine.items.DropItemData;
import utils.Action;
import utils.CollisionData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;


public class TreeStageConfig {
    private final byte stage;
    private final TextureRegion txt;
    private final int width;
    private final int height;
    private final int nextStage;
    private final CollisionData actionCollision;
    private final CollisionData groundCollision;
    private final ArrayList<DropItemData> drop;

    public TreeStageConfig(byte stage, TextureRegion txt, int width, int height, int nextStage, CollisionData actionCollision, CollisionData groundCollision, ArrayList<DropItemData> drop) {
        this.stage = stage;
        this.width = width;
        this.height = height;
        this.txt = txt;
        this.nextStage = nextStage;
        this.drop = drop;
        this.actionCollision = actionCollision;
        this.groundCollision = groundCollision;
    }

    public byte getStage() {
        return stage;
    }

    public TextureRegion getTxt() {
        return txt;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public DimensionCordVector getGroundCollision() {
        return new DimensionCordVector(groundCollision);
    }

    public ActionCollision getActionCollision(Action rscAction, String actorId, Vector<Integer> actorPosition) {
        Vector<Integer> position = new Vector<>(actionCollision.x + actorPosition.x, actionCollision.y + actorPosition.y);
        DimensionVector<Integer> dimension = new DimensionVector<>((int) actionCollision.width, (int) actionCollision.height);
        return new ActionCollision(ActionTypes.CUT_TREE, actorId, position, dimension, new Vector<>(0, 0), rscAction);
    }

    public int getNextStage() {
        return nextStage;
    }

    public ArrayList<DropItemData> getDrop() {
        return drop;
    }
}
