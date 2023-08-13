package game.entities.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actors.movableDefaultActor.MovableDefaultActor;
import utils.Checkbox;
import utils.vectors.DimensionCordVector;
import utils.vectors.Vector;

public class Player extends MovableDefaultActor {
    private boolean isAttacking = false;
    private PlayerStyle style = new PlayerStyle();
    private int hairTextureIndex = 0;
    private byte hairTextureYOffset = -2;
    private byte shirtYOffset = 8;

    private TextureRegion testRg;
    private PlayerShirtsData shirts;
    private TextureRegion[][] newArms;
    private int textIndex = PlayerTextures.STATE_IDLE_RIGHT;
    private TextureRegion pants;
    private boolean isStaticAction = false;

    public Player() {
        super(100, 100, PlayerConstants.checkboxArray, PlayerConstants.textureSrc, PlayerConstants.textureData, PlayerConstants.dim, new DimensionCordVector(20, 10, 20, 10));
        shirts = new PlayerShirtsData();
        testRg = shirts.arm;
        playerTextures.armsTextures = shirts.createShirtSleeves(playerTextures.armsTextures, style.shirtsArray[2]);
        playerTextures.pantsTextures = shirts.createPants(playerTextures.pantsTextures, style.shirtsArray[2]);
    }

    public Vector<Integer> getFinalPosition() {
        return finalPosition;
    }

    public void startStaticAction() {
        isStaticAction = true;
    }


    public void update() {
        if (!isCollision) {
            finalPosition.x = position.x;
            finalPosition.y = position.y;
        }

        updateAnimationTick();
        setAnimation();
    }

    private void setAnimation() {
        int startAni = actionIndex;

        if (isMoving || isStaticAction) {
            if (isStaticAction) {
                actionIndex = PlayerTextures.STATE_HARVEST_RIGHT;
            } else if (direction.left) {
                actionIndex = PlayerTextures.STATE_RUNNING_LEFT;
            } else if (direction.right) {
                actionIndex = PlayerTextures.STATE_RUNNING_RIGHT;
            } else if (direction.top) {
                actionIndex = PlayerTextures.STATE_RUNNING_UP;
            } else if (direction.bot) {
                actionIndex = PlayerTextures.STATE_RUNNING_DOWN;
            }
        } else {
            actionIndex = PlayerTextures.idleActionByLastAction(actionIndex);
        }

        hairTextureIndex = PlayerTextures.hairTextureIndexByAction(actionIndex);
        shirtYOffset = PlayerTextureUtils.getShirtYOffset(actionIndex, aniIndex);
        PlayerConstants.setHatTextureIndex(PlayerTextures.hatTextureIndexByAction(actionIndex));

        if (startAni != actionIndex)
            resetAniTick();
    }


    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= PlayerTextures.actionTextureAmount(actionIndex)) {
                aniIndex = 0;
                isAttacking = false;
            }
        }
        hairTextureYOffset = PlayerTextureUtils.getHairYOffset(actionIndex, aniIndex);
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(playerTextures.bodyTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 32);

//        sb.draw(style.hairArray[hairTextureIndex], finalPosition.x, finalPosition.y + hairTextureYOffset, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
//        sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
//        sb.draw(playerTextures.pantsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 16);
//        sb.draw(style.shirtsArray[PlayerConstants.hatTextureIndex], finalPosition.x + 4, finalPosition.y + shirtYOffset, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
        sb.draw(playerTextures.armsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 32);

//        sb.draw(playerTextures.bodyTextures[PlayerTextures.STATE_RUNNING_UP][0], finalPosition.x - 20, finalPosition.y - 20, 16, 32);
//        sb.draw(style.hairArray[1], finalPosition.x - 20, (finalPosition.y - 20) + PlayerTextureUtils.getHairYOffset(PlayerTextures.STATE_RUNNING_RIGHT, 0), 16, 32);
//
//        sb.draw(playerTextures.bodyTextures[PlayerTextures.STATE_RUNNING_UP][1], finalPosition.x, finalPosition.y - 20, 16, 32);
//        sb.draw(style.hairArray[1], finalPosition.x, (finalPosition.y - 20) + PlayerTextureUtils.getHairYOffset(PlayerTextures.STATE_RUNNING_RIGHT, 1), 16, 32);
//
//        sb.draw(playerTextures.bodyTextures[PlayerTextures.STATE_RUNNING_UP][2], finalPosition.x + 20, finalPosition.y - 20, 16, 32);
//        sb.draw(style.hairArray[1], finalPosition.x + 20, (finalPosition.y - 20) + PlayerTextureUtils.getHairYOffset(PlayerTextures.STATE_RUNNING_RIGHT, 2), 16, 32);
//
//        sb.draw(playerTextures.bodyTextures[PlayerTextures.STATE_RUNNING_UP][3], finalPosition.x + 40, finalPosition.y - 20, 16, 32);
//        sb.draw(style.hairArray[1], finalPosition.x + 40, (finalPosition.y - 20) + PlayerTextureUtils.getHairYOffset(PlayerTextures.STATE_RUNNING_RIGHT, 3), 16, 32);
//
//        sb.draw(playerTextures.bodyTextures[PlayerTextures.STATE_RUNNING_UP][4], finalPosition.x + 60, finalPosition.y - 20, 16, 32);
//        sb.draw(style.hairArray[1], finalPosition.x + 60, (finalPosition.y - 20) + PlayerTextureUtils.getHairYOffset(PlayerTextures.STATE_RUNNING_RIGHT, 4), 16, 32);
//
//        sb.draw(playerTextures.bodyTextures[PlayerTextures.STATE_RUNNING_UP][5], finalPosition.x + 80, finalPosition.y - 20, 16, 32);
//        sb.draw(style.hairArray[1], finalPosition.x + 80, (finalPosition.y - 20) + PlayerTextureUtils.getHairYOffset(PlayerTextures.STATE_RUNNING_RIGHT, 5), 16, 32);
    }

    public void updatePos() {
        isMoving = false;
        if (direction.left && !direction.right) {
            position.x -= speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x -= speed;
            }
            groundCheckbox.position.x -= speed;
            isMoving = true;
        } else if (direction.right && !direction.left) {
            position.x += speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x += speed;
            }
            groundCheckbox.position.x += speed;
            isMoving = true;
        }

        if (!direction.top && direction.bot) {
            position.y -= speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y -= speed;
            }
            groundCheckbox.position.y -= speed;
            isMoving = true;
        } else if (direction.top && !direction.bot) {
            position.y += speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y += speed;
            }
            groundCheckbox.position.y += speed;
            isMoving = true;
        }
    }
}
