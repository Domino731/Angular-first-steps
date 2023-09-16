package engine.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DropItemData {
    private TextureRegion txt;
    private String itemId;

    public DropItemData( String itemId, TextureRegion txt) {
        this.txt = txt;
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public TextureRegion getTxt() {
        return txt;
    }
}
