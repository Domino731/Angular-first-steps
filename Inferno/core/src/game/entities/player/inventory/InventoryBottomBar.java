package game.entities.player.inventory;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import engine.Textures;

import static game.entities.player.inventory.InventoryConstants.*;

public class InventoryBottomBar extends Actor {
    private final byte paddingVertical = 10;
    private final byte paddingHorizontal = 20;
    private final Texture texture = createTexture();
    private final short inventoryHeight = slotSize + (2 * paddingVertical);
    private final short inventoryWidth = (inventoryLength * slotSize) + (2 * paddingHorizontal);

    public InventoryBottomBar() {
        setWidth(20);
        setHeight(20);
        setX(inventorySlotBarXOffset - (paddingHorizontal / 2));
        setY(20);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // lanes
       batch.draw(texture, getX(), getY());
       batch.draw(Textures.hudFrameLaneTop, getX(), getY() + inventoryHeight, inventoryWidth, 15);
       batch.draw(Textures.hudFrameLaneLeft, getX() - 15, getY(), 15, inventoryHeight);
       batch.draw(Textures.hudFrameLaneRight, getX() + inventoryWidth, getY(), 15, inventoryHeight);
       batch.draw(Textures.hudFrameLaneBottom, getX(), getY() - 15, inventoryWidth, 15);

       // corners
        batch.draw(Textures.hudFrameCorner, getX() - 20, getY() - 20, 20, 20);
        batch.draw(Textures.hudFrameCorner, getX() - 20, getY() + inventoryHeight, 20, 20);
        batch.draw(Textures.hudFrameCorner, getX() + inventoryWidth, getY() - 20, 20, 20);
        batch.draw(Textures.hudFrameCorner, getX() + inventoryWidth, getY() + inventoryHeight, 20, 20);
    }


    private Texture createTexture() {
        Pixmap pixmap = new Pixmap( inventoryWidth, inventoryHeight, Pixmap.Format.RGBA8888 );
        pixmap.setColor( -3573249 );
        pixmap.fillRectangle(0, 0, inventoryWidth, inventoryHeight);
        Texture pixmaptex = new Texture( pixmap );
        pixmap.dispose();

        return pixmaptex;
    }

}
