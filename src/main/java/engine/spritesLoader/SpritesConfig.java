package engine.spritesLoader;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.EngineLog;
import engine.utils.vectors.DimensionVector;
import engine.utils.vectors.Vector2s;
import utils.json.Json;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SpritesConfig {
    public SpritesConfig(){}
    private static HashMap<String, Config> sprites = setData();

    private static class Config {
           public String name;
           public DimensionVector<Short> size;
           public DimensionVector<Short> cell;
           public String src;

           public Config(String name, DimensionVector<Short> size, DimensionVector<Short> cell) {
               this.name = name;
               this.size = size;
               this.cell = cell;
               this.src = "sprites/" + name;
           }

    }

    private static  HashMap<String, Config> setData() {
        HashMap<String, Config> sprites = new HashMap<>();

        try {
            JsonNode node = Json.parse(SpritesConfig.class.getResourceAsStream("/config/sprites.json"));
            if(node.isArray()){
                for(JsonNode elem : node) {
                    String name = elem.get("sprite").asText();
                    JsonNode size = elem.get("size");
                    Config config = new Config(
                            name,
                            new DimensionVector<Short>(size.get("width").shortValue(), size.get("height").shortValue()),
                            new DimensionVector<Short>(size.get("cellWidth").shortValue(), size.get("cellHeight").shortValue())
                    );

                    sprites.put(name, config);
                }
            }
        }
        catch (IOException e){
            EngineLog.resourceError("Failed to load sprites config");
        }

        return sprites;
    }

    public static Map<String, Config> getSprites(){
        return sprites;
    }

    public static Vector2s calculateObjectPosition(String spriteSrc, Vector2s position) {
        Config sprite = sprites.get(spriteSrc);
        if(sprite == null){
            return position;
        }
        return new Vector2s((short) (sprite.cell.width * position.x), (short) (sprite.cell.height * position.y));
    }
}
