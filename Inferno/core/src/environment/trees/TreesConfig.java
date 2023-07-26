package environment.trees;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.JsonNode;
import sprites.SpritesConfig;
import utils.EngineLog;
import utils.Json;
import utils.vectors.Vector2s;

import java.io.IOException;
import java.util.HashMap;


public class TreesConfig {
    public static HashMap<String, Config> trees = setData();

    private static class Config {
        public String id;
        public String name;
        public String spriteSrc;
        public Vector2s position;
        public Short hp;
        public String description;

        // TODO trees: add tools and checkboxes
        public Config(String id, String name, String spriteSrc, Vector2s position, Short hp, String description) {
            this.id = id;
            this.name = name;
            this.spriteSrc = spriteSrc;
            this.position = SpritesConfig.calculateObjectPosition(spriteSrc, position);
            this.hp = hp;
            this.description = description;
        }

    }

    private static HashMap<String, Config> setData() {
        HashMap<String, Config> trees = new HashMap<>();
        try {
            FileHandle fileHandle = Gdx.files.internal("config/trees.json");
            if (fileHandle.exists()) {
                JsonNode treesData = Json.parse(fileHandle.readString());
                if (treesData.isArray()) {
                    for (JsonNode tree : treesData) {
                        Vector2s position = new Vector2s(
                                tree.get("sprite").get("position").get("x").shortValue(),
                                tree.get("sprite").get("position").get("y").shortValue()
                        );

                        trees.put(tree.get("id").asText(), new Config(
                                tree.get("id").asText(),
                                tree.get("name").asText(),
                                tree.get("sprite").get("src").asText(),
                                position,
                                tree.get("hp").shortValue(),
                                tree.get("description").asText()
                        ));
                    }
                }
            }
        } catch (IOException e) {
            EngineLog.resourceError("/config/sprites.json");
        }
        return trees;
    }
}