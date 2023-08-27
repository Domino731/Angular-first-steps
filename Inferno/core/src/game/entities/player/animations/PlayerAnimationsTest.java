package game.entities.player.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.entities.player.Player;
import game.entities.player.PlayerTextures;

public class PlayerAnimationsTest {
    Player player;
    public TextureRegion[][] bodyTextures;
    public TextureRegion[][] armsTextures;
    TextureRegion weaponTexture = loadWeaponTexture();
    TextureRegion weaponTextureReversed = loadWeaponTextureReversed();

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

    private TextureRegion loadWeaponTextureReversed() {
        Texture txt = new Texture(Urls.weapons);
        TextureRegion txtRg = new TextureRegion(txt, 16 * 7, 16 * 5, 16, 16);
        txtRg.flip(true, false);
        return txtRg;
    }

    public void harvestWeedUp(SpriteBatch sb) {
        sb.draw(weaponTexture, (player.finalPosition.x - 50) - 10, player.finalPosition.y + 7, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 135);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][0], player.finalPosition.x - 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][0], player.finalPosition.x - 50, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x - 25) - 6, player.finalPosition.y + 16, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 70);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][1], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][1], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x) - 1, player.finalPosition.y + 20, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 50);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][2], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][2], player.finalPosition.x, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x + 25) + 8, player.finalPosition.y + 20, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 26);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][3], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][3], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x + 50) + 14, player.finalPosition.y + 18, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 3);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][4], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][4], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x + 75) + 17, player.finalPosition.y + 12, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -27);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
    }

    public void harvestWeedDown(SpriteBatch sb) {
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][0], player.finalPosition.x - 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][0], player.finalPosition.x - 50, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x - 50) + 16, player.finalPosition.y + 6, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -28);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][1], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][1], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x - 25) + 11, player.finalPosition.y - 6, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -90);
//
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][2], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][2], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x) + 8, player.finalPosition.y - 8, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -100);
//
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][3], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][3], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x + 25) - 3, player.finalPosition.y - 11, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -130);
//
//
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][4], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][4], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x + 50) - 11, player.finalPosition.y - 11, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -170);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x + 75) - 12, player.finalPosition.y - 9, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -170);
    }

    public void harvestWeedRight(SpriteBatch sb) {
        sb.draw(weaponTexture, (player.finalPosition.x - 25), (player.finalPosition.y + 20) + 4, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 45);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x) + 13, (player.finalPosition.y + 20) - 4, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 0);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x + 25) + 17, (player.finalPosition.y + 3), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -50);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);

        sb.draw(weaponTexture, (player.finalPosition.x + 50) + 14, (player.finalPosition.y - 6), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -90);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);


        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x + 75) + 2, (player.finalPosition.y - 10), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -130);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x + 75) - 6, (player.finalPosition.y - 11), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -146);
    }

    public void harvestWeedLeft(SpriteBatch sb) {
        sb.draw(weaponTextureReversed, (player.finalPosition.x - 25), (player.finalPosition.y + 20) + 4, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, -45);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][0], player.finalPosition.x - 25, player.finalPosition.y, 16, 32);

        sb.draw(weaponTextureReversed, (player.finalPosition.x) - 13, (player.finalPosition.y + 20) - 4, weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 0);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][1], player.finalPosition.x, player.finalPosition.y, 16, 32);

        sb.draw(weaponTextureReversed, (player.finalPosition.x + 25) - 17, (player.finalPosition.y + 3), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 50);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][2], player.finalPosition.x + 25, player.finalPosition.y, 16, 32);

        sb.draw(weaponTextureReversed, (player.finalPosition.x + 50) - 14, (player.finalPosition.y - 6), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 90);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][3], player.finalPosition.x + 50, player.finalPosition.y, 16, 32);


        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][4], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(weaponTextureReversed, (player.finalPosition.x + 75) - 2, (player.finalPosition.y - 10), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 130);

        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][5], player.finalPosition.x + 75, player.finalPosition.y, 16, 32);
        sb.draw(weaponTextureReversed, (player.finalPosition.x + 75) + 6, (player.finalPosition.y - 11), weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, 146);
    }
}
