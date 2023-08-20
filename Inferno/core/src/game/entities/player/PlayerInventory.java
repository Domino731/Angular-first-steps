package game.entities.player;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import game.entities.player.inventory.InventoryConstants;
import game.entities.player.inventory.InventoryItem;
import game.entities.player.inventory.InventorySlot;

public class PlayerInventory {
    private Stage stage;
    private InventorySlot[] inventorySlots = new InventorySlot[InventoryConstants.inventoryLength];
    private InventoryItem[] inventoryItems = new InventoryItem[InventoryConstants.inventoryLength];
    private byte currentSlot;
    public InventoryItem currentItem;

    public PlayerInventory() {
        stage = new Stage(new ScreenViewport());
        createInventorySlots();
        createInventoryItems();
        changeCurrentSlot((byte) 3);
    }

    private void createInventoryItems() {
        for (int i = 0; i < InventoryConstants.inventoryLength; i++) {
            inventoryItems[i] = new InventoryItem("stone_pickaxe");
            inventoryItems[i].setPosition(i * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
            stage.addActor(inventoryItems[i]);
        }
    }

    private void createInventorySlots() {
        for (int i = 0; i < InventoryConstants.inventoryLength; i++) {
            inventorySlots[i] = new InventorySlot();
            inventorySlots[i].setPosition(i * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
            stage.addActor(inventorySlots[i]);
        }
    }

    public void changeCurrentSlot(byte slot) {
        currentSlot = slot;
        currentItem = inventoryItems[slot];
        markCurrentSlot();
    }

    public void markCurrentSlot() {
        for (int i = 0; i < inventorySlots.length; i++) {
            inventorySlots[i].markSlot(i == currentSlot);
        }
    }

    public byte getCurrentSlot() {
        return currentSlot;
    }

    public void draw() {
        stage.draw();
    }


}
