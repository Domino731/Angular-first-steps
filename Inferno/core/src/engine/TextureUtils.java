package engine;

import com.badlogic.gdx.graphics.Texture;
import utils.EngineLog;

public class TextureUtils {
    public static Texture getTextureByName(String textureName) {
        switch (textureName) {
            case "bushes":
                return Textures.bushesTxt;
            case "mines":
                return Textures.minesTxt;
            default:
                EngineLog.error("getTextureByName: no match for passed texture name: " + textureName);
                return Textures.frameTxt;
        }
    }
}
