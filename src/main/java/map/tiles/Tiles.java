package map.tiles;

import com.fasterxml.jackson.databind.JsonNode;
import engine.utils.vectors.Vector2s;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Tiles {
    private List<Tile> tilesList;
    public Tiles() {
        tilesList = new ArrayList<>();
    }

    public void render(JsonNode tiles){
            // Check if the parsed JsonNode is an array
            if (tiles.isArray()) {
                // Loop through the array elements
                for (JsonNode element : tiles) {
                    String spriteName = element.get("spriteName").asText();
                    Vector2s mapCords = new Vector2s(element.get("cords").get("x").shortValue(),element.get("cords").get("y").shortValue());
                    Vector2s spriteCords = new Vector2s(element.get("spriteCords").get("x").shortValue(),element.get("spriteCords").get("y").shortValue());
                    tilesList.add(new Tile(mapCords, spriteCords, spriteName));
                }
            } else {
                System.out.println("The provided JSON is not an array.");
            }
    }
}
