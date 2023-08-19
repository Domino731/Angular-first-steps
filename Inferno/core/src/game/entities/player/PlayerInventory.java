package game.entities.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import constants.Urls;

public class PlayerInventory {
    private Stage stage;

    public PlayerInventory() {
        stage = new Stage(new ScreenViewport());
        TextureRegion slotTexture = new TextureRegion(new Texture(Urls.checkboxImg), 48, 48);
        InventorySlot inventorySlot = new InventorySlot(slotTexture);
        inventorySlot.setPosition(10, 10); // Set position as needed
        stage.addActor(inventorySlot);
    }

    public void draw() {
        stage.draw();
    }

    public class InventorySlot extends Actor {
        private TextureRegion slotTexture;

        public InventorySlot(TextureRegion slotTexture) {
            this.slotTexture = slotTexture;
            setWidth(slotTexture.getRegionWidth());
            setHeight(slotTexture.getRegionHeight());
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            batch.draw(slotTexture, getX(), getY());
        }
    }


}
