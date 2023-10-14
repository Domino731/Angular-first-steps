package game.entities.player.style.paintTextures;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

import static game.entities.player.PlayerConstants.*;
import static game.entities.player.style.paintTextures.Utils.*;

public class PaintTextures {
    public TextureRegion[][] createPantsWithColor(TextureRegion[][] pants, TextureRegion shirtTxtRg) {
        return createPants(pants, getColorsMapForPants(shirtTxtRg));
    }

    public TextureRegion[][] createShirtSleevesWithColors(TextureRegion[][] arms, TextureRegion shirtTxtRg) {
        return createPants(arms, getColorsMapForSleeves(shirtTxtRg));
    }

    public TextureRegion[][] createPants(TextureRegion[][] pants, HashMap<Integer, Integer> colorsMap) {
        TextureRegion[][] newArms = new TextureRegion[ANI_AMOUNT][ANI_MAX_FRAMES];
        for (int i = 0; i < pants.length; i++) {
            TextureRegion[] armsTxtRg = pants[i];
            // skip reversed textures
            if (i == ANI_RUNNING_LEFT) {
                armsTxtRg = pants[ANI_RUNNING_RIGHT];
            }
            if (i == ANI_IDLE_LEFT) {
                armsTxtRg = pants[ANI_IDLE_RIGHT];
            }
            if (i == ANI_MINE_LEFT) {
                armsTxtRg = pants[ANI_MINE_RIGHT];
            }
            if (i == ANI_HARVEST_LEFT) {
                armsTxtRg = pants[ANI_HARVEST_RIGHT];
            }
            if (i == ANI_IDLE_ITEM_LEFT) {
                armsTxtRg = pants[ANI_IDLE_ITEM_RIGHT];
            }
            if (i == ANI_RUNNING_ITEM_LEFT) {
                armsTxtRg = pants[ANI_RUNNING_ITEM_RIGHT];
            }

            for (int j = 0; j < armsTxtRg.length; j++) {
                TextureRegion armTxtRg = armsTxtRg[j];
                if (armTxtRg != null) {
                    newArms[i][j] = getPaintedTexture(armTxtRg, colorsMap);
                }
            }
        }
        for (byte aniIndex : REVERSED_TEXTURES_INDICES) {
            TextureRegion[] textures = newArms[aniIndex];
            for (TextureRegion txt : textures) {
                if (txt != null) {
                    txt.flip(true, false);
                }
            }
        }
        return newArms;
    }
}