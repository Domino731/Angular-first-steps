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
    public final byte weaponXOrigin = 16 / 2;
    public final byte weaponYOrigin = 16 / 2;

    public PlayerAnimationsTest(Player player) {
        this.player = player;
        bodyTextures = player.playerTextures.bodyTextures;
        armsTextures = player.playerTextures.armsTextures;
    }

    private TextureRegion loadWeaponTexture() {
        Texture txt = new Texture(Urls.weapons);
        return new TextureRegion(txt, 16 * 7, 16 * 5, 16, 16);
    }

    public void harvestWeedRight(SpriteBatch sb) {
//        sb.draw(weaponTexture, (player.finalPosition.x - 25) + 3, (player.finalPosition.y + 20) + 4, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 40);
//        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
//        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
//
//        sb.draw(weaponTexture, (player.finalPosition.x) + 13, (player.finalPosition.y + 20) - 4, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 0);
//        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);
//        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);

//        sb.draw(weaponTexture, (player.finalPosition.x + 25) + 17, (player.finalPosition.y + 3), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -50);
//        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
//        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);

//        sb.draw(weaponTexture, (player.finalPosition.x + 50) + 14, (player.finalPosition.y - 6), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -90);
//        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
//        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
//

//        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
//        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
//        sb.draw(weaponTexture, (player.finalPosition.x + 75) + 2, (player.finalPosition.y - 10), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -130);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x + 75) - 6, (player.finalPosition.y - 11), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -146);
    }
}
