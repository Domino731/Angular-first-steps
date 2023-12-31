package game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.movableDefaultActor.MovableDefaultActor;
import engine.fonts.actionCollision.ActionCollision;
import engine.fonts.actionCollision.ActionTypes;
import engine.fonts.actionCollision.actorsManager.ActorsManager;
import engine.fonts.actionCollision.actorsManager.GameTime;
import game.player.animations.PlayerAnimations;
import game.player.animations.utils.AnimationAmount;
import game.player.inventory.InventoryItemGroups;
import game.player.inventory.PlayerInventory;
import game.player.playerTextures.PlayerTextures;
import game.player.style.PlayerStyle;
import game.player.style.paintTextures.PaintTextures;
import inputs.GameInputProcessor;
import utils.Action;
import utils.Checkbox;
import utils.Direction;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import static constants.Urls.SPRITE_HATS;
import static game.player.playerTextures.PlayerTextures.idleActionByLastActionForItem;

public class Player extends MovableDefaultActor {
    public PlayerStyle style = new PlayerStyle();
    private PaintTextures shirts;
    private boolean isStaticAction = false;
    // Action collision from ActorManager
    private final ActorsManager actorsManager;
    public PlayerInventory inventory = new PlayerInventory();
    private final PlayerAnimations animations;
    private boolean isHoldingItem = false;
    private final AnimationAmount animationAmountPerAction;
    private byte directionIndex = Direction.down;
    private ActionTypes currItemActionType = null;
    private Vector<Integer> centerPosition;
    private Vector<Integer> centerPositionFinal;
    private boolean isBuildMode = true;

    public Player(ActorsManager actorsManager) {
        super(-3, 47, PlayerConstants.checkboxArray, SPRITE_HATS, PlayerConstants.textureData, PlayerConstants.dim, new DimensionCordVector(20, 10, 20, 10));
        this.shirts = new PaintTextures();
        this.actorsManager = actorsManager;
        this.playerTextures.armsTextures = shirts.createShirtSleevesWithColors(playerTextures.armsTextures, style.shirtsArray[2]);
        this.playerTextures.pantsTextures = shirts.createPantsWithColor(playerTextures.pantsTextures, style.shirtsArray[2]);
        this.animations = new PlayerAnimations(this);
        this.animationAmountPerAction = new AnimationAmount(playerTextures.bodyTextures);
        this.centerPosition = new Vector<>((groundCheckbox.dim.width / 2) + position.x, (groundCheckbox.dim.height / 2) + position.y);
        this.centerPositionFinal = new Vector<>((groundCheckbox.dim.width / 2) + position.x, (groundCheckbox.dim.height / 2) + position.y);
        setActionsCollisions();

        changeInventorySlot((byte) 1);
    }

    public boolean getIsBuildMode() {
        return isBuildMode;
    }

    public void startStaticAction() {
        InventoryItemGroups currentItemType = inventory.getCurrItemType();
        if (currentItemType == null) {
            return;
        }
        isHoldingItem = inventory.getCurrItemType() == InventoryItemGroups.seed;

        if (inventory.getCurrItemType() == InventoryItemGroups.seed) {
            isHoldingItem = true;
            return;
        }
        isStaticAction = true;
    }

    @Override
    public void update(float delta, GameTime gameTime) {
        if (!isCollision) {
            // update positions
            finalPosition.x = position.x;
            finalPosition.y = position.y;
            centerPositionFinal.x = centerPosition.x;
            centerPositionFinal.y = centerPosition.y;
            // TODO: marking tiles
//            Integer tile = actorsManager.findTile(centerPosition.x, centerPosition.y);
            // set current tile
        }

        updateAnimationTick();
        setAnimation();
    }


    private void setAnimation() {
        int startAni = actionIndex;

        if (isHoldingItem) {
            if (isMoving) {
                if (direction.left) {
                    actionIndex = PlayerConstants.ANI_RUNNING_ITEM_LEFT;
                } else if (direction.right) {
                    actionIndex = PlayerConstants.ANI_RUNNING_ITEM_RIGHT;
                } else if (direction.top) {
                    actionIndex = PlayerConstants.ANI_RUNNING_ITEM_UP;
                } else if (direction.bot) {
                    actionIndex = PlayerConstants.ANI_RUNNING_ITEM_DOWN;
                }
            } else {
                actionIndex = idleActionByLastActionForItem(actionIndex);
            }

        } else if (isMoving || isStaticAction) {
            if (isStaticAction) {
                actionIndex = Utils.getHarvestWeedAniIndex(actionIndex, inventory.getCurrItemType(), isMoving, isHoldingItem);
            } else if (direction.left) {
                actionIndex = PlayerConstants.ANI_RUNNING_LEFT;
            } else if (direction.right) {
                actionIndex = PlayerConstants.ANI_RUNNING_RIGHT;
            } else if (direction.top) {
                actionIndex = PlayerConstants.ANI_RUNNING_UP;
            } else if (direction.bot) {
                actionIndex = PlayerConstants.ANI_RUNNING_DOWN;
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
            if (aniIndex >= animationAmountPerAction.getAmount(actionIndex)) {
                if (isStaticAction) {
                    isStaticAction = false;
                    actionIndex = Utils.getActionIndexByLastAction(actionIndex);
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

        if (Utils.getIsActionByAniIndex(currItemActionType, aniIndex)) {
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
        if (direction.top || direction.right || direction.bot || direction.left) {
            isMoving = true;
        }

        if (isStaticAction && !isHoldingItem) {
            return;
        }

        // MOVE LEFT
        if (direction.left && !direction.right) {
            position.x -= speed;
            centerPosition.x -= speed;
            directionIndex = Direction.left;
            GameInputProcessor.increaseScreenXOffset(speed);
            for (Checkbox cb : checkboxArray) {
                cb.position.x -= speed;
            }
            for (ActionCollision cb : actionCollisions) {
                cb.position.x -= speed;
            }
            groundCheckbox.position.x -= speed;
        }
        // MOVE RIGHT
        else if (direction.right && !direction.left) {
            position.x += speed;
            centerPosition.x += speed;
            directionIndex = Direction.right;
            GameInputProcessor.decreaseScreenXOffset(speed);
            for (Checkbox cb : checkboxArray) {
                cb.position.x += speed;
            }
            for (ActionCollision cb : actionCollisions) {
                cb.position.x += speed;
            }
            groundCheckbox.position.x += speed;
        }
        // MOVE BOTTOM
        if (!direction.top && direction.bot) {
            position.y -= speed;
            centerPosition.y -= speed;
            directionIndex = Direction.down;
            GameInputProcessor.increaseScreenYOffset(speed);
            for (Checkbox cb : checkboxArray) {
                cb.position.y -= speed;
            }
            for (ActionCollision cb : actionCollisions) {
                cb.position.y -= speed;
            }
            groundCheckbox.position.y -= speed;
        }
        // MOVE TOP
        else if (direction.top && !direction.bot) {
            position.y += speed;
            centerPosition.y += speed;
            directionIndex = Direction.up;
            GameInputProcessor.decreaseScreenYOffset(speed);
            for (Checkbox cb : checkboxArray) {
                cb.position.y += speed;
            }
            for (ActionCollision cb : actionCollisions) {
                cb.position.y += speed;
            }
            groundCheckbox.position.y += speed;
        }
    }

    private void setActionsCollisions() {
        actionCollisions.add(new ActionCollision(
                ActionTypes.ACTION_AREA,
                id,
                new Vector<>(position.x, position.y),
                new DimensionVector<>(16, 16),
                new Vector<Integer>(0, 0),
                new Action() {
                    @Override
                    public void action() {
//                        System.out.println("PLAYER ACTION COLLISION");
                    }
                }
        ));
    }

    public void changeInventorySlot(byte slot) {
        isHoldingItem = false;
        inventory.changeCurrentSlot(slot);
        currItemActionType = inventory.getCurrItemActionType();
    }
}
