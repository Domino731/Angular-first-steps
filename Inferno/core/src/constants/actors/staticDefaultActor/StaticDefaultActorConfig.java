package constants.actors.staticDefaultActor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;

import java.util.HashMap;

import static utils.Json.readFile;

public class StaticDefaultActorConfig {
    private static final HashMap<String, Config> data = getData();

    public static final class Config {
        private final String id;
        private final String name;
        private final TextureRegion txt;

        public Config(String id, String name, TextureRegion txt) {
            this.id = id;
            this.name = name;
            this.txt = txt;
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
                Config config = new Config(id, name, txt);
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
