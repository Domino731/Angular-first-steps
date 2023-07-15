package engine.spritesLoader;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.EngineLog;
import engine.utils.vectors.DimensionVector;
import utils.json.Json;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SpritesConfig {
    public SpritesConfig(){}
    private static Map<String, Config> sprites = setData();

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
        HashMap<String, Config> sprites = new HashMap<>(Collections.emptyMap());

        try {
            JsonNode node = Json.parse(SpritesConfig.class.getResourceAsStream("/config/sprites.json"));
            if(node.isArray()){
                for(JsonNode elem : node) {
                    String name = String.valueOf(elem.get("sprite"));
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
}
