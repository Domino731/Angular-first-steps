package map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.utils.EngineLog;
import environement.trees.TreeNames;
import utils.json.Json;

import java.io.IOException;

public class MapManager {
    public MapManager() {
        EngineLog.classSuccess("MapManager");
        System.out.println(TreeNames.OAK);
        readLevel();
    }

    private void readLevel() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = Json.parse(getClass().getResourceAsStream("/maps/test_1.json"));
                    System.out.println(node.get("objects"));
        }
        catch (IOException e) {
            EngineLog.error("Error");
        }

    }
}
