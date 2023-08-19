package game.entities.player.inventory;

import com.badlogic.gdx.Gdx;

public class InventoryConstants {
    public static final byte inventoryLength = 10;
    public static final byte slotSize = 60;
    public static final byte inventorySlotsYOffset = 20;
    public static final int inventorySlotsXOffset = getXOffset();

    public static short getInventoryBarWidth() {
        return inventoryLength * slotSize;
    }

    public static int getXOffset() {
        return (Gdx.graphics.getWidth() / 2) - (getInventoryBarWidth() / 2);
    }

}
