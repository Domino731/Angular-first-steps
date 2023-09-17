package game.entities.player.inventory.examples;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.entities.player.inventory.InventoryItemData;
import game.entities.player.inventory.InventoryItemGroups;

public class PlantSeed implements InventoryItemData {
    private final TextureRegion texture;
    private final TextureRegion[] textures;
    private final InventoryItemGroups group = InventoryItemGroups.seed;

    public PlantSeed() {
        texture = new TextureRegion(new Texture(Urls.SPRITE_SEEDS));
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
        return group;
    }

    @Override
    public String getId(){
        return "SEED";
    }
}
