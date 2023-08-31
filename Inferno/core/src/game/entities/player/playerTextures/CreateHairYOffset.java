package game.entities.player.playerTextures;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.entities.player.PlayerTextures;

import java.util.Arrays;

import static utils.TxtUtils.getPixmapFromTextureRegion;

public class CreateHairYOffset {
    public static Integer[][] create(TextureRegion[][] bodyTextures) {
        Integer[][] data = new Integer[PlayerTextures.ANIMATION_AMOUNT][PlayerTextures.MAX_ANIMATION_FRAMES];

        boolean t = false;
        for (int i = 0; i < bodyTextures.length; i++) {
            TextureRegion[] txts = bodyTextures[i];
            for (int j = 0; j < txts.length; j++) {
                if (txts[j] == null) {
                    break;
                }
                Pixmap pixmap = getPixmapFromTextureRegion(txts[j]);
                int width = pixmap.getWidth();
                int height = pixmap.getHeight();

                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int pixel = pixmap.getPixel(x, y);

                        if (pixel != 0) {
                            if (data[i][j] == null) {
                                data[i][j] = y;
                            }
                        }
                    }
                }
            }
        }
        // TODO: temporary solution, 3 and 7 arrays are empty :(
        data[3] = data[1];
        data[7] = data[5];
        return data;
    }

    public static Integer[][] createOffsetForHair(TextureRegion[][] bodyTextures) {
        Integer[][] data = new Integer[PlayerTextures.ANIMATION_AMOUNT][PlayerTextures.MAX_ANIMATION_FRAMES];

        boolean t = false;
        for (int i = 0; i < bodyTextures.length; i++) {
            TextureRegion[] txts = bodyTextures[i];
            for (int j = 0; j < txts.length; j++) {
                if (txts[j] == null) {
                    break;
                }
                Pixmap pixmap = getPixmapFromTextureRegion(txts[j]);
                int width = pixmap.getWidth();
                int height = pixmap.getHeight();

                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int pixelColor = pixmap.getPixel(x, y);

                        // Check if the pixel is non-transparent
                        if ((pixelColor & 0x000000FF) != 0) {
                            data[i][j] = y;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.toString(data[PlayerTextures.STATE_RUNNING_RIGHT]));
        return data;
    }
}
