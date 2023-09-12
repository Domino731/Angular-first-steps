package engine.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import utils.Json;

import java.util.HashMap;

public class Items {
    private static JsonNode configFileResources = Json.readFile(Urls.CONFIG_RESOURCE_ITEMS);
    private static HashMap<String, Config> data = createData();

    public static class Config {
        private TextureRegion txt;
        private String id;
        private String name;

        public Config(String id, TextureRegion txt, String name) {

        }
    }

    public static Config getData(String itemId) {
        return data.get(itemId);
    }

    private static HashMap<String, Config> createData() {
        HashMap<String, Config> payload = new HashMap<>();

        if (configFileResources.isArray()) {
            for (JsonNode node : configFileResources) {
                String id = node.get("id").asText();
                String name = node.get("name").asText();
                String spriteName = node.get("sprite_name").asText();
                int x = node.get("sprite_cords").get("x").asInt();
                int y = node.get("sprite_cords").get("y").asInt();
                TextureRegion txt = createTxt(spriteName, x, y);
                payload.put(id, new Config(id, txt, name));
            }
        }

        return payload;
    }

    private static TextureRegion createTxt(String itemSpriteSheet, int x, int y) {
        return new TextureRegion(Textures.debrisTxt, x, y);
    }

}
