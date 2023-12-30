package game.actors.TreeActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import engine.items.DropItemData;
import utils.CollisionData;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Json.readFile;

public class TreeConfigManager {
    private static final HashMap<String, TreeConfig> allTrees = createData();

    private static HashMap<String, TreeConfig> createData() {
        HashMap<String, TreeConfig> payload = new HashMap<>();

        TreeConfig oakTree = createActorConfig(Urls.CONFIG_TREE_OAK_NEW);
        payload.put(oakTree.getId(), oakTree);
        TreeConfig mapleTree = createActorConfig(Urls.CONFIG_TREE_MAPLE_NEW);
        payload.put(mapleTree.getId(), mapleTree);
        TreeConfig pineTree = createActorConfig(Urls.CONFIG_TREE_PINE_NEW);
        payload.put(pineTree.getId(), pineTree);
        TreeConfig mahoganyTree = createActorConfig(Urls.CONFIG_TREE_MAHOGANY_NEW);
        payload.put(mahoganyTree.getId(), mahoganyTree);
        TreeConfig mushroomTree = createActorConfig(Urls.CONFIG_TREE_MUSHROOM_NEW);
        payload.put(mushroomTree.getId(), mushroomTree);
        TreeConfig palmSmallTree = createActorConfig(Urls.CONFIG_TREE_PALM_SMALL_NEW);
        payload.put(palmSmallTree.getId(), palmSmallTree);
        TreeConfig palmMediumTree = createActorConfig(Urls.CONFIG_TREE_PALM_MEDIUM_NEW);
        payload.put(palmMediumTree.getId(), palmMediumTree);
        // TODO: remove crops
        // MISSING: tulip
        TreeConfig blueJazz = createActorConfig("objects/crops/blue_jazz.json");
        payload.put(blueJazz.getId(), blueJazz);
        TreeConfig blueJazz2 = createActorConfig("objects/crops/coffee_bean.json");
        payload.put(blueJazz2.getId(), blueJazz2);
        TreeConfig blueJazz3 = createActorConfig("objects/crops/garlic.json");
        payload.put(blueJazz3.getId(), blueJazz3);
        TreeConfig blueJazz4 = createActorConfig("objects/crops/green_bean.json");
        payload.put(blueJazz4.getId(), blueJazz4);
        TreeConfig blueJazz5 = createActorConfig("objects/crops/kale.json");
        payload.put(blueJazz5.getId(), blueJazz5);
        TreeConfig blueJazz6 = createActorConfig("objects/crops/parsnip.json");
        payload.put(blueJazz6.getId(), blueJazz6);
        TreeConfig blueJazz7 = createActorConfig("objects/crops/potato.json");
        payload.put(blueJazz7.getId(), blueJazz7);
        TreeConfig blueJazz8 = createActorConfig("objects/crops/rhubarb.json");
        payload.put(blueJazz8.getId(), blueJazz8);
        TreeConfig blueJazz9 = createActorConfig("objects/crops/strawberry.json");
        payload.put(blueJazz9.getId(), blueJazz9);
        TreeConfig blueJazz10 = createActorConfig("objects/crops/unmilled_rice.json");
        payload.put(blueJazz10.getId(), blueJazz10);
        TreeConfig blueJazz11 = createActorConfig("objects/crops/blueberry.json");
        payload.put(blueJazz11.getId(), blueJazz11);
        TreeConfig blueJazz12 = createActorConfig("objects/crops/corn.json");
        payload.put(blueJazz12.getId(), blueJazz12);
        TreeConfig blueJazz13 = createActorConfig("objects/crops/hops.json");
        payload.put(blueJazz13.getId(), blueJazz13);
        TreeConfig blueJazz14 = createActorConfig("objects/crops/hot_pepper.json");
        payload.put(blueJazz14.getId(), blueJazz14);
        TreeConfig blueJazz15 = createActorConfig("objects/crops/melon.json");
        payload.put(blueJazz15.getId(), blueJazz15);
        return payload;
    }

    private static TreeConfig createActorConfig(String configSource) {
        JsonNode node = readFile(configSource);
        JsonNode trunkNode = node.get("specs").get("trunk");

        String id = node.get("id").asText();
        String name = node.get("name").asText();
        TreeStageConfig[] stages = createActorStages(node.get("specs").get("stages"));
        System.out.println("configSource: " + configSource + " " + stages.length);
        int trunkX = trunkNode.get("x").asInt();
        int trunkY = trunkNode.get("y").asInt();
        int trunkWidth = trunkNode.get("width").asInt();
        int trunkHeight = trunkNode.get("height").asInt();
        TextureRegion trunkTxt = createTexture(trunkX, trunkY, trunkWidth, trunkHeight);

        // TODO: replace trunkNode with real specs
        return new TreeConfig(id, "TREE", name, trunkNode, stages, trunkTxt);
    }

    private static TreeStageConfig[] createActorStages(JsonNode stages) {
        byte stagesAmount = (byte) (stages.isArray() ? stages.size() : 1);
        TreeStageConfig[] payload = new TreeStageConfig[stagesAmount];

        if (stages.isArray()) {
            int index = 0;
            for (JsonNode node : stages) {
                int width = node.get("width").asInt();
                int height = node.get("height").asInt();
                int x = node.get("x").asInt();
                int y = node.get("y").asInt();
                int nextStage = node.get("next_stage").asInt();
                CollisionData groundCollisionData = new CollisionData(node.get("ground_collision"));
                CollisionData actionCollisionData = new CollisionData(node.get("action_collision"));
                TextureRegion texture = createTexture(x, y, width, height);
                // TODO: temporary for crops
                if (node.get("name") != null) {
                    texture = new TextureRegion(Textures.cropsSprite, x, y, width, height);
                }

                TreeStageConfig stageConfig = new TreeStageConfig((byte) ((byte) index + 1), texture, width, height, nextStage, actionCollisionData, groundCollisionData, new ArrayList<DropItemData>());
                payload[index] = stageConfig;
                index++;
            }
        }

        return payload;
    }


    private static TextureRegion createTexture(int x, int y, int width, int height) {
        return new TextureRegion(Textures.treesSprite, x, y, width, height);
    }

    public static TreeConfig get(String treeId) {
        return allTrees.get(treeId);
    }
}
