package map.tiles;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.vectors.Vector2s;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Tiles {
    private List<Tile> tilesList;
    public Tiles() {
        tilesList = new ArrayList<>();
    }

    public void create(JsonNode tiles){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                short test = 12;
                tilesList.add(new Tile(new Vector2s((short) i, (short) j), new Vector2s(test, test), "TEST"));
            }
        }

            // Check if the parsed JsonNode is an array
            if (tiles.isArray()) {
                // Loop through the array elements
                for (JsonNode element : tiles) {
                    String spriteName = element.get("spriteName").asText();
                    Vector2s mapCords = new Vector2s(element.get("cords").get("x").shortValue(),element.get("cords").get("y").shortValue());
                    Vector2s spriteCords = new Vector2s(element.get("spriteCords").get("x").shortValue(),element.get("spriteCords").get("y").shortValue());
                    int tileListIndex = 0;

                    for(Tile tile : tilesList){
                        Vector2s tileCords = tile.getMapCords();
                        if(mapCords.x == tileCords.x && mapCords.y == tileCords.y) {
                             tileListIndex = tilesList.indexOf(tile);
                             break;
                        }
                    }

                    tilesList.set(tileListIndex,new Tile(mapCords, spriteCords, spriteName));
                }
            } else {
                System.out.println("The provided JSON is not an array.");
            }

    }



    public void render(Graphics g) {
        for(Tile tile : tilesList){
            tile.render(g);
        }
    }
}
