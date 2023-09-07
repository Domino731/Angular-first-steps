package game.entities.player.animations.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;

import static game.entities.player.animations.config.AniConfigConstants.spritesheetBodyRowAmount;
import static game.entities.player.animations.config.AniConfigConstants.spritesheetRowsAmount;

public class Offsets {
    public static byte[][] shirts = createTShirt();


    private static byte[][] createTShirt() {
        // array for offsets
        byte[][] data = new byte[spritesheetRowsAmount][spritesheetBodyRowAmount];

        // read json config
        JsonNode node = readJson();

        if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                for (int j = 0; j < node.get(i).size(); j++) {
                    data[i][j] = (byte) node.get(i).get(j).asInt();
                }
            }
        }

        return data;
    }

    /**
     * Read json file for body offsets
     */
    private static JsonNode readJson() {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(Urls.CONFIG_BASE_SHIRT_OFFSETS);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(Urls.CONFIG_BASE_SHIRT_OFFSETS);
        }

        return json;
    }

}
