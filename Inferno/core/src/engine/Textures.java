package engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;

public class Textures {
    public static final Texture minesTxt = new Texture(Urls.SPRITE_MINES);
    public static final Texture debrisTxt = new Texture(Urls.SPRITE_DEBRIS);
    public static final Texture checkbox = new Texture(Urls.TXT_INVENTORY_SLOT);
    public static final Texture frameTxt = new Texture(Urls.TXT_FRAME);

    public static final TextureRegion slotTxt = new TextureRegion(new Texture(Urls.TXT_INVENTORY_SLOT), 48, 48);
    public static final TextureRegion slotActiveTxt = new TextureRegion(new Texture(Urls.TXT_INVENTORY_ACTIVE_SLOT), 48, 48);
    public static final TextureRegion woodTxtRg = new TextureRegion(debrisTxt, 16, 270, 16, 16);
}
