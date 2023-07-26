package environment.trees;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TreeConstants {
    public final static byte STAGE_AMOUNT = 4;

    public final static byte FINAL_SPRING = 0;
    public final static byte FINAL_SUMMER = 1;
    public final static byte FINAL_AUTUMN = 2;
    public final static byte FINAL_WINTER = 3;

    public final static byte FINAL_STAGE_HEIGHT = 96;
    public final static byte FINAL_STAGE_WIDTH = 48;

    public static TextureRegion[] createTreeTextureRegions(Texture texture) {
        TextureRegion[] textureRegions = new TextureRegion[TreeConstants.STAGE_AMOUNT];
        textureRegions[TreeConstants.FINAL_SPRING] = new TextureRegion(texture, TreeConstants.FINAL_SPRING * TreeConstants.FINAL_STAGE_WIDTH, 0, TreeConstants.FINAL_STAGE_WIDTH, TreeConstants.FINAL_STAGE_HEIGHT);
        textureRegions[TreeConstants.FINAL_SUMMER] = new TextureRegion(texture, TreeConstants.FINAL_SUMMER * TreeConstants.FINAL_STAGE_WIDTH, 0, TreeConstants.FINAL_STAGE_WIDTH, TreeConstants.FINAL_STAGE_HEIGHT);
        textureRegions[TreeConstants.FINAL_AUTUMN] = new TextureRegion(texture, TreeConstants.FINAL_AUTUMN * TreeConstants.FINAL_STAGE_WIDTH, 0, TreeConstants.FINAL_STAGE_WIDTH, TreeConstants.FINAL_STAGE_HEIGHT);
        textureRegions[TreeConstants.FINAL_WINTER] = new TextureRegion(texture, TreeConstants.FINAL_WINTER * TreeConstants.FINAL_STAGE_WIDTH, 0, TreeConstants.FINAL_STAGE_WIDTH, TreeConstants.FINAL_STAGE_HEIGHT);
        return textureRegions;
    }
}
