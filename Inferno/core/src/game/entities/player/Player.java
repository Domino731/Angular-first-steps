package game.entities.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import engine.actors.movableDefaultActor.MovableDefaultActor;
import engine.actorsManager.ActorsManager;
import environment.resources.ResourceAction;
import game.entities.player.animations.PlayerAnimations;
import game.entities.player.animations.utils.AnimationAmount;
import game.entities.player.inventory.InventoryItemGroups;
import game.entities.player.inventory.PlayerInventory;
import game.entities.player.playerTextures.PlayerTextures;
import game.entities.player.style.PlayerStyle;
import game.entities.player.style.data.PlayerShirtsData;
import utils.Checkbox;
import utils.Direction;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import static constants.Urls.SPRITE_HATS;
import static game.entities.player.PlayerConstants.*;
import static game.entities.player.Utils.getActionIndexByLastAction;
import static game.entities.player.Utils.getIsActionByAniIndex;
import static game.entities.player.playerTextures.PlayerTextures.idleActionByLastActionForItem;

public class Player extends MovableDefaultActor {
    public PlayerStyle style = new PlayerStyle();
    private PlayerShirtsData shirts;
    private boolean isStaticAction = false;
    // Action collision from ActorManager
    private ActorsManager actorsManager;
    public PlayerInventory inventory = new PlayerInventory();
    private PlayerAnimations animations;
    private boolean isSeed = false;
    private AnimationAmount animationAmount;
    private byte directionIndex = Direction.down;
    private ActionTypes currItemActionType = null;

    public Player(ActorsManager actorsManager) {
        super(5, 5, PlayerConstants.checkboxArray, SPRITE_HATS, PlayerConstants.textureData, PlayerConstants.dim, new DimensionCordVector(20, 10, 20, 10));
        shirts = new PlayerShirtsData();
        this.actorsManager = actorsManager;
//        playerTextures.armsTextures = shirts.createShirtSleeves(playerTextures.armsTextures, style.shirtsArray[2]);
        playerTextures.pantsTextures = shirts.createPants(playerTextures.pantsTextures, style.shirtsArray[2]);
        setActionsCollisions();
        animations = new PlayerAnimations(this);
        animationAmount = new AnimationAmount(playerTextures.bodyTextures);
        changeInventorySlot((byte) 1);
    }

    public void startStaticAction() {
        if (inventory.getCurrItemType() == InventoryItemGroups.seed) {
            isSeed = true;
            return;
        }
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

        if (isSeed) {
            if (isMoving) {
                if (direction.left) {
                    actionIndex = ANI_RUNNING_ITEM_LEFT;
                } else if (direction.right) {
                    actionIndex = ANI_RUNNING_ITEM_RIGHT;
                } else if (direction.top) {
                    actionIndex = ANI_RUNNING_ITEM_UP;
                } else if (direction.bot) {
                    actionIndex = ANI_RUNNING_ITEM_DOWN;
                }
            } else {
                actionIndex = idleActionByLastActionForItem(actionIndex);
            }

        } else if (isMoving || isStaticAction) {
            if (isStaticAction) {
                actionIndex = Utils.getHarvestWeedAniIndex(actionIndex, inventory.getCurrItemType(), isMoving, isSeed);
            } else if (direction.left) {
                actionIndex = ANI_RUNNING_LEFT;
            } else if (direction.right) {
                actionIndex = ANI_RUNNING_RIGHT;
            } else if (direction.top) {
                actionIndex = ANI_RUNNING_UP;
            } else if (direction.bot) {
                actionIndex = ANI_RUNNING_DOWN;
            }
        } else {
            actionIndex = PlayerTextures.idleActionByLastAction(actionIndex);
        }


        if (startAni != actionIndex) {
            resetAniTick();
        }

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
            if (aniIndex >= animationAmount.getAmount(actionIndex)) {
                if (isStaticAction) {
                    isStaticAction = false;
                    actionIndex = getActionIndexByLastAction(actionIndex);
                }
                aniIndex = 0;
            }
        }
    }

    /**
     * Trigger the specific action when action end
     */
    private void handleActions() {
        if (actorsManager.currentAction == null || !isStaticAction) return;

        if (getIsActionByAniIndex(currItemActionType, aniIndex)) {
            actorsManager.currentAction.action();
        }
    }

    @Override
    public void draw(SpriteBatch sb) {
        animations.draw(sb);
    }

    public byte getDirectionIndex() {
        return directionIndex;
    }

    public void updatePos() {
        isMoving = false;
        if (direction.left && !direction.right) {
            position.x -= speed;
            directionIndex = Direction.left;
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
            directionIndex = Direction.right;
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
            directionIndex = Direction.down;
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
            directionIndex = Direction.up;
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
//                        System.out.println("PLAYER ACTION COLLISION");
                    }
                }
        ));
    }

    public void changeInventorySlot(byte slot) {
        inventory.changeCurrentSlot(slot);
        isSeed = inventory.getCurrItemType() == InventoryItemGroups.seed;
        currItemActionType = inventory.getCurrItemActionType();
    }
}
