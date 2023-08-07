package game.entities.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerStyle {
    private String hairId = "1";
    public TextureRegion[] hairArray = PlayerTextures.getHair(hairId);
    public TextureRegion[] hatsArray = PlayerTextures.getHat(HatsNames.TEST_1);
    public TextureRegion[] shirtsArray = PlayerTextures.getShirts();

    public PlayerStyle() {

    }
}
