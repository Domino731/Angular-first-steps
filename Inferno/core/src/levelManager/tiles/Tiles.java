package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fasterxml.jackson.databind.JsonNode;
import utils.vectors.Vector2s;

import java.util.ArrayList;
import java.util.List;

public class Tiles {
    private List<Tile> tilesList;

    public Tiles() {
        tilesList = new ArrayList<>();
    }

    private static final Vector2s defaultTileSpriteCords = new Vector2s((short) 10, (short) 10);
    public static final byte tileSize = 16;

    public void create(JsonNode tiles) {
        createTilesList(tiles);
    }

    public void createTilesList(JsonNode tiles) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                tilesList.add(new Tile(new Vector2s((short) i, (short) j), new Vector2s((short) 10, (short) 10), "TEST"));
            }
        }
    }

    public void createTileClasses() {
//       System.out.println(tilesList);
    }

    public void render(SpriteBatch batch) {
        for (Tile tile : tilesList) {
            tile.draw(batch);
        }
    }
}
