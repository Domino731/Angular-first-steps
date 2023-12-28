package game.player.animations.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.JsonNode;
import constants.Urls;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;

import static game.player.animations.config.AniConfigConstants.spritesheetBodyRowAmount;
import static game.player.animations.config.AniConfigConstants.spritesheetRowsAmount;

public class BodyOffsets {
    public static byte[][] bodyYOffsets = createYOffsets();
    public static byte[][] bodyXOffsets = createXOffsets();

    private static byte[][] createYOffsets() {
        // array for offsets
        byte[][] data = new byte[spritesheetRowsAmount][spritesheetBodyRowAmount];

        // read json config
        JsonNode node = readJson();

        if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                for (int j = 0; j < node.get(i).size(); j++) {
                    data[i][j] = (byte) node.get(i).get(j).get(0).asInt();
                }
            }
        }

        return data;
    }

    private static byte[][] createXOffsets() {
        // array for offsets
        byte[][] data = new byte[spritesheetRowsAmount][spritesheetBodyRowAmount];

        // read json config
        JsonNode node = readJson();

        if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                for (int j = 0; j < node.get(i).size(); j++) {
                    data[i][j] = (byte) node.get(i).get(j).get(1).asInt();
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
            FileHandle fileHandle = Gdx.files.internal(Urls.PLAYER_HAIR_OFFSET);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(Urls.PLAYER_HAIR_OFFSET);
        }

        return json;
    }

}
