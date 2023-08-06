package utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

import static utils.TxtUtils.getPixmapFromTextureRegion;

// TODO: delete
public class TxtPainter {
    public static TextureRegion paint(TextureRegion colorSource, TextureRegion arm, int[] skipColors) {
        int[] sourceColors = TxtUtils.getColors(colorSource, true);
        int[] targetColors = TxtUtils.getColors(arm, true);
        HashMap<Integer, Integer> colorsList = new HashMap<>();

        int index = 0;
        for (int i = 0; i < targetColors.length; i++) {
            if (!ArrayUtils.contains(skipColors, targetColors[i])) {
                colorsList.put(targetColors[i], sourceColors[4]);
                index++;
            }
        }

        Pixmap pixmap = getPixmapFromTextureRegion(arm);

        for (int x = 0; x < pixmap.getWidth(); x++) {
            for (int y = 0; y < pixmap.getHeight(); y++) {
                // Get the current pixel color
                int colorInt = pixmap.getPixel(x, y);

                // Extract the RGB components
                int r = (colorInt & 0xff000000) >>> 24; // Red component (8 bits)
                int g = (colorInt & 0x00ff0000) >>> 16; // Green component (8 bits)
                int b = (colorInt & 0x0000ff00) >>> 8;  // Blue component (8 bits)
                int a = colorInt & 0x000000ff;         // Alpha component (8 bits)

                if (colorInt == 0) {
                    System.out.println(colorInt);
                } else {
                    if (!ArrayUtils.contains(skipColors, colorInt)) {
                        pixmap.drawPixel(x, y, colorsList.get(colorInt));
                    }

                }


            }
        }

        Texture newTxt = new Texture(pixmap);
        return new TextureRegion(newTxt);
    }
}
