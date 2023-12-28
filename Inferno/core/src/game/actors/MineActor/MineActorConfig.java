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
        txt = MineActorConfigsManager.createTexture(specs.get("texture"));
        actionType = ActionCollisionUtils.getActionTypeFromJson(specs.get("action").asText());
        groundCollision = MineActorConfigsManager.createGroundCollision(specs.get("ground_collision"));
        actionCollision = MineActorConfigsManager.createActionCollision(specs.get("action_collision"));
        drop = MineActorConfigsManager.createDrop(specs.get("drop"));
    }

    public DimensionCordVector getGroundCollision() {
        return groundCollision;
    }

    public DimensionCordVector getActionCollision() {
        return actionCollision;
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
