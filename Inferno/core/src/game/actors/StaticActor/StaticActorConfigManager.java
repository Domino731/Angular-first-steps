package game.actors.StaticActor;

import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;

import java.util.HashMap;

import static utils.Json.readFile;

public class StaticActorConfigManager {
    private static final HashMap<String, StaticActorConfig> allStaticActors = createData();

    private static HashMap<String, StaticActorConfig> createData() {
        HashMap<String, StaticActorConfig> payload = new HashMap<>();
        StaticActorConfig bigTree1Spring = createActorConfig(Urls.CONFIG_STATIC_TREES_2);
        payload.put(bigTree1Spring.getId(), bigTree1Spring);
        System.out.println(bigTree1Spring);
        return payload;
    }

    private static StaticActorConfig createActorConfig(String actorConfigSource) {
        JsonNode node = readFile(actorConfigSource);
        String id = node.get("id").asText();
        String name = node.get("name").asText();
        String type = "STATIC";
        JsonNode specs = node.get("specs");
        return new StaticActorConfig(id, type, name, specs);
    }

    public static StaticActorConfig get(String actorId) {
        return allStaticActors.get(actorId);
    }
}
