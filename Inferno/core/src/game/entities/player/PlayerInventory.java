package game.entities.player;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import game.entities.player.inventory.InventoryConstants;
import game.entities.player.inventory.InventoryItem;
import game.entities.player.inventory.InventoryItemGroups;
import game.entities.player.inventory.InventorySlot;
import game.entities.player.inventory.examples.PlantSeed;
import game.entities.player.inventory.examples.Weapon;

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

    // TODO: only for test purposes
    private void createInventoryItems() {
        for (int i = 0; i < InventoryConstants.inventoryLength; i++) {

            if (i == 7) {
                inventoryItems[i] = new InventoryItem(new Weapon());
            } else if (i == 6) {
                inventoryItems[i] = new InventoryItem(new PlantSeed());
            } else {
                inventoryItems[i] = new InventoryItem("stone_pickaxe");
            }
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
        System.out.println("SLOT CHANGED");
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

    public InventoryItemGroups getCurrItemType() {
        return currentItem.getType();
    }

    public void draw() {
        stage.draw();
    }


}
