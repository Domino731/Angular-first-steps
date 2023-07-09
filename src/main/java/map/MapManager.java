package map;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.EngineLog;
import environement.trees.TreeNames;
import map.tiles.Tiles;
import utils.json.Json;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    private Tiles tiles;
    public MapManager() {
        tiles = new Tiles();
        EngineLog.classSuccess("MapManager");
        System.out.println(TreeNames.OAK);
        readLevel();
        short te = 12300;
    }

    public void render(Graphics g) {
           tiles.render(g);
    }

    private void readLevel() {
        try {
            JsonNode node = Json.parse(getClass().getResourceAsStream("/maps/test_1.json"));
            JsonNode tiles  = node.get("tiles");
            loadSprites(tiles);
            this.tiles.create(tiles);
        }
        catch (IOException e) {
            EngineLog.error("Error");
        }

    }

    private void loadSprites(JsonNode tiles) {
        List<String> spriteNames = new ArrayList<>();

        if(tiles.isArray()){
            for (JsonNode element : tiles){
                String spriteName = element.get("spriteName").asText();
                if(spriteNames.contains(spriteName) == false){
                    spriteNames.add(spriteName);
                }
            }
        }

        System.out.println(spriteNames);
    }

}
