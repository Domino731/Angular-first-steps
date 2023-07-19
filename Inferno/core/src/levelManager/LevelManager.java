package levelManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fasterxml.jackson.databind.JsonNode;
import levelManager.tiles.Tiles;
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
