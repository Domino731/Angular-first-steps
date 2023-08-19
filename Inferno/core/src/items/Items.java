package items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import environment.resources.ResourceConstants;
import game.entities.player.PlayerTextures;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;
import java.util.HashMap;

public class Items {
    //   {
    //    "id": "stone_pickaxe",
    //    "name": "Stone pickaxe",
    //    "usage": 1000,
    //    "damage": 25,
    //    "inventoryTxt": {
    //      "x": 10,
    //      "y": 10
    //    }
    //  }
    private static HashMap<String, Config> items = new HashMap<>();
    private static final Texture toolsTxt = PlayerTextures.toolsTxt;
    private static JsonNode data = readJson();

    private static JsonNode readJson() {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(Urls.toolsPickaxes);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(ResourceConstants.RES_CONFIG_SRC);
        }

        return json;
    }

    public static Config get(String itemId) {
        Config itemConfig = items.get(itemId);
        if (itemConfig != null) {
            return itemConfig;
        }

        JsonNode item = data.get(itemId);
        String id = item.get("id").asText();
        String name = item.get("name").asText();
        int usage = item.get("usage").asInt();
        int damage = item.get("damage").asInt();
        int x = item.get("inventoryTxt").get("x").asInt();
        int y = item.get("inventoryTxt").get("y").asInt();

        items.put(id, new Config(id, name, usage, damage, x, y));

        return items.get(itemId);
    }

    public static class Config {
        private String id;
        private String name;
        private int usage;
        private int damage;
        public TextureRegion inventoryTxt;

        public Config(String id, String name, int usage, int damage, int txtX, int txtY) {
            this.id = id;
            this.name = name;
            this.usage = usage;
            this.damage = damage;
            inventoryTxt = new TextureRegion(toolsTxt, txtX, txtY, 20, 20);
        }
    }
}
