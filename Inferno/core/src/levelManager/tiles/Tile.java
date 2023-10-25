package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.Textures;
import engine.utils.Draw;
import utils.vectors.Vector;
import utils.vectors.Vector2s;

import static levelManager.tiles.Utils.createTileTexture;

public class Tile {
    private Vector2s mapCords;
    private Vector2s cords;
    private Vector2s spriteCords;
    private String spriteName;
    public Vector<Integer> position;
    private TextureRegion txt;
    private Draw currentDraw;

    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName) {
        this.mapCords = mapCords;
        this.cords = mapCords;
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
        this.position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
        this.txt = createTileTexture(spriteName, spriteCords.x, spriteCords.y);
        setCurrentDraw();
    }

    public Tile(Vector2s mapCords) {
        this.mapCords = mapCords;
        this.spriteCords = new Vector2s((short) 0, (short) 7);
        this.spriteName = "Outdoors spring";
        this.position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
        this.txt = createTileTexture(this.spriteName, this.spriteCords.x, this.spriteCords.y);
        setCurrentDraw();
    }

    private void setCurrentDraw() {
        currentDraw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(txt, position.x, position.y);
                sb.draw(Textures.frameTxt, position.x, position.y, 16, 16);
            }
        };
    }

    public Vector2s getCords() {
        return cords;
    }

    public void draw(SpriteBatch sb) {
        currentDraw.draw(sb);
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