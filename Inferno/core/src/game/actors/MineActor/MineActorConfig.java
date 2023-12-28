package game.actors.MineActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import engine.fonts.actionCollision.ActionCollisionUtils;
import engine.fonts.actionCollision.ActionTypes;
import engine.items.DropItemData;
import engine.objectConfig.ObjectConfig;
import utils.vectors.DimensionCordVector;

import java.util.ArrayList;

public class MineActorConfig extends ObjectConfig {
    private final TextureRegion txt;
    private final ActionTypes actionType;
    private final DimensionCordVector groundCollision;
    private final DimensionCordVector actionCollision;
    private final ArrayList<DropItemData> drop;

    public MineActorConfig(String id, String type, String name, JsonNode specs) {
        super(id, type, name, specs);
        actionType = ActionCollisionUtils.getActionTypeFromJson(specs.get("action").asText());
        txt = MineActorUtils.createTexture(specs.get("texture"));
        drop = MineActorUtils.createDrop(specs.get("drop"));
        groundCollision = MineActorUtils.createGroundCollision(specs.get("ground_collision"));
        actionCollision = MineActorUtils.createActionCollision(specs.get("action_collision"));
    }

    public DimensionCordVector getGroundCollision() {
        return new DimensionCordVector(groundCollision.width, groundCollision.height, groundCollision.x, groundCollision.y);
    }

    public DimensionCordVector getActionCollision(int positionX, int positionY) {
        return new DimensionCordVector(actionCollision.width, actionCollision.height, positionX + actionCollision.x, positionY + actionCollision.y);
    }

    public ActionTypes getActionType() {
        return actionType;
    }

    public TextureRegion getTxt() {
        return txt;
    }

    public ArrayList<DropItemData> getDrop() {
        return drop;
    }
}
