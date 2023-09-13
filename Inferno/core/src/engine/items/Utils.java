package engine.items;

import com.badlogic.gdx.graphics.Texture;
import engine.Textures;

public class Utils {
    public static Texture getItemTextureBySrc(String src) {
        if ("debris".equals(src)) {
            return Textures.debrisTxt;
        }
        return Textures.minesTxt;
    }
}
