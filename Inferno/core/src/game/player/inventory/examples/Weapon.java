package game.player.inventory.examples;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.player.inventory.InventoryItemData;
import game.player.inventory.InventoryItemGroups;

public class Weapon implements InventoryItemData {
    private final TextureRegion texture;
    private final TextureRegion[] textures;
    private final InventoryItemGroups type = InventoryItemGroups.weapon;

    public Weapon() {
        texture = new TextureRegion(new Texture(Urls.SPRITE_WEAPONS), 16 * 7, 16 * 5, 16, 16);
        textures = new TextureRegion[1];
        textures[0] = texture;
    }

    @Override
    public TextureRegion[] getTextures() {
        return textures;
    }

    @Override
    public TextureRegion getInventoryTxt() {
        return texture;
    }

    @Override
    public InventoryItemGroups getGroup() {
        return type;
    }

    @Override
    public String getId() {
        return "SEED";
    }
}
