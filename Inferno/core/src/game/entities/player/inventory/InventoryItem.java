package game.entities.player.inventory;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import items.Items;

public class InventoryItem extends Actor {
    private TextureRegion txt;
    public TextureRegion[] downTextures;
    public TextureRegion[] upTextures;

    public InventoryItem(String itemId) {
        txt = Items.get(itemId).inventoryTxt;
        downTextures = Items.get(itemId).downTextures;
        upTextures = Items.get(itemId).upTextures;

        setWidth(48);
        setHeight(48);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(txt, getX(), getY(), InventoryConstants.slotSize, InventoryConstants.slotSize);
    }
}