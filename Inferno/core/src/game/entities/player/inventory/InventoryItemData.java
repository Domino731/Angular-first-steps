package game.entities.player.inventory;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface InventoryItemData {
    TextureRegion[] getTextures();

    TextureRegion getInventoryTxt();

    InventoryItemGroups getGroup();

    String getId();
}
