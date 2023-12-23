package game.player.style.paintTextures;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.player.PlayerConstants;

import java.util.HashMap;

public class PaintTextures {
    public TextureRegion[][] createPantsWithColor(TextureRegion[][] pants, TextureRegion shirtTxtRg) {
        return createPants(pants, Utils.getColorsMapForPants(shirtTxtRg));
    }

    public TextureRegion[][] createShirtSleevesWithColors(TextureRegion[][] arms, TextureRegion shirtTxtRg) {
        return createPants(arms, Utils.getColorsMapForSleeves(shirtTxtRg));
    }

    public TextureRegion[][] createPants(TextureRegion[][] pants, HashMap<Integer, Integer> colorsMap) {
        TextureRegion[][] newArms = new TextureRegion[PlayerConstants.ANI_AMOUNT][PlayerConstants.ANI_MAX_FRAMES];
        for (int i = 0; i < pants.length; i++) {
            TextureRegion[] armsTxtRg = pants[i];
            // skip reversed textures
            if (i == PlayerConstants.ANI_RUNNING_LEFT) {
                armsTxtRg = pants[PlayerConstants.ANI_RUNNING_RIGHT];
            }
            if (i == PlayerConstants.ANI_IDLE_LEFT) {
                armsTxtRg = pants[PlayerConstants.ANI_IDLE_RIGHT];
            }
            if (i == PlayerConstants.ANI_MINE_LEFT) {
                armsTxtRg = pants[PlayerConstants.ANI_MINE_RIGHT];
            }
            if (i == PlayerConstants.ANI_HARVEST_LEFT) {
                armsTxtRg = pants[PlayerConstants.ANI_HARVEST_RIGHT];
            }
            if (i == PlayerConstants.ANI_IDLE_ITEM_LEFT) {
                armsTxtRg = pants[PlayerConstants.ANI_IDLE_ITEM_RIGHT];
            }
            if (i == PlayerConstants.ANI_RUNNING_ITEM_LEFT) {
                armsTxtRg = pants[PlayerConstants.ANI_RUNNING_ITEM_RIGHT];
            }

            for (int j = 0; j < armsTxtRg.length; j++) {
                TextureRegion armTxtRg = armsTxtRg[j];
                if (armTxtRg != null) {
                    newArms[i][j] = Utils.getPaintedTexture(armTxtRg, colorsMap);
                }
            }
        }
        for (byte aniIndex : PlayerConstants.REVERSED_TEXTURES_INDICES) {
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