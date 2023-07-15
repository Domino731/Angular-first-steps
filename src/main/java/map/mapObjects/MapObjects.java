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
        createTrees(mapNode.get("objects").get("TREES"));
    }

    private void createTrees(JsonNode trees){
        if(trees.isArray()){
            for (JsonNode tree : trees){
                System.out.println(tree);
            }
        }
    }
}
