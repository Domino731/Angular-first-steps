package items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import environment.resources.ResourceConstants;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;
import java.util.HashMap;

public class Weapons {
    public static final byte size = 16;

    private static HashMap<String, Items.Config> items = new HashMap<>();
    private static final Texture toolsTxt = new Texture(Urls.SPRITE_WEAPONS);
    private static JsonNode data = readJson();

    private static JsonNode readJson() {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(Urls.CONFIG_WEAPONS);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(ResourceConstants.RES_CONFIG_SRC);
        }

        return json;
    }

    public static class Config {
        private String id;
        private String name;
        private int usage;
        private int damage;
        public TextureRegion txt;

        public Config(String id, String name, int usage, int damage, int txtX, int txtY) {
            this.id = id;
            this.name = name;
            this.usage = usage;
            this.damage = damage;

            txt = new TextureRegion(toolsTxt, txtX, txtY, 16, 16);


        }
    }
}
