package game.actors.MineActor;

import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;

import java.io.File;
import java.util.HashMap;

import static utils.Json.readFile;

public class MineActorConfigsManager {
    private static final HashMap<String, MineActorConfig> allMines = createData();

    private static HashMap<String, MineActorConfig> createData() {
        HashMap<String, MineActorConfig> payload = new HashMap<>();
        // TODO before release: make this pathname dynamic, because on different pc's it can behaviour in different ways
        createConfigs("C:\\Users\\Dominik\\Desktop\\projects\\pixi\\Inferno\\assets\\objects\\mines", payload, Urls.DIR_ACTORS_MINES);
        createConfigs("C:\\Users\\Dominik\\Desktop\\projects\\pixi\\Inferno\\assets\\objects\\bushes", payload, Urls.DIR_ACTORS_BUSHES);
        return payload;
    }

    private static void createConfigs(String pathname, HashMap<String, MineActorConfig> payload, String baseUrl) {
        File folder = new File(pathname);
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filePath = baseUrl + file.getName();
                MineActorConfig mineActorConfig = createMineActor(readFile(filePath));
                payload.put(mineActorConfig.getId(), mineActorConfig);
            }
        }
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
