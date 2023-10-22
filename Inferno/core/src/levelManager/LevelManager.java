package levelManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fasterxml.jackson.databind.JsonNode;
import levelManager.tiles.Tiles;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;

public class LevelManager {
    private Tiles tiles;

    public LevelManager() {
        tiles = new Tiles();
        readLevel();
    }

    public void render(SpriteBatch batch) {
        tiles.render(batch);
    }

    private void readLevel() {
        FileHandle fileHandle = Gdx.files.internal("maps/pixi-valley-map.json");
        if (fileHandle.exists()) {
            try {
                JsonNode node = Json.parse(fileHandle.readString());
                JsonNode tiles = node.get("tiles");
                int mapWidth = node.get("mapSize").get("width").asInt();
                int mapHeight = node.get("mapSize").get("height").asInt();
                this.tiles.createTilesList(tiles, mapWidth, mapHeight);
            } catch (IOException e) {
                EngineLog.error("LevelManager.readLevel() ERROR while generating files");
            }
        }

    }
}
