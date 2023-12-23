package items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import game.player.playerTextures.PlayerTextures;
import utils.Direction;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;
import java.util.HashMap;

public class Items {
    public static final byte toolWidth = 16;
    public static final byte toolHeight = 32;
    private static HashMap<String, Config> items = new HashMap<>();
    private static final Texture toolsTxt = PlayerTextures.toolsTxt;
    private static JsonNode data = readJson();

    private static JsonNode readJson() {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(Urls.CONFIG_PICKAXES);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(Urls.CONFIG_MINES);
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
        JsonNode textures = item.get("textures");
        items.put(id, new Config(id, name, usage, damage, x, y, textures));

        return items.get(itemId);
    }

    public static class Config {
        public TextureRegion inventoryTxt;
        public TextureRegion[] downTextures;
        public TextureRegion[] upTextures;
        public TextureRegion rightTxt;
        public TextureRegion leftTxt;
        public TextureRegion[][] txts = new TextureRegion[4][2];

        public Config(String id, String name, int usage, int damage, int txtX, int txtY, JsonNode textures) {
            inventoryTxt = new TextureRegion(toolsTxt, txtX, txtY, 20, 20);
            downTextures = new TextureRegion[2];
            upTextures = new TextureRegion[2];

            JsonNode down1 = textures.get("down").get(0);
            JsonNode down2 = textures.get("down").get(1);
            JsonNode up1 = textures.get("up").get(0);
            JsonNode up2 = textures.get("up").get(1);
            JsonNode right = textures.get("right").get(0);

            txts[Direction.up][0] = new TextureRegion(toolsTxt, up1.get(0).asInt(), up1.get(1).asInt(), toolWidth, toolHeight);
            txts[Direction.up][1] = new TextureRegion(toolsTxt, up2.get(0).asInt(), up2.get(1).asInt(), toolWidth, toolHeight);
            txts[Direction.down][0] = new TextureRegion(toolsTxt, down1.get(0).asInt(), down1.get(1).asInt(), toolWidth, toolHeight);
            txts[Direction.down][1] = new TextureRegion(toolsTxt, down2.get(0).asInt(), down2.get(1).asInt(), toolWidth, toolHeight);
            txts[Direction.right][0] = new TextureRegion(toolsTxt, right.get(0).asInt(), right.get(1).asInt(), toolWidth, toolHeight);
            txts[Direction.left][0] = new TextureRegion(toolsTxt, right.get(0).asInt(), right.get(1).asInt(), toolWidth, toolHeight);
            txts[Direction.left][0].flip(true, false);

            // TODO: remove
            downTextures[0] = new TextureRegion(toolsTxt, down1.get(0).asInt(), down1.get(1).asInt(), toolWidth, toolHeight);
            downTextures[1] = new TextureRegion(toolsTxt, down2.get(0).asInt(), down2.get(1).asInt(), toolWidth, toolHeight);
            upTextures[0] = new TextureRegion(toolsTxt, up1.get(0).asInt(), up1.get(1).asInt(), toolWidth, toolHeight);
            upTextures[1] = new TextureRegion(toolsTxt, up2.get(0).asInt(), up2.get(1).asInt(), toolWidth, toolHeight);
            rightTxt = new TextureRegion(toolsTxt, right.get(0).asInt(), right.get(1).asInt(), toolWidth, toolHeight);
            leftTxt = new TextureRegion(toolsTxt, right.get(0).asInt(), right.get(1).asInt(), toolWidth, toolHeight);
            leftTxt.flip(true, false);
        }
    }
}
