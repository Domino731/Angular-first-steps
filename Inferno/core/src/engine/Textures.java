package engine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;

public class Textures {
    public static final Texture minesTxt = new Texture(Urls.SPRITE_MINES);
    public static final Texture debrisTxt = new Texture(Urls.SPRITE_DEBRIS);
    public static final Texture bushesTxt = new Texture(Urls.SPRITE_BUSHES);
    public static final Texture checkbox = new Texture(Urls.TXT_INVENTORY_SLOT);
    public static final Texture frameTxt = new Texture(Urls.TXT_FRAME);
    public static final Texture fontsTxt = new Texture(Urls.TXT_FONTS);
    public static final Texture blackBoxTxt = new Texture(Urls.TXT_BLACK_BOX);

    public static final TextureRegion slotTxt = new TextureRegion(new Texture(Urls.TXT_INVENTORY_SLOT), 48, 48);
    public static final TextureRegion slotActiveTxt = new TextureRegion(new Texture(Urls.TXT_INVENTORY_ACTIVE_SLOT), 48, 48);
    public static final TextureRegion woodTxtRg = new TextureRegion(debrisTxt, 16, 270, 16, 16);
    public static final Texture hudFrameLaneTop = new Texture(Urls.TXT_INVENTORY_FRAME_LANE);
    public static final Texture hudFrameLaneRight = new Texture(Urls.TXT_INVENTORY_FRAME_LANE_RIGHT);
    public static final Texture hudFrameLaneBottom = new Texture(Urls.TXT_INVENTORY_FRAME_LANE_BOTTOM);
    public static final Texture hudFrameLaneLeft = new Texture(Urls.TXT_INVENTORY_FRAME_LANE_LEFT);
    public static final Texture hudFrameCorner = new Texture(Urls.TXT_INVENTORY_FRAME_CORNER);
    public static final Texture treesSprite = new Texture(Urls.TXT_INVENTORY_FRAME_CORNER);
}
