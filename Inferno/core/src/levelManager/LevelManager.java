package levelManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.JsonNode;
import levelManager.tiles.Tiles;
import objects.trees.TreesConfig;
import utils.EngineLog;
import utils.Json;

import java.io.IOException;

public class LevelManager {
    private Tiles tiles;

    public LevelManager() {
        tiles = new Tiles();
        readLevel();
    }

    public void render() {

    }

    private void readLevel() {
        FileHandle fileHandle = Gdx.files.internal("maps/test_4.json");
        if(fileHandle.exists()){
            try {
                System.out.println(fileHandle.readString());
                JsonNode node = Json.parse(fileHandle.readString());
                JsonNode tiles  = node.get("tiles");
                this.tiles.create(tiles);
            }
            catch (IOException e){

            }

        }

    }
}
