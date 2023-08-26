package game.entities.player.animations;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import game.entities.player.Player;
import game.entities.player.PlayerTextures;
import utils.vectors.Vector;

public class PlayerAnimations {
    private Player player;
    private AnimationDraw[] animationDraws;
    private byte animationIndex = PlayerTextures.STATE_IDLE_DOWN;
    private Vector<Integer> finalPosition;
    int actionIndex;
    int aniIndex;
    TextureRegion[][] bodyTextures, armsTextures;

    public PlayerAnimations(Player player) {
        this.player = player;
        finalPosition = player.finalPosition;
        bodyTextures = player.playerTextures.bodyTextures;
        armsTextures = player.playerTextures.armsTextures;
        setAnimationDraws();
    }

    public void running(SpriteBatch sb) {
        sb.draw(bodyTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
//          sb.draw(style.hairArray[hairTextureIndex], finalPosition.x, finalPosition.y + hairTextureYOffset, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
//          sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
//          sb.draw(playerTextures.pantsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 16);
//          sb.draw(style.shirtsArray[PlayerConstants.hatTextureIndex], finalPosition.x + 4, finalPosition.y + shirtYOffset, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(armsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
    }

    public void draw(SpriteBatch sb) {
        System.out.println(player.actionIndex);
        animationDraws[player.actionIndex].draw(sb);
//        sb.draw(bodyTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);
////          sb.draw(style.hairArray[hairTextureIndex], finalPosition.x, finalPosition.y + hairTextureYOffset, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
////          sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
////          sb.draw(playerTextures.pantsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 16);
////          sb.draw(style.shirtsArray[PlayerConstants.hatTextureIndex], finalPosition.x + 4, finalPosition.y + shirtYOffset, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
//        sb.draw(armsTextures[player.actionIndex][player.aniIndex], finalPosition.x, finalPosition.y, 16, 32);

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

        animationDraws = animations;

        // IDLE        public static final int STATE_IDLE_UP = 0;
        ////        public static final int STATE_IDLE_RIGHT = 1;
        ////        public static final int STATE_IDLE_DOWN = 2;
        ////        public static final int STATE_IDLE_LEFT = 3;
        ////        // RUNNING
        ////        public static final int STATE_RUNNING_UP = 4;
        ////        public static final int STATE_RUNNING_RIGHT = 5;
        ////        public static final int STATE_RUNNING_DOWN = 6;
        ////        public static final int STATE_RUNNING_LEFT = 7;
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

}
