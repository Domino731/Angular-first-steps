package game.entities.player.style;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.entities.player.playerTextures.PlayerTextures;
import game.entities.player.style.data.HatsNames;

public class PlayerStyle {
    public TextureRegion[] hairArray = PlayerTextures.getHair("1");
    public TextureRegion[] hatsArray = PlayerTextures.getHat(HatsNames.TEST_1);
    public TextureRegion[] shirtsArray = PlayerTextures.getShirts();
}
