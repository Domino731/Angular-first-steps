package map.tiles;

import com.fasterxml.jackson.databind.JsonNode;
import engine.spritesLoader.SpritesLoader;
import engine.spritesLoader.Utils;
import engine.utils.vectors.Vector2s;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tiles {
    private final SpritesLoader spritesLoader = new SpritesLoader();
    private List<Tile> tilesList;
    public Tiles() {
        tilesList = new ArrayList<>();
    }
    private static final Vector2s defaultTileSpriteCords = new Vector2s((short) 10, (short) 10);
    public static final byte tileSize = 16;

    public void create(JsonNode tiles){
        BufferedImage defaultTileImg = null;
        try {
            InputStream is = getClass().getResourceAsStream(Utils.getSpriteSource("Outdoors spring"));
            defaultTileImg = ImageIO.read(is).getSubimage(0, 7 * tileSize, tileSize, tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                tilesList.add(new Tile(new Vector2s((short) i, (short) j), new Vector2s((short) 10, (short) 10), "TEST", defaultTileImg ));
            }
        }

            // Check if the parsed JsonNode is an array
        if (tiles.isArray()) {
                Map<String, BufferedImage> sprites = loadSprites(tiles);

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

                    BufferedImage tileImage = sprites.get(spriteName).getSubimage(spriteCords.x * tileSize, spriteCords.y * tileSize, tileSize, tileSize);
                    tilesList.set(tileListIndex,new Tile(mapCords, spriteCords, spriteName, tileImage));
                }
            } else {
                System.out.println("The provided JSON is not an array.");
        }

    }


    private Map<String, BufferedImage> loadSprites(JsonNode tiles) {
        List<String> spriteNames = new ArrayList<>();

        if(tiles.isArray()){
            for (JsonNode element : tiles){
                String spriteName = element.get("spriteName").asText();
                if(spriteNames.contains(spriteName) == false){
                    spriteNames.add(spriteName);
                }
            }
        }

        return spritesLoader.load(spriteNames);
    }

    public void render(Graphics g) {
        for(Tile tile : tilesList){
            tile.render(g);
        }
    }
}
