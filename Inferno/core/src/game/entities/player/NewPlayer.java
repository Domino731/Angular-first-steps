package game.entities.player;

import engine.actors.movableDefaultActor.MovableDefaultActor;
import player.PlayerConstants;
import utils.Checkbox;

public class NewPlayer extends MovableDefaultActor {
    private boolean isAttacking = false;

    public NewPlayer() {
        super(NewPlayerConstants.position, NewPlayerConstants.checkboxArray, NewPlayerConstants.textureSrc, NewPlayerConstants.textureData, NewPlayerConstants.dim);
        System.out.println(NewPlayerConstants.checkboxArray);
    }

    public void update() {
        if (!isCollision) {
            System.out.println("new position");
            finalPosition.x = position.x;
            finalPosition.y = position.y;
        }

//        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    private void setAnimation() {
        int startAni = actionIndex;

        if (isMoving)
            actionIndex = PlayerConstants.Actions.RUNNING;
        else
            actionIndex = PlayerConstants.Actions.IDLE;

        if (isAttacking)
            actionIndex = PlayerConstants.Actions.ATTACK_1;

        if (startAni != actionIndex)
            resetAniTick();
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= PlayerConstants.GetSpriteAmount(actionIndex)) {
                aniIndex = 0;
                isAttacking = false;
            }
        }
    }

    public void updatePos() {
        isMoving = false;
        if (direction.left && !direction.right) {
            position.x -= speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x -= speed;
            }
            isMoving = true;
        } else if (direction.right && !direction.left) {
            position.x += speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x += speed;
            }
            isMoving = true;
        }

        if (direction.top && !direction.bot) {
            position.y -= speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y -= speed;
            }
            isMoving = true;
        } else if (direction.bot && !direction.top) {
            position.y += speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y += speed;
            }
            isMoving = true;
        }
    }
}
