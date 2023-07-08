package map;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.EngineLog;
import environement.trees.TreeNames;
import map.tiles.Tiles;
import utils.json.Json;

import java.io.IOException;

public class MapManager {
    private Tiles tiles;
    public MapManager() {
        tiles = new Tiles();
        EngineLog.classSuccess("MapManager");
        System.out.println(TreeNames.OAK);
        readLevel();
        short te = 12300;
    }

    private void readLevel() {
        try {
            JsonNode node = Json.parse(getClass().getResourceAsStream("/maps/test_1.json"));
            JsonNode tiles  = node.get("tiles");
            this.tiles.render(tiles);
        }
        catch (IOException e) {
            EngineLog.error("Error");
        }

    }
}
