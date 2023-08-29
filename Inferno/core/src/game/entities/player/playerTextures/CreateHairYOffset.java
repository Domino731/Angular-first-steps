package game.entities.player.playerTextures;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.entities.player.PlayerTextures;

import static utils.TxtUtils.getPixmapFromTextureRegion;

public class CreateHairYOffset {
    public static int[][] create(TextureRegion[][] bodyTextures) {
        int[][] data = new int[PlayerTextures.ANIMATION_AMOUNT][PlayerTextures.MAX_ANIMATION_FRAMES];


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
                        int a = (pixel & 0x000000ff);

                        if (a != 0) {
                            data[i][j] = y;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(data[4][5]);
        return data;
    }
}
