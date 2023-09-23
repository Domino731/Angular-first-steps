package environment.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import engine.actionCollision.ActionCollisionUtils;
import engine.actionCollision.ActionTypes;
import engine.items.DropItemData;
import engine.items.Items;
import utils.EngineLog;
import utils.Json;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class ResourcesConfig {

    private static final JsonNode minesConfig = readJson(ResourceConstants.RES_CONFIG_SRC);
    private static final JsonNode bushesConfig = readJson(Urls.CONFIG_RESOURCE_BUSHES);

    private static final HashMap<String, Config> resources = new HashMap<>();

    public static class Config {
        public final TextureRegion txt;
        private final ActionTypes actionType;
        private final boolean isBig;
        private final ArrayList<DropItemData> drop;

        public Config(Texture txt, Vector<Integer> offset, DimensionVector<Byte> dim, ActionTypes actionType, boolean isBig, ArrayList<DropItemData> drop) {
            this.txt = new TextureRegion(txt, offset.x, offset.y, dim.width, dim.height);
            this.actionType = actionType;
            this.isBig = isBig;
            this.drop = drop;
        }

        public ActionTypes getActionType() {
            return actionType;
        }

        public ArrayList<DropItemData> getDrop() {
            return drop;
        }

        public boolean getIsBig() {
            return isBig;
        }
    }

    private static JsonNode readJson(String src) {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(src);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(src);
        }

        return json;
    }

    private static JsonNode getResourceConfig(String id) {
        JsonNode payload = findResourceConfig(id, minesConfig);
        if (payload == null) {
            payload = findResourceConfig(id, bushesConfig);
        }

        if (payload == null) {
            return minesConfig.get(1);
        }

        return payload;
    }

    private static JsonNode findResourceConfig(String id, JsonNode config) {
        if (config.isArray()) {
            for (JsonNode resource : config) {
                if (Objects.equals(id, resource.get("id").asText())) {
                    return resource;
                }
            }
        }
        return null;
    }

    public static Config get(String id) {
        Config config = resources.get(id);
        if (config != null) {
            return config;
        }

        JsonNode resourceConfig = getResourceConfig(id);
        JsonNode dropData = resourceConfig.get("drop");

        Vector<Integer> offset = new Vector<>(resourceConfig.get("cords").get("x").intValue(), resourceConfig.get("cords").get("y").intValue());
        boolean isBig = resourceConfig.get("is_big").asBoolean();

        byte width = isBig ? (byte) 32 : (byte) 16;
        byte height = isBig ? (byte) 32 : (byte) 16;

        Texture texture = Textures.minesTxt;

        if(resourceConfig.get("width") != null) {
            width = (byte) resourceConfig.get("width").asInt();
            height = (byte) resourceConfig.get("height").asInt();
        }

        if(resourceConfig.get("spriteName") != null && Objects.equals(resourceConfig.get("spriteName").asText(), "bushes")) {
            System.out.println(resourceConfig.get("spriteName"));
            texture = Textures.bushesTxt;
        }


        DimensionVector<Byte> dim = new DimensionVector<>(width, height);
        ActionTypes actionType = ActionCollisionUtils.getActionTypeFromJson(resourceConfig.get("action").asText());
        ArrayList<DropItemData> drop = new ArrayList<>();

        if (dropData.isArray()) {
            for (JsonNode node : dropData) {
                String itemId = node.get("id").asText();
                TextureRegion itemTexture = Items.getData(itemId).getTxt();
                drop.add(new DropItemData(itemId, itemTexture));
            }
        }

        resources.put(resourceConfig.get("id").asText(), new Config(texture, offset, dim, actionType, isBig, drop));

        return resources.get(id);
    }
}