package game.entities.player.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.entities.player.Player;
import game.entities.player.PlayerTextures;
import game.entities.player.animations.config.WeaponAnimationConfig;
import utils.Direction;
import utils.vectors.Vector;

public class PlayerAnimations {
    private Player player;
    private AnimationDraw[] animationDraws;
    private byte animationIndex = PlayerTextures.STATE_IDLE_DOWN;
    private Vector<Integer> finalPosition;
    int actionIndex;
    int aniIndex;
    TextureRegion[][] bodyTextures, armsTextures;
    TextureRegion weaponTexture = loadWeaponTexture();
    TextureRegion weaponTextureReversed = loadWeaponTextureReversed();

    public final byte weaponXOrigin = 16 / 2;
    public final byte weaponYOrigin = 16 / 2;

    public PlayerAnimations(Player player) {
        this.player = player;
        finalPosition = player.finalPosition;
        bodyTextures = player.playerTextures.bodyTextures;
        armsTextures = player.playerTextures.armsTextures;
        setAnimationDraws();
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

    public void running(SpriteBatch sb) {
        System.out.println(player.actionIndex);
        sb.draw(bodyTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
//          sb.draw(style.hairArray[hairTextureIndex], finalPosition.x, finalPosition.y + hairTextureYOffset, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
//          sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
//          sb.draw(playerTextures.pantsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 16);
//          sb.draw(style.shirtsArray[PlayerConstants.hatTextureIndex], finalPosition.x + 4, finalPosition.y + shirtYOffset, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(armsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
    }

    public void draw(SpriteBatch sb) {
        animationDraws[player.actionIndex].draw(sb);
    }

    private void setAnimationDraws() {
        AnimationDraw[] animations = new AnimationDraw[PlayerTextures.ANIMATION_AMOUNT];
        // set easy animations by loop
        for (int i = 0; i <= 7; i++) {
            animations[i] = new AnimationDraw() {
                @Override
                public void draw(SpriteBatch sb) {
                    running(sb);
                }
            };
        }
        animations[PlayerTextures.STATE_HARVEST_WEED_DOWN] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
//                drawHarvestWeedDown(sb);
//                drawHarvestWeedUp(sb);
//                drawHarvestWeedRight(sb);
                drawHarvestWeedLeft(sb);
            }
        };
        animationDraws = animations;

        ////        // HARVEST
        ////        public static final int STATE_HARVEST_UP = 8;
        ////        public static final int STATE_HARVEST_RIGHT = 9;
        ////        public static final int STATE_HARVEST_LEFT = 10;
        ////        public static final int STATE_MINE_RES = 11;
        ////        // HARVEST WEED
        ////        public static final int STATE_HARVEST_WEED_UP = 12;
        ////        public static final int STATE_HARVEST_WEED_RIGHT = 13;
        ////        public static final int STATE_HARVEST_WEED_LEFT = 14;
        ////        public static final int STATE_HARVEST_WEED_DOWN = 15;
//
    }

    private void drawHarvestWeedDown(SpriteBatch sb) {
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_DOWN][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(weaponTexture, (player.finalPosition.x) + WeaponAnimationConfig.animations[Direction.down][player.aniIndex][0], player.finalPosition.y + WeaponAnimationConfig.animations[Direction.down][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, WeaponAnimationConfig.animations[Direction.down][player.aniIndex][2]);
    }

    private void drawHarvestWeedUp(SpriteBatch sb) {
        sb.draw(weaponTexture, (player.finalPosition.x) + WeaponAnimationConfig.animations[Direction.up][player.aniIndex][0], player.finalPosition.y + WeaponAnimationConfig.animations[Direction.up][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, WeaponAnimationConfig.animations[Direction.up][player.aniIndex][2]);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_UP][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_UP][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
    }

    private void drawHarvestWeedRight(SpriteBatch sb) {
        if (WeaponAnimationConfig.animations[Direction.right][player.aniIndex][3] == 0) {
            sb.draw(weaponTexture, (player.finalPosition.x) + WeaponAnimationConfig.animations[Direction.right][player.aniIndex][0], player.finalPosition.y + WeaponAnimationConfig.animations[Direction.right][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, WeaponAnimationConfig.animations[Direction.right][player.aniIndex][2]);
        }
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_RIGHT][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        if (WeaponAnimationConfig.animations[Direction.right][player.aniIndex][3] == 1) {
            sb.draw(weaponTexture, (player.finalPosition.x) + WeaponAnimationConfig.animations[Direction.right][player.aniIndex][0], player.finalPosition.y + WeaponAnimationConfig.animations[Direction.right][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, WeaponAnimationConfig.animations[Direction.right][player.aniIndex][2]);
        }
    }

    private void drawHarvestWeedLeft(SpriteBatch sb) {
        if (WeaponAnimationConfig.animations[Direction.left][player.aniIndex][3] == 0) {
            sb.draw(weaponTextureReversed, (player.finalPosition.x) + WeaponAnimationConfig.animations[Direction.left][player.aniIndex][0], player.finalPosition.y + WeaponAnimationConfig.animations[Direction.left][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, WeaponAnimationConfig.animations[Direction.left][player.aniIndex][2]);
        }
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_WEED_LEFT][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        if (WeaponAnimationConfig.animations[Direction.left][player.aniIndex][3] == 1) {
            sb.draw(weaponTextureReversed, (player.finalPosition.x) + WeaponAnimationConfig.animations[Direction.left][player.aniIndex][0], player.finalPosition.y + WeaponAnimationConfig.animations[Direction.left][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, WeaponAnimationConfig.animations[Direction.left][player.aniIndex][2]);
        }
    }
}
