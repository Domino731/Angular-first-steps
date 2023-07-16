package levelManager.tiles;

import utils.vectors.Vector2s;

public class Tile {
    private Vector2s mapCords;
    private Vector2s spriteCords;
    private String spriteName;

    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName) {
        this.mapCords = mapCords;
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
    }

    public void render() {

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