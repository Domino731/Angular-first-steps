package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import spritesManager.SpritesManager;
import utils.vectors.Vector2s;

public class Tile extends Actor {
    private Vector2s mapCords;
    private Vector2s spriteCords;
    private String spriteName;


    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName) {
        this.mapCords = mapCords;
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
        setPosition(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(SpritesManager.defaultTileTexture, mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
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