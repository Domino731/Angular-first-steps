package game.actors.MineActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import engine.items.DropItemData;
import engine.items.Items;
import utils.vectors.DimensionCordVector;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static utils.Json.readFile;

public class MineActorConfigsManager {
    private static HashMap<String, MineActorConfig> allMines = createData();

    private static HashMap<String, MineActorConfig> createData() {
        HashMap<String, MineActorConfig> payload = new HashMap<>();
        // TODO before release: make this pathname dynamic, because on different pc's it can behaviour in different ways
        File folder = new File("C:\\Users\\Dominik\\Desktop\\projects\\pixi\\Inferno\\assets\\objects\\mines");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filePath = Urls.DIR_ACTORS_MINES + file.getName();
                MineActorConfig mineActorConfig = createMineActor(readFile(filePath));
                payload.put(mineActorConfig.getId(), mineActorConfig);
            }
        }
        return payload;
    }

    private static MineActorConfig createMineActor(JsonNode node) {
        String id = node.get("id").asText();
        String name = node.get("name").asText();
        JsonNode specs = node.get("specs");
        return new MineActorConfig(id, "MINE", name, specs);
    }

    // TODO move to utils
    public static TextureRegion createTexture(JsonNode textureNode) {
        int width = textureNode.get("width").asInt();
        int height = textureNode.get("height").asInt();
        int x = textureNode.get("x").asInt();
        int y = textureNode.get("y").asInt();
        return new TextureRegion(Textures.minesTxt, width, height, x, y);
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

    public static MineActorConfig get(String actorId) {
        return allMines.get(actorId);
    }

}
