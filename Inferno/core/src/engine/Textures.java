package engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;

public class Textures {
    public static final TextureRegion slotTxt = new TextureRegion(new Texture(Urls.TXT_INVENTORY_SLOT), 48, 48);
    public static final TextureRegion slotActiveTxt = new TextureRegion(new Texture(Urls.TXT_INVENTORY_ACTIVE_SLOT), 48, 48);
    public static final Texture minesTxt = new Texture(Urls.MINES);
}
