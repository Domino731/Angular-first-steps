package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.Textures;
import utils.vectors.Vector;
import utils.vectors.Vector2s;

import static levelManager.tiles.Utils.createTileTexture;

public class Tile {
    private Vector2s mapCords;
    private Vector2s spriteCords;
    private String spriteName;
    public Vector<Integer> position;
    private TextureRegion txt;

    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName) {
        this.mapCords = mapCords;
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
        this.position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
        this.txt = createTileTexture(spriteName, spriteCords.x, spriteCords.y);
    }

    public Tile(Vector2s mapCords) {
        this.mapCords = mapCords;
        this.spriteCords = new Vector2s((short) 0, (short) 7);
        this.spriteName = "Outdoors spring";
        this.position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
        this.txt = createTileTexture(this.spriteName, this.spriteCords.x, this.spriteCords.y);
    }

    public void draw(Batch batch) {

        batch.draw(txt, position.x, position.y);
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