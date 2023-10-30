package levelManager.tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.actors.DefaultActor;
import engine.Textures;
import engine.utils.Draw;
import screens.PlayScreen;
import utils.vectors.Vector;
import utils.vectors.Vector2i;
import utils.vectors.Vector2s;

import static levelManager.tiles.Utils.createTileTexture;

public class Tile {
    private Vector2s mapCords;
    private Vector2i cords;
    private Vector2s spriteCords;
    private String spriteName;
    public Vector<Integer> position;
    private TextureRegion txt;
    private Draw currentDraw;
    private boolean isMarked = false;
    private boolean isHovered = false;
    private DefaultActor actor = null;
    private Vector<Integer> windowPosition;


    public Tile(Vector2s mapCords, Vector2s spriteCords, String spriteName) {
        this.mapCords = mapCords;
        this.cords = new Vector2i(mapCords.x, mapCords.y);
        this.spriteCords = spriteCords;
        this.spriteName = spriteName;
        this.position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
        windowPosition = new Vector<>(PlayScreen.cameraXOffset + position.x, PlayScreen.cameraYOffset + position.y);
        this.txt = createTileTexture(spriteName, spriteCords.x, spriteCords.y);
        setDrawWithoutMark();
    }

    public DefaultActor getActor() {
        return actor;
    }

    public Tile(Vector2s mapCords) {
        this.mapCords = mapCords;
        this.cords = new Vector2i(mapCords.x, mapCords.y);
        this.spriteCords = new Vector2s((short) 0, (short) 7);
        this.spriteName = "Outdoors spring";
        this.position = new Vector<>(mapCords.x * Tiles.tileSize, mapCords.y * Tiles.tileSize);
        windowPosition = new Vector<>(PlayScreen.cameraXOffset + position.x, PlayScreen.cameraYOffset + position.y);
        this.txt = createTileTexture(this.spriteName, this.spriteCords.x, this.spriteCords.y);
        setDrawWithoutMark();
    }

    public void unHover() {
        isHovered = false;
        setDrawWithoutMark();
    }

    public void hover() {
        isHovered = true;
        currentDraw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(txt, position.x, position.y);
                sb.draw(Textures.whiteCellTxt, position.x, position.y, 16, 16);
            }
        };
    }

    public void setActor(DefaultActor actor) {
        this.actor = actor;
    }

    public boolean getIsMarked() {
        return isMarked;
    }

    public void setIsMarked(boolean isMarked) {
        this.isMarked = isMarked;
        if (!isMarked) {
            setDrawWithoutMark();
            return;
        }
        if (actor != null) {
            setDrawWithRedMark();
            return;
        }
        setDrawWithWhiteMark();
    }

    public void setDrawWithoutMark() {
        currentDraw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(txt, position.x, position.y);
                sb.draw(Textures.frameTxt, position.x, position.y, 16, 16);
            }
        };
    }

    private void setDrawWithWhiteMark() {
        if (isHovered) {
            currentDraw = new Draw() {
                @Override
                public void draw(SpriteBatch sb) {
                    sb.draw(txt, position.x, position.y);
                    sb.draw(Textures.greenCellTxt, position.x, position.y, 16, 16);
                }
            };
            return;
        }
        currentDraw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(txt, position.x, position.y);
                sb.draw(Textures.whiteCellTxt, position.x, position.y, 16, 16);
            }
        };
    }

    private void setDrawWithRedMark() {
        currentDraw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(txt, position.x, position.y);
                sb.draw(Textures.redCellTxt, position.x, position.y, 16, 16);
            }
        };
    }


    public Vector2i getCords() {
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