package game.entities.player;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import game.entities.player.inventory.InventoryConstants;
import game.entities.player.inventory.InventorySlot;

public class PlayerInventory {
    private Stage stage;
    private InventorySlot[] inventorySlots = new InventorySlot[InventoryConstants.inventoryLength];

    public PlayerInventory() {
        stage = new Stage(new ScreenViewport());
        createInventorySlots();
    }

    private void createInventorySlots() {
        for (int i = 0; i < InventoryConstants.inventoryLength; i++) {
            inventorySlots[i] = new InventorySlot();
            inventorySlots[i].setPosition(i * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
            stage.addActor(inventorySlots[i]);
        }
    }

    public void draw() {
        stage.draw();
    }


}
