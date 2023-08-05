package utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TxtUtils {

    public static int findMainColor(TextureRegion textureRegion) {
        Pixmap pixmap = getPixmapFromTextureRegion(textureRegion);

        int width = pixmap.getWidth();
        int height = pixmap.getHeight();
        int[] histogram = new int[256];

        ArrayList<Integer> colorsList = new ArrayList<>();

        // Calculate the histogram of color occurrences within the TextureRegion
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixmap.getPixel(x, y);
                int r = (pixel & 0xff000000) >>> 24;
                int g = (pixel & 0x00ff0000) >>> 16;
                int b = (pixel & 0x0000ff00) >>> 8;
                int a = (pixel & 0x000000ff);

                // Ignore pixels that are completely transparent
                if (a != 0) {
                    colorsList.add(pixel);
                    int luminance = (r + g + b) / 3;
                    histogram[luminance]++;
                }
            }
        }

        pixmap.dispose(); // Dispose of the Pixmap once we're done with it

        return findMostFrequentElement(colorsList);
    }

    public static int findMostFrequentElement(ArrayList<Integer> list) {
        Map<Integer, Integer> elementCount = new HashMap<>();

        // Zliczanie wystąpień każdego elementu
        for (int element : list) {
            elementCount.put(element, elementCount.getOrDefault(element, 0) + 1);
        }

        int mostFrequentElement = 0;
        int maxCount = 0;

        // Szukanie elementu o największej liczbie wystąpień
        for (Map.Entry<Integer, Integer> entry : elementCount.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                mostFrequentElement = element;
                maxCount = count;
            }
        }

        return mostFrequentElement;
    }

    public static Pixmap getPixmapFromTextureRegion(TextureRegion textureRegion) {
        // Get the dimensions of the TextureRegion
        int regionWidth = textureRegion.getRegionWidth();
        int regionHeight = textureRegion.getRegionHeight();

        // Create a new Pixmap with the same dimensions as the TextureRegion
        Pixmap pixmap = new Pixmap(regionWidth, regionHeight, Pixmap.Format.RGBA8888);

        // Get the pixel data from the TextureRegion
        Texture texture = textureRegion.getTexture();
        texture.getTextureData().prepare();
        Pixmap texturePixmap = texture.getTextureData().consumePixmap();

        // Copy the pixel data from the TextureRegion to the Pixmap
        pixmap.drawPixmap(texturePixmap, 0, 0, textureRegion.getRegionX(), textureRegion.getRegionY(),
                regionWidth, regionHeight);

        // Release the temporary Pixmap (optional, but recommended)
        texturePixmap.dispose();

        return pixmap;
    }
}

