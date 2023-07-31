package game.entities.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actors.movableDefaultActor.MovableDefaultActor;
import utils.Checkbox;
import utils.vectors.DimensionCordVector;
import utils.vectors.Vector;

public class Player extends MovableDefaultActor {
    private boolean isAttacking = false;
    private PlayerStyle style = new PlayerStyle();

    public Player() {
        super(100, 100, PlayerConstants.checkboxArray, PlayerConstants.textureSrc, PlayerConstants.textureData, PlayerConstants.dim, new DimensionCordVector(20, 10, 20, 10));
    }

    public Vector<Integer> getFinalPosition() {
        return finalPosition;
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

        if (isMoving) {
            if (direction.left) {
                actionIndex = PlayerTextures.STATE_RUNNING_LEFT;
            } else if (direction.right) {
                actionIndex = PlayerTextures.STATE_RUNNING_RIGHT;
            } else if (direction.top) {
                actionIndex = PlayerTextures.STATE_RUNNING_UP;
            } else if (direction.bot) {
                actionIndex = PlayerTextures.STATE_RUNNING_DOWN;
            }
        } else {
            System.out.println(PlayerTextures.idleActionByLastAction(actionIndex));
            actionIndex = PlayerTextures.idleActionByLastAction(actionIndex);
        }


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
    }

    @Override
    public void draw(SpriteBatch sb) {
        super.draw(sb);
        sb.draw(style.hair, finalPosition.x, finalPosition.y - 3, PlayerTextures.HAIR_SIZE.width, PlayerTextures.HAIR_SIZE.height);

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
