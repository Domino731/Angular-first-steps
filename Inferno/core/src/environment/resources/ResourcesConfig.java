package environment.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import utils.EngineLog;
import utils.Json;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


public class ResourcesConfig {
    private static JsonNode json = readJson();
    private static HashMap<String, Config> resources = new HashMap<>();

    public static class Config {
        public TextureRegion txt;

        Config(Vector<Integer> offset, DimensionVector<Byte> dim) {
            txt = new TextureRegion(ResourceTextures.txt, offset.x, offset.y, dim.width, dim.height);
        }
    }

    private static JsonNode readJson() {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(ResourceConstants.RES_CONFIG_SRC);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(ResourceConstants.RES_CONFIG_SRC);
        }

        return json;
    }

    private static JsonNode getResourceConfig(String id) {
        if (!json.isArray()) {
            return null;
        }

        JsonNode payload = null;
        for (JsonNode resource : json) {
            if (Objects.equals(id, resource.get("id").asText())) {
                payload = resource;
            }
        }

        return payload;
    }

    public static Config get(String id) {
        Config config = resources.get(id);
        if (config != null) {
            return config;
        }
        JsonNode resourceConfig = getResourceConfig(id);
        Vector<Integer> offset = new Vector<Integer>(resourceConfig.get("cords").get("x").shortValue() * 16, resourceConfig.get("cords").get("y").shortValue() * 16);
        DimensionVector<Byte> dim = new DimensionVector<>((byte) resourceConfig.get("size").get("width").asInt(), (byte) resourceConfig.get("size").get("height").asInt());
        resources.put(resourceConfig.get("id").asText(), new Config(offset, dim));

        return resources.get(id);
    }
}
