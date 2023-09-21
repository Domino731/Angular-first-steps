package game.entities.player.inventory;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import engine.fonts.Fonts;

import static engine.utils.ArrayUtils.reverseStringArray;
import static game.entities.player.inventory.InventoryConstants.slotSize;

public class InventorySlotData extends Actor {
    private byte amount;
    private String[] amountLetters = {};
    public InventorySlotData() {
        setWidth(20);
        setHeight(20);
    }

    public void setAmount(byte amountValue) {
        amount =amountValue;
        amountLetters = String.valueOf(amountValue).split("");
        reverseStringArray(amountLetters);
    }

    // TODO: save cords in array
    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = amountLetters.length - 1; i >= 0; i--) {
            batch.draw(Fonts.getBlackLetter1(amountLetters[i]), (getX() + slotSize) - (i * 14) - 20, getY() - 10, 14, 20 );
        }
    }

    public byte getAmount() {
        return amount;
    }
}
