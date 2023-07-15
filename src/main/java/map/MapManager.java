package map;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.EngineLog;
import environement.trees.TreeNames;
import map.mapObjects.MapObjects;
import map.tiles.Tiles;
import objects.tree.TreesConfig;
import utils.json.Json;

import java.awt.*;
import java.io.IOException;

public class MapManager {
    private Tiles tiles;
    private MapObjects mapObjects;

    public MapManager() {
        tiles = new Tiles();
        mapObjects = new MapObjects();
        EngineLog.classSuccess("MapManager");
        System.out.println(TreeNames.OAK);
        readLevel();
    }

    public void render(Graphics g) {
           tiles.render(g);
    }

    private void readLevel() {
        try {
            JsonNode node = Json.parse(getClass().getResourceAsStream("/maps/test_4.json"));
            JsonNode tiles  = node.get("tiles");
            System.out.println(TreesConfig.trees);
            this.tiles.create(tiles);
            this.mapObjects.create(node);
        }
        catch (IOException e) {
            EngineLog.error("Error");
        }

    }
}
