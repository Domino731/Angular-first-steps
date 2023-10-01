package environment.trees;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import engine.items.DropItemData;
import engine.items.Items;
import utils.Json;
import utils.vectors.DimensionCordVector;

import java.util.ArrayList;
import java.util.HashMap;

public class TreesConfig {
    private static HashMap<String, Config> trees = getTreesData();

    public static final class Stage {
        private final byte stage;
        private final TextureRegion txt;
        private final byte width;
        private final byte height;
        private final int nextStage;
        private final String groundCheckboxId;
        private final String actionCollisionId;
        private final ArrayList<DropItemData> drop;

        public Stage(byte stage, TextureRegion txt, byte width, byte height, int nextStage, String groundCheckboxId, String actionCollisionId, ArrayList<DropItemData> drop) {
            this.stage = stage;
            this.width = width;
            this.height = height;
            this.txt = txt;
            this.nextStage = nextStage;
            this.groundCheckboxId = groundCheckboxId;
            this.actionCollisionId = actionCollisionId;
            this.drop = drop;
        }

        public byte getStage() {
            return stage;
        }

        public TextureRegion getTxt() {
            return txt;
        }

        public byte getWidth() {
            return width;
        }

        public byte getHeight() {
            return height;
        }

        public int getNextStage() {
            return nextStage;
        }

        public DimensionCordVector getGroundCheckbox() {
            return TreeUtils.getGroundCheckboxById(groundCheckboxId);
        }

        public String getActionCollisionId() {
            return actionCollisionId;
        }

        public ArrayList<DropItemData> getDrop() {
            return drop;
        }

    }

    public static final class Config {
        private final String id;
        private final String name;
        private final Stage[] stages;

        private final TextureRegion trunkTxt;

        public Config(String id, String name, Stage[] stages, TextureRegion trunkTxt) {
            this.id = id;
            this.name = name;
            this.stages = stages;
            this.trunkTxt = trunkTxt;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Stage[] getStages() {
            return stages;
        }

        public TextureRegion getTrunkTxt() {
            return trunkTxt;
        }
    }


    private static HashMap<String, Config> getTreesData() {
        HashMap<String, Config> payload = new HashMap<>();

        Config oak = readConfig(Urls.CONFIG_TREE_OAK);
        payload.put(oak.getId(), oak);
        Config maple = readConfig(Urls.CONFIG_TREE_MAPLE);
        payload.put(maple.getId(), maple);
        Config pine = readConfig(Urls.CONFIG_TREE_PINE);
        payload.put(pine.getId(), pine);
        Config mahagony = readConfig(Urls.CONFIG_TREE_MAHOGANY);
        payload.put(mahagony.getId(), mahagony);
        return payload;
    }


    private static Config readConfig(String url) {
        JsonNode jsonNode = Json.readFile(url);
        String id = jsonNode.get("id").asText();
        String name = jsonNode.get("name").asText();
        JsonNode stages = jsonNode.get("stages");
        int trunkX = jsonNode.get("trunkX").asInt();
        int trunkY = jsonNode.get("trunkY").asInt();
        byte trunkWidth = (byte) jsonNode.get("trunkWidth").asInt();
        byte trunkHeight = (byte) jsonNode.get("trunkHeight").asInt();
        TextureRegion trunkTxt = createTreeTexture(trunkX, trunkY, trunkWidth, trunkHeight);

        return new Config(id, name, createTreeStages(stages), trunkTxt);
    }

    private static Stage[] createTreeStages(JsonNode stages) {
        byte stagesAmount = (byte) (stages.isArray() ? stages.size() : 1);
        Stage[] payload = new Stage[stagesAmount];

        int i = 0;
        for (JsonNode node : stages) {
            byte width = (byte) node.get("width").asInt();
            byte height = (byte) node.get("height").asInt();
            int x = node.get("x").asInt();
            int y = node.get("y").asInt();
            TextureRegion txt = createTreeTexture(x, y, width, height);
            int nextStage = node.get("next_stage").asInt();
            String groundCheckboxId = node.get("groundCheckboxId").asText();
            String actionCollisionId = node.get("actionCollisionId").asText();
            JsonNode dropData = node.get("drop");

            ArrayList<DropItemData> drop = new ArrayList<>();
            if (dropData.isArray()) {
                for (JsonNode dropNode : dropData) {
                    String itemId = dropNode.get("id").asText();
                    TextureRegion itemTexture = Items.getData(itemId).getTxt();
                    drop.add(new DropItemData(itemId, itemTexture));
                }
            }


            payload[i] = new Stage((byte) i, txt, width, height, nextStage, groundCheckboxId, actionCollisionId, drop);
            i++;
        }

        return payload;
    }

    private static TextureRegion createTreeTexture(int x, int y, int width, int height) {
        System.out.println(x);
        System.out.print(y);
        System.out.print(width);
        System.out.print(height);
        return new TextureRegion(Textures.treesSprite, x, y, width, height);
    }


    public static Config getTreeConfig(String treeId) {
        return trees.get(treeId);
    }
}
