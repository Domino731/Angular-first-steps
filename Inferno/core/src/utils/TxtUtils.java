package utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TxtUtils {

    /**
     * Create a pixmap based on texture region
     *
     * @param textureRegion - TextureRegion class you want to convert into a pixmap
     */
    public static Pixmap getPixmapFromTextureRegion(TextureRegion textureRegion) {
        // Get the dimensions of the TextureRegion
        int regionWidth = textureRegion.getRegionWidth();
        int regionHeight = textureRegion.getRegionHeight();

        // Create a new Pixmap with the same dimensions as the TextureRegion
        Pixmap pixmap = new Pixmap(regionWidth, regionHeight, Pixmap.Format.RGBA8888);

        // Get the pixel data from the TextureRegion
        Texture texture = textureRegion.getTexture();
        if (!texture.getTextureData().isPrepared()) {
            // Texture data is already prepared, you can use it
            texture.getTextureData().prepare();
        }
        Pixmap texturePixmap = texture.getTextureData().consumePixmap();

        // Copy the pixel data from the TextureRegion to the Pixmap
        pixmap.drawPixmap(texturePixmap, 0, 0, textureRegion.getRegionX(), textureRegion.getRegionY(),
                regionWidth, regionHeight);

        // Release the temporary Pixmap (optional, but recommended)
        texturePixmap.dispose();

        return pixmap;
    }
}

