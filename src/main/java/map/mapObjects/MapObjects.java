package map.mapObjects;

import com.fasterxml.jackson.databind.JsonNode;
import engine.spritesLoader.SpritesConfig;
import objects.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MapObjects {
    private List<Tree> trees = new ArrayList<>();

    public MapObjects() {
    }

    public void create(JsonNode mapNode){
        System.out.println(SpritesConfig.getSprites());
        System.out.println(mapNode.get("objects").get("TREES"));
    }
}
