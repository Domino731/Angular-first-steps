package game.entities.player.inventory.examples;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.entities.player.inventory.InventoryItemData;
import game.entities.player.inventory.InventoryItemTypes;

public class PlantSeed implements InventoryItemData {
    private final TextureRegion texture;
    private final TextureRegion[] textures;
    private final InventoryItemTypes type = InventoryItemTypes.seed;

    public PlantSeed() {
        texture = new TextureRegion(new Texture(Urls.seeds));
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
    public InventoryItemTypes getType() {
        return type;
    }
}
