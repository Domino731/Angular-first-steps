package game.player;

import engine.actionCollision.ActionTypes;
import game.player.inventory.InventoryItemGroups;
import utils.Direction;
import utils.vectors.DimensionCordVector;

import java.util.ArrayList;

import static game.player.PlayerConstants.*;

public class Utils {
    public static byte getDirectionIndexByLastAction(int actionIndex) {
        switch (actionIndex) {
            case ANI_HARVEST_LEFT:
            case ANI_IDLE_LEFT:
            case ANI_RUNNING_LEFT:
            case ANI_MINE_LEFT:
            case ANI_IDLE_ITEM_LEFT:
            case ANI_RUNNING_ITEM_LEFT:
                return Direction.left;
            case ANI_HARVEST_RIGHT:
            case ANI_IDLE_RIGHT:
            case ANI_RUNNING_RIGHT:
            case ANI_MINE_RIGHT:
            case ANI_IDLE_ITEM_RIGHT:
            case ANI_RUNNING_ITEM_RIGHT:
                return Direction.right;
            case ANI_HARVEST_DOWN:
            case ANI_IDLE_DOWN:
            case ANI_RUNNING_DOWN:
            case ANI_MINE_DOWN:
            case ANI_IDLE_ITEM_DOWN:
            case ANI_RUNNING_ITEM_DOWN:
                return Direction.down;
            case ANI_HARVEST_UP:
            case ANI_IDLE_UP:
            case ANI_RUNNING_UP:
            case ANI_MINE_UP:
            case ANI_IDLE_ITEM_UP:
            case ANI_RUNNING_ITEM_UP:
                return Direction.up;
            default:
                return Direction.down;
        }
    }

    public static byte getActionIndexByLastAction(int actionIndex) {
        byte directionIndex = getDirectionIndexByLastAction(actionIndex);

        switch (directionIndex) {
            case Direction.up:
                return ANI_IDLE_UP;
            case Direction.right:
                return ANI_IDLE_RIGHT;
            case Direction.down:
                return ANI_IDLE_DOWN;
            case Direction.left:
                return ANI_IDLE_LEFT;
            default:
                return ANI_IDLE_UP;
        }
    }

    public static byte getHarvestWeedAniIndex(int actionIndex, InventoryItemGroups inventoryItemType, boolean isMoving, boolean isSeed) {
        byte direction = getDirectionIndexByLastAction(actionIndex);

        if (isSeed) {
            if (isMoving) {
                switch (direction) {
                    case Direction.up:
                        return ANI_RUNNING_ITEM_UP;
                    case Direction.right:
                        return ANI_RUNNING_ITEM_RIGHT;
                    case Direction.down:
                        return ANI_RUNNING_ITEM_DOWN;
                    case Direction.left:
                        return ANI_RUNNING_ITEM_LEFT;
                    default:
                        return Direction.down;
                }
            }
            switch (direction) {
                case Direction.up:
                    return ANI_IDLE_ITEM_UP;
                case Direction.right:
                    return ANI_IDLE_ITEM_RIGHT;
                case Direction.down:
                    return ANI_IDLE_ITEM_DOWN;
                case Direction.left:
                    return ANI_IDLE_ITEM_LEFT;
                default:
                    return Direction.down;
            }
        }

        if (inventoryItemType == InventoryItemGroups.tool) {
            switch (direction) {
                case Direction.up:
                    return ANI_MINE_UP;
                case Direction.right:
                    return ANI_MINE_RIGHT;
                case Direction.down:
                    return ANI_MINE_DOWN;
                case Direction.left:
                    return ANI_MINE_LEFT;
                default:
                    return Direction.down;
            }
        }
        switch (direction) {
            case Direction.up:
                return ANI_HARVEST_UP;
            case Direction.right:
                return ANI_HARVEST_RIGHT;
            case Direction.down:
                return ANI_HARVEST_DOWN;
            case Direction.left:
                return ANI_HARVEST_LEFT;
            default:
                return Direction.down;
        }
    }

    public static ArrayList<DimensionCordVector> getCheckboxArray() {
        ArrayList<DimensionCordVector> payload = new ArrayList<>();
        payload.add(new DimensionCordVector(10, 5, 3, 0));
        return payload;
    }

    public static boolean getIsActionByAniIndex(ActionTypes actionType, int playerAniIndex) {
        if (actionType == null) {
            return false;
        }

        byte targetAniIndex = fireActionIndices.get(actionType);
        return targetAniIndex == playerAniIndex;
    }
}
