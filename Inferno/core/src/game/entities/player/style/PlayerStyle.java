package game.entities.player.style;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.entities.player.HatsNames;
import game.entities.player.PlayerTextures;

public class PlayerStyle {
    public TextureRegion[] hairArray = PlayerTextures.getHair("1");
    public TextureRegion[] hatsArray = PlayerTextures.getHat(HatsNames.TEST_1);
    public TextureRegion[] shirtsArray = PlayerTextures.getShirts();

    public PlayerStyle() {

    }
}
