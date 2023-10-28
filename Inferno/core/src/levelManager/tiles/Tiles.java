package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fasterxml.jackson.databind.JsonNode;
import constants.actors.DefaultActor;
import utils.vectors.Vector;
import utils.vectors.Vector2i;
import utils.vectors.Vector2s;

import java.util.ArrayList;
import java.util.List;

public class Tiles {
    private final List<Tile> tilesList;
    private final ArrayList<Tile> markedTiles = new ArrayList<>();
    private Tile hoveredTile = null;
    private int placeItemRange = 2;

    public Tiles() {
        tilesList = new ArrayList<>();
    }

    public static final byte tileSize = 16;

    public List<Tile> getTilesList() {
        return tilesList;
    }

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
                        tile = node;
                        break;
                    }
                }
                if (isExisting) {
                    // tile from map config
                    tilesList.add(new Tile(new Vector2s((short) i, (short) j), new Vector2s((short) tile.get("spriteCords").get("x").asInt(), (short) tile.get("spriteCords").get("y").asInt()), tile.get("spriteName").asText()));
                } else {
                    // default tile
                    tilesList.add(new Tile(new Vector2s((short) i, (short) j)));
                }
            }
        }
    }

    public void hoverTile(int positionX, int positionY) {
        Tile tile = null;
        for (Tile tileData : tilesList) {
            Vector2i mapCords = tileData.getCords();
            if (mapCords.x == positionX && mapCords.y == positionY) {
                tile = tileData;
                break;
            }
        }

        if (tile != null) {
            if (hoveredTile != null) {
                hoveredTile.unHover();
            }
            hoveredTile = tile;
            hoveredTile.hover();
            return;
        }
        hoveredTile = null;
    }

    public void assignActorToTile(DefaultActor actor) {
        Vector<Integer> actorPosition = actor.getMapPosition();
        Tile tile = null;
        for (Tile tileData : tilesList) {
            if (tileData.getCords().x == actorPosition.x && tileData.getCords().y == actorPosition.y) {
                tile = tileData;
                break;
            }
        }

        if (tile != null) {
            System.out.println("SET ACTOR");
            tile.setActor(actor);
        }
    }

    public void markTile(int x, int y) {
        ArrayList<Vector<Integer>> tileCords = new ArrayList<>();
        int firstX = x - placeItemRange;
        int lastX = x + placeItemRange;
        int firstY = y - placeItemRange;
        int lastY = y + placeItemRange;

        for (int i = firstX; i <= lastX; i++) {
            tileCords.add(new Vector<>(i, y));
            for (int j = firstY; j <= lastY; j++) {
                tileCords.add(new Vector<>(i, j));
            }
        }


        // un-mark tiles from previous frame
        for (Tile tile : markedTiles) {
            tile.setIsMarked(false);
        }
        markedTiles.clear();

        // find current tile
        for (Tile tile : tilesList) {
            // check if tile is on tileCords
            for (Vector<Integer> vector : tileCords) {
                if (tile.getCords().x == vector.x && tile.getCords().y == vector.y) {
                    markedTiles.add(tile);
                }
            }
        }

        for (Tile tile : markedTiles) {
            tile.setIsMarked(true);
        }
    }

    public void render(SpriteBatch batch) {
        for (Tile tile : tilesList) {
            tile.draw(batch);
        }
    }
}
