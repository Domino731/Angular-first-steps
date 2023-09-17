package engine.fonts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import engine.Textures;
import utils.Json;

import java.util.HashMap;

public class Fonts {
    private static final JsonNode configNode = Json.readFile(Urls.CONFIG_FONTS_4);
    private static final HashMap<String, Config> data = createFonts();

    public static class Config {
        private final String id;
        private final TextureRegion txt;
        private final byte width;
        private final byte height;

        Config(String id, TextureRegion txt, byte width, byte height) {
            this.id = id;
            this.txt = txt;
            this.width = width;
            this.height = height;
        }

        public String getId() {
            return id;
        }
        public TextureRegion getTxt() {
            return txt;
        }
        public byte getWidth() {
            return width;
        }
        public byte getHeight() {
            return height;
        }
    }

    private static HashMap<String, Config> createFonts() {
        HashMap<String, Config> fonts = new HashMap<>();

        if(configNode.isArray()) {
            for (JsonNode node: configNode) {
               int x = node.get("x").asInt();
               int y= node.get("y").asInt();
               byte width = (byte) node.get("width").asInt();
               byte height = (byte) node.get("height").asInt();
               String id = node.get("letter").asText();
               TextureRegion  txt = createTexture(x,y,width,height);
               fonts.put(id, new Config(id, txt, width, height));
            }
        }

        return fonts;
    }

    private static TextureRegion createTexture(int x, int y, int width, int height ) {
        return new TextureRegion(Textures.fontsTxt, x, y, width, height);
    }
}
