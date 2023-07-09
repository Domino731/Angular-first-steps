package engine.spritesLoader;

import engine.utils.EngineLog;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpritesLoader {
    private Map<String, BufferedImage> spritesData = new HashMap<String, BufferedImage>();

    public SpritesLoader() {

    }

    public Map<String, BufferedImage> load(List<String> spriteNames) {
            for(String spriteName : spriteNames){
                InputStream is = getClass().getResourceAsStream(Utils.getSpriteSource(spriteName));
                try {
                    spritesData.put(spriteName, ImageIO.read(is));
                }
                catch (IOException error) {
                    EngineLog.resourceError("SpriteLoader.load()");
                }
            }

        return spritesData;
    }

    public Map<String, BufferedImage> getSpritesData() {
        return spritesData;
    }
}
