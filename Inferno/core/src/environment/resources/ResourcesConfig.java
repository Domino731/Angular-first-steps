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
        private final ArrayList<DropItemData> drop;
        private final String groundCheckboxId;
        private final String actionCollisionId;

        public Config(Texture txt, Vector<Integer> offset, DimensionVector<Byte> dim, ActionTypes actionType, ArrayList<DropItemData> drop, String groundCheckboxId, String actionCollisionId) {
            this.txt = new TextureRegion(txt, offset.x, offset.y, dim.width, dim.height);
            this.actionType = actionType;
            this.drop = drop;
            this.groundCheckboxId = groundCheckboxId;
            this.actionCollisionId = actionCollisionId;
        }

        public ActionTypes getActionType() {
            return actionType;
        }

        public ArrayList<DropItemData> getDrop() {
            return drop;
        }

        public boolean getIsBig() {
            return false;
        }

        public String getGroundCheckboxId() {
            return groundCheckboxId;
        }

        public String getActionCollisionId() {
            return actionCollisionId;
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

        byte width = (byte) resourceConfig.get("width").asInt();
        byte height = (byte) resourceConfig.get("height").asInt();

        Texture texture = Textures.minesTxt;

        if (resourceConfig.get("spriteName") != null && Objects.equals(resourceConfig.get("spriteName").asText(), "bushes")) {
            System.out.println(resourceConfig.get("spriteName"));
            texture = Textures.bushesTxt;
        }


        DimensionVector<Byte> dim = new DimensionVector<>(width, height);
        ActionTypes actionType = ActionCollisionUtils.getActionTypeFromJson(resourceConfig.get("action").asText());
        ArrayList<DropItemData> drop = new ArrayList<>();
        String groundCheckboxId = resourceConfig.get("groundCheckboxId").asText();
        String actionCollisionId = resourceConfig.get("actionCollisionId").asText();
        if (dropData.isArray()) {
            for (JsonNode node : dropData) {
                String itemId = node.get("id").asText();
                TextureRegion itemTexture = Items.getData(itemId).getTxt();
                drop.add(new DropItemData(itemId, itemTexture));
            }
        }

        resources.put(resourceConfig.get("id").asText(), new Config(texture, offset, dim, actionType, drop, groundCheckboxId, actionCollisionId));

        return resources.get(id);
    }
}