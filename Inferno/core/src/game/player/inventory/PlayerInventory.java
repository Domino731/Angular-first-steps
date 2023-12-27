package game.player.inventory;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import engine.fonts.actionCollision.ActionTypes;
import engine.items.Items;
import game.player.inventory.examples.PlantSeed;
import game.player.inventory.examples.Weapon;

import java.util.Objects;

public class PlayerInventory {
    private Stage stage;
    private InventorySlot[] inventorySlots = new InventorySlot[InventoryConstants.inventoryLength];
    private InventoryItem[] inventoryItems = new InventoryItem[InventoryConstants.inventoryLength];
    private byte currentSlot;
    public InventoryItem currentItem;
    private InventoryBottomBar bottomBar = new InventoryBottomBar();

    public PlayerInventory() {
        stage = new Stage(new ScreenViewport());
        stage.addActor(bottomBar);
        createInventorySlots();
        createInventoryItems();
        changeCurrentSlot((byte) 3);
        addItem("wood", (byte) 1);

    }

    // TODO: only for test purposes
    private void createInventoryItems() {
        inventoryItems[0] = new InventoryItem(new Weapon());
        inventoryItems[0].setPosition(0 * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
        inventoryItems[0].slotData.setPosition(0 * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
        inventoryItems[0].slotData.setAmount((byte) 12);
        stage.addActor(inventoryItems[0]);
        stage.addActor(inventoryItems[0].slotData);

        inventoryItems[1] = new InventoryItem(new PlantSeed());
        inventoryItems[1].setPosition(InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
        stage.addActor(inventoryItems[1]);

        inventoryItems[2] = new InventoryItem("stone_pickaxe");
        inventoryItems[2].setPosition(2 * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
        stage.addActor(inventoryItems[2]);
        stage.getRoot().removeActor(inventoryItems[4]);
        inventoryItems[4] = null;
    }

    private void createInventorySlots() {
        for (int i = 0; i < InventoryConstants.inventoryLength; i++) {
            inventorySlots[i] = new InventorySlot();
            inventorySlots[i].setPosition(i * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
            stage.addActor(inventorySlots[i]);
        }
    }

    private Byte findFirstEmptySlotIndex() {
        Byte payload = null;
        for (int i = 0; i < inventoryItems.length; i++) {
            if (inventoryItems[i] == null) {
                payload = (byte) i;
                break;
            }
        }
        return payload;
    }

    public void addItem(String itemId, byte amount) {
        Byte emptySlotIndex = findFirstEmptySlotIndex();
        if (emptySlotIndex == null) {
            System.out.println("There is no empty slot in player inventory");
            return;
        }

        byte inventoryItemIndex = getInventoryItemIndex(itemId);

        if (inventoryItemIndex != -1) {
            byte currentItemAmount = inventoryItems[inventoryItemIndex].getAmount();
            inventoryItems[inventoryItemIndex].setAmount((byte) (currentItemAmount + amount));
            return;
        }
        inventoryItems[emptySlotIndex] = new InventoryItem(Items.getData(itemId));
        inventoryItems[emptySlotIndex].setPosition(emptySlotIndex * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
        inventoryItems[emptySlotIndex].slotData.setPosition(emptySlotIndex * InventoryConstants.slotSize + InventoryConstants.inventorySlotsXOffset, InventoryConstants.inventorySlotsYOffset);
        stage.addActor(inventoryItems[emptySlotIndex]);
        stage.addActor(inventoryItems[emptySlotIndex].slotData);

    }

    public byte getInventoryItemIndex(String itemId) {
        byte index = -1;

        for (int i = 0; i < inventoryItems.length - 1; i++) {
            if (inventoryItems[i] != null && Objects.equals(inventoryItems[i].getId(), itemId)) {
                index = (byte) i;
            }
        }

        return index;
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

    public InventoryItemGroups getCurrItemType() {
        if (currentItem == null) {
            return null;
        }
        return currentItem.getType();
    }

    public ActionTypes getCurrItemActionType() {
        return ActionTypes.CUT_TREE;
    }

    public void draw() {
        stage.draw();
    }


}
