package game.entities.player.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.entities.player.Player;
import game.entities.player.PlayerTextures;
import game.entities.player.animations.config.WeaponAnimationConfig;
import game.entities.player.tools.ToolsConstants;
import items.Items;
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
    TextureRegion[][] toolTxts = Items.get("stone_pickaxe").txts;
    public static final short[][][] weaponAnimations = WeaponAnimationConfig.animations;
    public static final byte[][][] toolAnimations = ToolsConstants.animations;

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
//        sb.draw(bodyTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
////          sb.draw(style.hairArray[hairTextureIndex], finalPosition.x, finalPosition.y + hairTextureYOffset, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
////          sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
////          sb.draw(playerTextures.pantsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 16);
////          sb.draw(style.shirtsArray[PlayerConstants.hatTextureIndex], finalPosition.x + 4, finalPosition.y + shirtYOffset, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
//        sb.draw(armsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);

        int aniIndex = 4;
        sb.draw(toolTxts[Direction.up][toolAnimations[Direction.up][aniIndex][3]],
                player.finalPosition.x + toolAnimations[Direction.up][aniIndex][0], player.finalPosition.y + toolAnimations[Direction.up][aniIndex][1],
                PlayerTextures.toolXOrigin,
                PlayerTextures.toolYOrigin,
                Items.toolWidth, Items.toolHeight, 1, 1, toolAnimations[Direction.up][aniIndex][2]);
        sb.draw(bodyTextures[PlayerTextures.STATE_HARVEST_UP][aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[PlayerTextures.STATE_HARVEST_UP][aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);

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
        // HARVEST WEED
        animations[PlayerTextures.STATE_HARVEST_WEED_UP] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawHarvestWeed(sb, PlayerTextures.STATE_HARVEST_WEED_UP, Direction.up, weaponTexture);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_WEED_RIGHT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawHarvestWeed(sb, PlayerTextures.STATE_HARVEST_WEED_RIGHT, Direction.right, weaponTexture);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_WEED_DOWN] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawHarvestWeed(sb, PlayerTextures.STATE_HARVEST_WEED_DOWN, Direction.down, weaponTexture);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_WEED_LEFT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawHarvestWeed(sb, PlayerTextures.STATE_HARVEST_WEED_LEFT, Direction.left, weaponTextureReversed);
            }
        };
        // MINE RESOURCES
        animations[PlayerTextures.STATE_HARVEST_UP] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_HARVEST_UP, Direction.up);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_RIGHT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_HARVEST_RIGHT, Direction.right);
            }
        };
        animations[PlayerTextures.STATE_MINE_RES] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_MINE_RES, Direction.down);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_LEFT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_HARVEST_LEFT, Direction.left);
            }
        };
        animationDraws = animations;
    }

    private void drawHarvestWeed(SpriteBatch sb, byte bodyTexturesIndex, byte directionIndex, TextureRegion weaponTexture) {
        if (weaponAnimations[directionIndex][player.aniIndex][3] == 0) {
            sb.draw(weaponTexture, (player.finalPosition.x) + weaponAnimations[directionIndex][player.aniIndex][0], player.finalPosition.y + weaponAnimations[directionIndex][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, weaponAnimations[directionIndex][player.aniIndex][2]);
        }
        sb.draw(bodyTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        if (weaponAnimations[directionIndex][player.aniIndex][3] == 1) {
            sb.draw(weaponTexture, (player.finalPosition.x) + weaponAnimations[directionIndex][player.aniIndex][0], player.finalPosition.y + weaponAnimations[directionIndex][player.aniIndex][1], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, weaponAnimations[directionIndex][player.aniIndex][2]);
        }
    }

    private void mineAnimation(SpriteBatch sb, byte bodyTexturesIndex, byte directionIndex) {
        sb.draw(bodyTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(toolTxts[directionIndex][toolAnimations[directionIndex][player.aniIndex][3]],
                player.finalPosition.x, player.finalPosition.y,
                PlayerTextures.toolXOrigin + toolAnimations[directionIndex][player.aniIndex][0],
                PlayerTextures.toolYOrigin + toolAnimations[directionIndex][player.aniIndex][1],
                Items.toolWidth, Items.toolHeight, 1, 1, toolAnimations[directionIndex][player.aniIndex][2]);
    }
}
