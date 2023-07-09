package map.tiles;

import engine.EngineConstants;
import engine.utils.vectors.Vector2s;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private Vector2s mapCords;
    private Vector2s spriteCords;
    private String spriteName;
    private BufferedImage tileImage;

    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName, BufferedImage tileImage) {
        this.mapCords = mapCords;
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
        this.tileImage = tileImage;
    }

    public void render(Graphics g) {
        byte tileSize = EngineConstants.TILE_SIZE;
        g.drawImage(tileImage,mapCords.x * tileSize , mapCords.y * tileSize, null);
    }

    public Vector2s getMapCords() {
        return mapCords;
    }

    public Vector2s getSpriteCords() {
        return spriteCords;
    }

    public String getSpriteName() {
        return spriteName;
    }

}
