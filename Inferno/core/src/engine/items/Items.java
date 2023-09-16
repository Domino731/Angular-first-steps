package engine.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import utils.Json;
import utils.vectors.Vector;

import java.util.HashMap;

import static engine.items.Utils.getItemTextureBySrc;
import static engine.utils.PositionUtils.convertTilePosition;

public class Items {
    // TODO: only for tests - remove this class later
    public static class Render {
        public Vector<Integer> position;
        public TextureRegion txt;

        public Render(String id, int posX, int posY) {
            this.position = convertTilePosition(posX, posY);
            this.txt = getData(id).getTxt();
        }

        public void draw(SpriteBatch sb) {
            sb.draw(Textures.slotTxt, position.x, position.y, 16, 16);
            sb.draw(txt, position.x, position.y, 16, 16);
        }
    }

    private static JsonNode configFileResources = Json.readFile(Urls.CONFIG_RESOURCE_ITEMS);
    private static HashMap<String, Config> data = createData();


    public static class Config {
        private final TextureRegion txt;
        private final String id;
        private final String name;

        public Config(String id, TextureRegion txt, String name) {
            this.id = id;
            this.txt = txt;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public TextureRegion getTxt() {
            return txt;
        }
    }

    public static HashMap<String, Config> getMap() {
        return data;
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
        return new TextureRegion(getItemTextureBySrc(itemSpriteSheet), x, y, 16, 16);
    }

}
