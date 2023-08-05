package utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class TxtUtils {
    public static Color findMainColor(TextureRegion textureRegion) {
        TextureRegion region = textureRegion;
        Texture texture = region.getTexture();

        Pixmap pixmap = new Pixmap(texture.getWidth(), texture.getHeight(), Pixmap.Format.RGBA8888);
        texture.getTextureData().prepare();
        Pixmap texturePixmap = texture.getTextureData().consumePixmap();
        pixmap.drawPixmap(texturePixmap, 0, 0);

        ArrayList<Color> colorsList = new ArrayList<>();

        for (int y = 0; y < pixmap.getHeight(); y++) {
            for (int x = 0; x < pixmap.getWidth(); x++) {
                Color color = new Color(pixmap.getPixel(x, y));
                colorsList.add(color);
            }
        }

        // Loop through the ArrayList using a traditional for loop
        for (int i = 0; i < colorsList.size(); i++) {
            Color item = colorsList.get(i);
            System.out.println(item);
        }

        return null;
    }

    private static Pixmap getPixmapFromTextureRegion(TextureRegion textureRegion) {
        int width = textureRegion.getRegionWidth();
        int height = textureRegion.getRegionHeight();

        Texture texture = textureRegion.getTexture();
        int x = textureRegion.getRegionX();
        int y = textureRegion.getRegionY();

        Pixmap sourcePixmap = new Pixmap(texture.getWidth(), texture.getHeight(), Pixmap.Format.RGBA8888);
        sourcePixmap.drawPixmap(texture.getTextureData().consumePixmap(), 0, 0);

        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.drawPixmap(sourcePixmap, 0, 0, x, y, width, height);
        sourcePixmap.dispose(); // Dispose of the source Pixmap

        return pixmap;
    }
}