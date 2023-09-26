package environment.trees;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import utils.Json;

import java.util.HashMap;

public class TreesConfig {
    private static HashMap<String, Config> trees = getTreesData();

    public static final class Stage {
        private final byte stage;
        private final TextureRegion txt;
        private final byte width;
        private final byte height;
        private final int nextStage;

        public Stage(byte stage, TextureRegion txt, byte width, byte height, int nextStage) {
            this.stage = stage;
            this.width = width;
            this.height = height;
            this.txt = txt;
            this.nextStage = nextStage;
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

        Config maple = readConfig(Urls.CONFIG_TREE_MAPLE);
        payload.put(maple.getId(), maple);

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
            payload[i] = new Stage((byte) i, txt, width, height, nextStage);
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
