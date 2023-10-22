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


    public void createTilesList(JsonNode tiles, int mapWidth, int mapHeight) {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                boolean isExisting = false;
                JsonNode tile = null;
                for (JsonNode node : tiles) {
                    int nodeX = node.get("cords").get("x").asInt();
                    int nodeY = node.get("cords").get("y").asInt();
                    isExisting = nodeX == i && nodeY == j;
                    if (isExisting) {
                        System.out.println("NODE CORDS: " + nodeX + " " + nodeY);
                        tile = node;
                        break;
                    }
                }
                if (isExisting) {
                    System.out.println("CORDS: " + i + " " + j);
                    tilesList.add(new Tile(new Vector2s((short) i, (short) j), new Vector2s((short) tile.get("spriteCords").get("x").asInt(), (short) tile.get("spriteCords").get("y").asInt()), tile.get("spriteName").asText()));
                } else {
                    tilesList.add(new Tile(new Vector2s((short) i, (short) j), new Vector2s((short) 0, (short) 7), "Outdoors spring"));
                }
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
