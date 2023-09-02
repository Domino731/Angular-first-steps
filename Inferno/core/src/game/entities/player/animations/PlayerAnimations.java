package game.entities.player.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.Urls;
import game.entities.player.Player;
import game.entities.player.PlayerConstants;
import game.entities.player.PlayerHairsData;
import game.entities.player.PlayerTextures;
import game.entities.player.animations.config.ToolAnimationConfig;
import game.entities.player.animations.config.WeaponAnimationConfig;
import game.entities.player.playerTextures.CreateHairYOffset;
import items.Items;
import utils.Direction;
import utils.vectors.Vector;

import static game.entities.player.animations.config.AniConfigConstants.*;

public class PlayerAnimations {
    private Player player;
    private AnimationDraw[] animationDraws;
    private byte animationIndex = PlayerTextures.STATE_IDLE_DOWN;
    private Vector<Integer> finalPosition;
    int actionIndex;
    int aniIndex;
    TextureRegion[][] bodyTextures, armsTextures, pantsTextures;
    TextureRegion weaponTexture = loadWeaponTexture();
    TextureRegion weaponTextureReversed = loadWeaponTextureReversed();
    TextureRegion[][] toolTxts = Items.get("stone_pickaxe").txts;
    public static final short[][][] weaponAnimations = WeaponAnimationConfig.animations;
    public static final byte[][][] toolAnimations = ToolAnimationConfig.animations;

    public final byte weaponXOrigin = 16 / 2;
    public final byte weaponYOrigin = 16 / 2;
    public Integer[][] hairOffset;
    public Integer[][] shirtOffset;
    boolean test = false;

    public PlayerAnimations(Player player) {
        this.player = player;
        finalPosition = player.finalPosition;
        bodyTextures = player.playerTextures.bodyTextures;
        armsTextures = player.playerTextures.armsTextures;
        pantsTextures = player.playerTextures.pantsTextures;
        hairOffset = CreateHairYOffset.createOffsetForHair(player.playerTextures.armsTextures);
        shirtOffset = CreateHairYOffset.create(player.playerTextures.pantsTextures);

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
        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][0], finalPosition.x - 40, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x - 40, finalPosition.y - 4, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][0], finalPosition.x - 40, finalPosition.y, 16, 16);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x - 36, finalPosition.y + 8, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) - 40, (finalPosition.y + 12), 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][1], finalPosition.x - 20, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x - 20, finalPosition.y - 5, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][1], finalPosition.x - 20, finalPosition.y, 16, 16);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x - 16, finalPosition.y + 7, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) - 20, (finalPosition.y + 12) - 1, 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][2], finalPosition.x, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x, finalPosition.y - 4, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x + 4, finalPosition.y + 8, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][2], finalPosition.x, finalPosition.y, 16, 16);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2), (finalPosition.y + 12), 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][3], finalPosition.x + 20, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x + 20, finalPosition.y - 3, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x + 24, finalPosition.y + 9, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][3], finalPosition.x + 20, finalPosition.y, 16, 16);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) + 20, (finalPosition.y + 12) + 1, 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][4], finalPosition.x + 40, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x + 40, finalPosition.y - 4, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][4], finalPosition.x + 40, finalPosition.y, 16, 16);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x + 44, finalPosition.y + 8, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) + 40, (finalPosition.y + 12), 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][5], finalPosition.x + 60, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x + 60, finalPosition.y - 5, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x + 64, finalPosition.y + 7, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][5], finalPosition.x + 60, finalPosition.y, 16, 16);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) + 60, (finalPosition.y + 12) - 1, 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][6], finalPosition.x + 80, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x + 80, finalPosition.y - 4, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x + 84, finalPosition.y + 8, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][6], finalPosition.x + 80, finalPosition.y, 16, 16);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) + 80, (finalPosition.y + 12), 20, 20);

        sb.draw(bodyTextures[PlayerTextures.STATE_RUNNING_DOWN][7], finalPosition.x + 100, finalPosition.y, 16, 32);
        sb.draw(player.style.hairArray[2], finalPosition.x + 100, finalPosition.y - 3, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
        sb.draw(player.style.shirtsArray[Direction.down], finalPosition.x + 104, finalPosition.y + 9, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(pantsTextures[PlayerTextures.STATE_RUNNING_DOWN][7], finalPosition.x + 100, finalPosition.y, 16, 16);
        sb.draw(player.style.hatsArray[PlayerConstants.hatTextureIndex], (finalPosition.x - 2) + 100, (finalPosition.y + 12) + 1, 20, 20);
//        sb.draw(bodyTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
//        sb.draw(player.style.hairArray[0], finalPosition.x, finalPosition.y - 2, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
//        sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
//        sb.draw(pantsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 16);
////        sb.draw(player.style.shirtsArray[player.hairTextureIndex], finalPosition.x + 4, finalPosition.y + 16 - shirtOffset[player.actionIndex][player.aniIndex] - 1, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
//        sb.draw(armsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
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
        animations[PlayerTextures.STATE_HARVEST_UP] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                harvestAnimation(sb, PlayerTextures.STATE_HARVEST_UP, Direction.up, weaponTexture);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_RIGHT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                harvestAnimation(sb, PlayerTextures.STATE_HARVEST_RIGHT, Direction.right, weaponTexture);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_DOWN] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                harvestAnimation(sb, PlayerTextures.STATE_HARVEST_DOWN, Direction.down, weaponTexture);
            }
        };
        animations[PlayerTextures.STATE_HARVEST_LEFT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                harvestAnimation(sb, PlayerTextures.STATE_HARVEST_LEFT, Direction.left, weaponTextureReversed);
            }
        };
        // MINE RESOURCES
        animations[PlayerTextures.STATE_MINE_UP] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_MINE_UP, Direction.up);
            }
        };
        animations[PlayerTextures.STATE_MINE_RIGHT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_MINE_RIGHT, Direction.right);
            }
        };
        animations[PlayerTextures.STATE_MINE_DOWN] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_MINE_DOWN, Direction.down);
            }
        };
        animations[PlayerTextures.STATE_MINE_LEFT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                mineAnimation(sb, PlayerTextures.STATE_MINE_LEFT, Direction.left);
            }
        };
        // IDLE ITEM
        animations[PlayerTextures.STATE_IDLE_ITEM_UP] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        animations[PlayerTextures.STATE_IDLE_ITEM_RIGHT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        animations[PlayerTextures.STATE_IDLE_ITEM_DOWN] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        animations[PlayerTextures.STATE_IDLE_ITEM_LEFT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        // RUNNING ITEM
        animations[PlayerTextures.STATE_RUNNING_ITEM_UP] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        animations[PlayerTextures.STATE_RUNNING_ITEM_RIGHT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        animations[PlayerTextures.STATE_RUNNING_ITEM_DOWN] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };
        animations[PlayerTextures.STATE_RUNNING_ITEM_LEFT] = new AnimationDraw() {
            @Override
            public void draw(SpriteBatch sb) {
                itemAnimation(sb);
            }
        };

        animationDraws = animations;
    }

    private void itemAnimation(SpriteBatch sb) {
        sb.draw(bodyTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
        sb.draw(armsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
    }

    private void harvestAnimation(SpriteBatch sb, byte bodyTexturesIndex, byte directionIndex, TextureRegion weaponTexture) {
        if (weaponAnimations[directionIndex][player.aniIndex][3] == 0) {
            sb.draw(weaponTexture, (player.finalPosition.x) + weaponAnimations[directionIndex][player.aniIndex][xIndex], player.finalPosition.y + weaponAnimations[directionIndex][player.aniIndex][yIndex], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, weaponAnimations[directionIndex][player.aniIndex][rotateIndex]);
        }
        sb.draw(bodyTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        if (weaponAnimations[directionIndex][player.aniIndex][3] == 1) {
            sb.draw(weaponTexture, (player.finalPosition.x) + weaponAnimations[directionIndex][player.aniIndex][xIndex], player.finalPosition.y + weaponAnimations[directionIndex][player.aniIndex][yIndex], weaponXOrigin, weaponYOrigin, 16, 16, 1, 1, weaponAnimations[directionIndex][player.aniIndex][rotateIndex]);
        }
    }

    private void mineAnimation(SpriteBatch sb, byte bodyTexturesIndex, byte directionIndex) {
        if (toolAnimations[directionIndex][player.aniIndex][zIndex] == 0) {
            sb.draw(toolTxts[directionIndex][toolAnimations[directionIndex][player.aniIndex][txtIndex]],
                    player.finalPosition.x + toolAnimations[directionIndex][player.aniIndex][xIndex],
                    player.finalPosition.y + toolAnimations[directionIndex][player.aniIndex][yIndex],
                    PlayerTextures.toolXOrigin, PlayerTextures.toolYOrigin,
                    Items.toolWidth, Items.toolHeight, 1, 1, toolAnimations[directionIndex][player.aniIndex][rotateIndex]);
        }

        sb.draw(bodyTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);
        sb.draw(armsTextures[bodyTexturesIndex][player.aniIndex], player.finalPosition.x, player.finalPosition.y, 16, 32);

        if (toolAnimations[directionIndex][player.aniIndex][zIndex] == 1) {
            sb.draw(toolTxts[directionIndex][toolAnimations[directionIndex][player.aniIndex][txtIndex]],
                    player.finalPosition.x + toolAnimations[directionIndex][player.aniIndex][xIndex],
                    player.finalPosition.y + toolAnimations[directionIndex][player.aniIndex][yIndex],
                    PlayerTextures.toolXOrigin, PlayerTextures.toolYOrigin,
                    Items.toolWidth, Items.toolHeight, 1, 1, toolAnimations[directionIndex][player.aniIndex][rotateIndex]);
        }
    }
}
