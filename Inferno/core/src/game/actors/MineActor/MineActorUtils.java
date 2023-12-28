package game.actors.MineActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import engine.Textures;
import engine.items.DropItemData;
import engine.items.Items;
import utils.vectors.DimensionCordVector;

import java.util.ArrayList;

public class MineActorUtils {
    public static TextureRegion createTexture(JsonNode textureNode) {
        int width = textureNode.get("width").asInt();
        int height = textureNode.get("height").asInt();
        int x = textureNode.get("x").asInt();
        int y = textureNode.get("y").asInt();
        return new TextureRegion(Textures.minesTxt, x, y, width, height);
    }

    public static DimensionCordVector createGroundCollision(JsonNode groundCollisionNode) {
        int width = groundCollisionNode.get("width").asInt();
        int height = groundCollisionNode.get("height").asInt();
        int x = groundCollisionNode.get("x").asInt();
        int y = groundCollisionNode.get("y").asInt();
        return new DimensionCordVector(width, height, x, y);
    }

    public static DimensionCordVector createActionCollision(JsonNode actionCollisionNode) {
        int width = actionCollisionNode.get("width").asInt();
        int height = actionCollisionNode.get("height").asInt();
        int x = actionCollisionNode.get("x").asInt();
        int y = actionCollisionNode.get("y").asInt();
        return new DimensionCordVector(width, height, x, y);
    }


    public static ArrayList<DropItemData> createDrop(JsonNode dropNode) {
        ArrayList<DropItemData> drop = new ArrayList<>();
        if (dropNode.isArray()) {
            for (JsonNode node : dropNode) {
                String itemId = node.get("id").asText();
                TextureRegion itemTexture = Items.getData(itemId).getTxt();
                drop.add(new DropItemData(itemId, itemTexture));
            }
        }
        return drop;
    }
}
