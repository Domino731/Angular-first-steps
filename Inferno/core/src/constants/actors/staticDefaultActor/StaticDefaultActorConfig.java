package constants.actors.staticDefaultActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import utils.vectors.DimensionCordVector;

import java.util.HashMap;

import static utils.Json.readFile;

public class StaticDefaultActorConfig {
    private static final HashMap<String, Config> data = getData();

    public static final class Config {
        private final String id;
        private final String name;
        private final TextureRegion txt;
        private final short groundCheckboxWidth;
        private final short groundCheckboxHeight;
        private final short groundCheckboxX;
        private final short groundCheckboxY;

        public Config(String id, String name, TextureRegion txt, short groundCheckboxWidth, short groundCheckboxHeight, short groundCheckboxX, short groundCheckboxY) {
            this.id = id;
            this.name = name;
            this.txt = txt;
            this.groundCheckboxWidth = groundCheckboxWidth;
            this.groundCheckboxHeight = groundCheckboxHeight;
            this.groundCheckboxX = groundCheckboxX;
            this.groundCheckboxY = groundCheckboxY;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public TextureRegion getTxt() {
            return txt;
        }

        public DimensionCordVector getGroundDimensionVector() {
            return new DimensionCordVector(groundCheckboxWidth, groundCheckboxHeight, groundCheckboxX, groundCheckboxY);
        }
    }

    private static HashMap<String, Config> getData() {
        HashMap<String, Config> payload = new HashMap<>();

        JsonNode treesJson = readFile(Urls.CONFIG_STATIC_TREES);
        System.out.print(treesJson);
        if (treesJson.isArray()) {
            for (JsonNode node : treesJson) {
                String id = node.get("id").asText();
                String name = node.get("name").asText();
                int width = node.get("width").asInt();
                int height = node.get("height").asInt();
                int x = node.get("cords").get("x").asInt();
                int y = node.get("cords").get("y").asInt();
                TextureRegion txt = createTexture(x, y, width, height);
                short groundCheckboxWidth = (short) node.get("groundCheckbox").get("width").asInt();
                short groundCheckboxHeight = (short) node.get("groundCheckbox").get("height").asInt();
                short groundCheckboxX = (short) node.get("groundCheckbox").get("x").asInt();
                short groundCheckboxY = (short) node.get("groundCheckbox").get("y").asInt();
                Config config = new Config(id, name, txt, groundCheckboxWidth, groundCheckboxHeight, groundCheckboxX, groundCheckboxY);
                payload.put(id, config);
            }
        }

        return payload;
    }

    private static TextureRegion createTexture(int x, int y, int width, int height) {
        return new TextureRegion(Textures.treesSprite, x, y, width, height);
    }


    public static Config getData(String id) {
        return data.get(id);
    }
}
