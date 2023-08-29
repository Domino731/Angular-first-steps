package game.entities.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import engine.actors.movableDefaultActor.MovableDefaultActor;
import engine.actorsManager.ActorsManager;
import environment.resources.ResourceAction;
import game.entities.player.animations.PlayerAnimations;
import game.entities.player.animations.PlayerAnimationsTest;
import game.entities.player.animations.config.ToolAnimationConfig;
import utils.Checkbox;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

public class Player extends MovableDefaultActor {
    private boolean isAttacking = false;
    public PlayerStyle style = new PlayerStyle();
    private int hairTextureIndex = 0;
    private byte hairTextureYOffset = -2;
    private byte shirtYOffset = 8;

    private TextureRegion testRg;
    private PlayerShirtsData shirts;
    private TextureRegion[][] newArms;
    private int textIndex = PlayerTextures.STATE_IDLE_RIGHT;
    private TextureRegion pants;
    private boolean isStaticAction = false;
    private byte[][] rightAxeAnimation = ToolAnimationConfig.rightAxeAnimation;
    // Action collision from ActorManager
    private ActorsManager actorsManager;
    public PlayerInventory inventory = new PlayerInventory();
    private PlayerAnimationsTest animationsTest;
    private PlayerAnimations animations;

    public Player(ActorsManager actorsManager) {
        super(5, 5, PlayerConstants.checkboxArray, PlayerConstants.textureSrc, PlayerConstants.textureData, PlayerConstants.dim, new DimensionCordVector(20, 10, 20, 10));
        shirts = new PlayerShirtsData();
        this.actorsManager = actorsManager;
        testRg = shirts.arm;
//        playerTextures.armsTextures = shirts.createShirtSleeves(playerTextures.armsTextures, style.shirtsArray[2]);
        playerTextures.pantsTextures = shirts.createPants(playerTextures.pantsTextures, style.shirtsArray[2]);
        setActionsCollisions();
        animationsTest = new PlayerAnimationsTest(this);
        animations = new PlayerAnimations(this);
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

    private void setActionIndex() {
        System.out.println(direction);
    }

    private void setAnimation() {
        int startAni = actionIndex;

        if (isMoving || isStaticAction) {
            if (isStaticAction) {
                setActionIndex();
                actionIndex = Utils.getHarvestWeedAniIndex(actionIndex);

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

    protected void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updateAnimationTick() {
        aniTick++;

        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;

            handleActions();
            if (aniIndex >= PlayerTextures.actionTextureAmount(actionIndex)) {
                if (isStaticAction) {
                    isStaticAction = false;
                    actionIndex = PlayerTextures.STATE_IDLE_RIGHT;
                }
                aniIndex = 0;
                isAttacking = false;
            }
        }


        hairTextureYOffset = PlayerTextureUtils.getHairYOffset(actionIndex, aniIndex);
    }

    /**
     * Trigger the specific action when action end
     */
    private void handleActions() {
        if (actorsManager.currentAction == null) return;

        if (actionIndex == PlayerTextures.STATE_MINE_RIGHT && aniIndex >= PlayerConstants.ANI_CUT_TREE_LENGTH) {
            actorsManager.currentAction.action();
        }
    }

    @Override
    public void draw(SpriteBatch sb) {
        animations.draw(sb);
//        animationsTest.harvestWeedRight(sb);
//        sb.draw(playerTextures.bodyTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 32);
        sb.draw(style.hairArray[hairTextureIndex], finalPosition.x, finalPosition.y + hairTextureYOffset, PlayerHairsData.HAIR_SIZE.width, PlayerHairsData.HAIR_SIZE.height);
//        sb.draw(style.hatsArray[PlayerConstants.hatTextureIndex], finalPosition.x + PlayerConstants.hairXOffset, (finalPosition.y + hairTextureYOffset) + PlayerConstants.hairYOffset, 20, 20);
//        sb.draw(playerTextures.pantsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 16);
//        sb.draw(style.shirtsArray[PlayerConstants.hatTextureIndex], finalPosition.x + 4, finalPosition.y + shirtYOffset, PlayerConstants.shirtDim.width, PlayerConstants.shirtDim.height);
//        sb.draw(playerTextures.armsTextures[actionIndex][aniIndex], finalPosition.x, finalPosition.y, 16, 32);


    }

    public void updatePos() {
        isMoving = false;
        if (direction.left && !direction.right) {
            position.x -= speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x -= speed;
            }
            for (ActionCollision cb : actionCollisions) {
                cb.position.x -= speed;
            }
            groundCheckbox.position.x -= speed;
            isMoving = true;
        } else if (direction.right && !direction.left) {
            position.x += speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.x += speed;
            }
            for (ActionCollision cb : actionCollisions) {
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
            for (ActionCollision cb : actionCollisions) {
                cb.position.y -= speed;
            }
            groundCheckbox.position.y -= speed;
            isMoving = true;
        } else if (direction.top && !direction.bot) {
            position.y += speed;
            for (Checkbox cb : checkboxArray) {
                cb.position.y += speed;
            }
            for (ActionCollision cb : actionCollisions) {
                cb.position.y += speed;
            }
            groundCheckbox.position.y += speed;
            isMoving = true;
        }
    }

    private void setActionsCollisions() {
        actionCollisions.add(new ActionCollision(
                ActionTypes.ACTION_AREA,
                id,
                new Vector<>(position.x, position.y),
                new DimensionVector<>(16, 16),
                new Vector<Integer>(0, 0),
                new ResourceAction() {
                    @Override
                    public void action() {
                        System.out.println("PLAYER ACTION COLLISION");
                    }
                }
        ));
    }

    public void changeInventorySlot(byte slot) {
        inventory.changeCurrentSlot(slot);
    }
}
