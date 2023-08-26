package game.entities.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;

public class PlayerAnimationsTest {
    Player player;
    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    TextureRegion weaponTexture = loadWeaponTexture();

    public PlayerAnimationsTest(Player player) {
        this.player = player;
        bodyTextures = player.playerTextures.bodyTextures;
        armsTextures = player.playerTextures.armsTextures;
    }

    private TextureRegion loadWeaponTexture() {
        Texture txt = new Texture(Urls.weapons);
        return new TextureRegion(txt, 0, 0, 16, 16);
    }

    public void harvestWeedRight(SpriteBatch sb) {
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, player.finalPosition.x - 25, player.finalPosition.y, 16, 16);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
    }
}
