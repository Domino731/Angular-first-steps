package game.player.style;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.player.playerTextures.PlayerTextures;
import game.player.style.data.HatsNames;

public class PlayerStyle {
    public TextureRegion[] hairArray = PlayerTextures.getHair("1");
    public TextureRegion[] hatsArray = PlayerTextures.getHat(HatsNames.TEST_1);
    public TextureRegion[] shirtsArray = PlayerTextures.getShirts();
}
