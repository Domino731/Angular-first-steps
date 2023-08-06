package game.entities.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static utils.TxtUtils.getPixmapFromTextureRegion;

public class PlayerShirtsData {
    private HashMap<Integer, Integer> colors = new HashMap<>();

    public PlayerShirtsData(TextureRegion shirtTxtRg) {
        setColorsBasedOnShirt(shirtTxtRg);
    }

    private void setColorsBasedOnShirt(TextureRegion shirtTxtRg) {
        Pixmap pixmap = getPixmapFromTextureRegion(shirtTxtRg);

        int width = pixmap.getWidth();
        int height = pixmap.getHeight();

        ArrayList<Integer> colorsList = new ArrayList<>();
        int borderColor = 0;

        // Calculate the histogram of color occurrences within the TextureRegion
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixmap.getPixel(x, y);
                int r = (pixel & 0xff000000) >>> 24;
                int g = (pixel & 0x00ff0000) >>> 16;
                int b = (pixel & 0x0000ff00) >>> 8;
                int a = (pixel & 0x000000ff);

                // Ignore pixels that are completely transparent
                if (pixel != 0 && borderColor == 0) {
                    borderColor = pixel;
                }
                if (a != 0) {
                    colorsList.add(pixel);
                }
            }
        }

        // sorting by occurrences
        final Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (Integer number : colorsList) {
            occurrenceMap.put(number, occurrenceMap.getOrDefault(number, 0) + 1);
        }
        colorsList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return occurrenceMap.get(b) - occurrenceMap.get(a);
            }
        });

        // remove duplicates
        ArrayList<Integer> textureColors = new ArrayList<>();

        for (Integer color : colorsList) {
            if (!textureColors.contains(color)) {
                textureColors.add(color);
            }
        }

        System.out.println(textureColors);
    }

}