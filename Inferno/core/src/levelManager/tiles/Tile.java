package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import engine.Textures;
import spritesManager.SpritesManager;
import utils.vectors.Vector;
import utils.vectors.Vector2s;

public class Tile {
    private Vector2s mapCords;
    private Vector2s spriteCords;
    private String spriteName;
    public Vector<Integer> position;

    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName) {
        this.mapCords = mapCords;
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
        position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
    }

    public void draw(Batch batch) {

        batch.draw(SpritesManager.defaultTileTexture, position.x, position.y);
        batch.draw(Textures.frameTxt, position.x, position.y, 16, 16);
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