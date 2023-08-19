package game.entities.player.inventory;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import engine.Textures;

public class InventorySlot extends Actor {
    private TextureRegion slotTexture = Textures.slotTxt;

    public InventorySlot() {
        setWidth(slotTexture.getRegionWidth());
        setHeight(slotTexture.getRegionHeight());
    }

    public void markSlot(boolean mark) {
        if (!mark) {
            slotTexture = Textures.slotTxt;
        } else {
            slotTexture = Textures.slotActiveTxt;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(slotTexture, getX(), getY(), InventoryConstants.slotSize, InventoryConstants.slotSize);
    }
}