package game.actors.MineActor;

import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;

import java.io.File;
import java.util.HashMap;

import static utils.Json.readFile;

public class MineActorConfigsManager {
    private static HashMap<String, MineActorConfig> allMines = createData();

    private static HashMap<String, MineActorConfig> createData() {
        HashMap<String, MineActorConfig> payload = new HashMap<>();
        // TODO before release: make this pathname dynamic, because on different pc's it can behaviour in different ways
        File folder = new File("C:\\Users\\Dominik\\Desktop\\projects\\pixi\\Inferno\\assets\\objects\\mines");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filePath = Urls.DIR_ACTORS_MINES + file.getName();
                MineActorConfig mineActorConfig = createMineActor(readFile(filePath));
                payload.put(mineActorConfig.getId(), mineActorConfig);
            }
        }
        return payload;
    }

    private static MineActorConfig createMineActor(JsonNode node) {
        String id = node.get("id").asText();
        String name = node.get("name").asText();
        JsonNode specs = node.get("specs");
        return new MineActorConfig(id, "MINE", name, specs);
    }

    public static MineActorConfig get(String actorId) {
        return allMines.get(actorId);
    }

}
