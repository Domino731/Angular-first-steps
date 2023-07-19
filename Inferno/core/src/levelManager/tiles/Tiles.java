package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.fasterxml.jackson.databind.JsonNode;
import utils.vectors.Vector2s;

import java.util.ArrayList;
import java.util.List;

public class Tiles {
    private List<Tile> tilesList;
    private Stage tilesState;
    public Tiles() {
        tilesList = new ArrayList<>();
        tilesState = new Stage();
    }

    private static final Vector2s defaultTileSpriteCords = new Vector2s((short) 10, (short) 10);
    public static final byte tileSize = 16;

    public void create(JsonNode tiles) {
        createTilesList(tiles);
    }

    public void createTilesList(JsonNode tiles){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                tilesState.addActor(new Tile(new Vector2s((short) i, (short) j), new Vector2s((short) 10, (short) 10), "TEST" ));
            }
        }

//        // Check if the parsed JsonNode is an array
//        if (tiles.isArray()) {
//            // Loop through the array elements
//            for (JsonNode element : tiles) {
//                String spriteName = element.get("spriteName").asText();
//                Vector2s mapCords = new Vector2s(element.get("cords").get("x").shortValue(),element.get("cords").get("y").shortValue());
//                Vector2s spriteCords = new Vector2s(element.get("spriteCords").get("x").shortValue(),element.get("spriteCords").get("y").shortValue());
//                int tileListIndex = 0;
//
//                for(Tile tile : tilesList){
//                    Vector2s tileCords = tile.getMapCords();
//                    if(mapCords.x == tileCords.x && mapCords.y == tileCords.y) {
//                        tileListIndex = tilesList.indexOf(tile);
//                        break;
//                    }
//                }
//
//                tilesList.set(tileListIndex,new Tile(mapCords, spriteCords, spriteName));
//            }
//        } else {
//            System.out.println("The provided JSON is not an array.");
//        }

    }

    public void createTileClasses() {
//       System.out.println(tilesList);
    }

    public void render(SpriteBatch batch) {
        tilesState.draw();
//        for (Tile tile: tilesList ) {
//            tile
//        }
    }
}
