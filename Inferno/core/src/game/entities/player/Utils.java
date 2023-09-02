package game.entities.player;

import game.entities.player.inventory.InventoryItemGroups;
import utils.Direction;

public class Utils {
    public static byte getDirectionByLastAction(int actionIndex) {
        switch (actionIndex) {
            case PlayerTextures.STATE_HARVEST_LEFT:
            case PlayerTextures.STATE_IDLE_LEFT:
            case PlayerTextures.STATE_RUNNING_LEFT:
            case PlayerTextures.STATE_MINE_LEFT:
            case PlayerTextures.STATE_IDLE_ITEM_LEFT:
            case PlayerTextures.STATE_RUNNING_ITEM_LEFT:
                return Direction.left;
            case PlayerTextures.STATE_HARVEST_RIGHT:
            case PlayerTextures.STATE_IDLE_RIGHT:
            case PlayerTextures.STATE_RUNNING_RIGHT:
            case PlayerTextures.STATE_MINE_RIGHT:
            case PlayerTextures.STATE_IDLE_ITEM_RIGHT:
            case PlayerTextures.STATE_RUNNING_ITEM_RIGHT:
                return Direction.right;
            case PlayerTextures.STATE_HARVEST_DOWN:
            case PlayerTextures.STATE_IDLE_DOWN:
            case PlayerTextures.STATE_RUNNING_DOWN:
            case PlayerTextures.STATE_MINE_DOWN:
            case PlayerTextures.STATE_IDLE_ITEM_DOWN:
            case PlayerTextures.STATE_RUNNING_ITEM_DOWN:
                return Direction.down;
            case PlayerTextures.STATE_HARVEST_UP:
            case PlayerTextures.STATE_IDLE_UP:
            case PlayerTextures.STATE_RUNNING_UP:
            case PlayerTextures.STATE_MINE_UP:
            case PlayerTextures.STATE_IDLE_ITEM_UP:
            case PlayerTextures.STATE_RUNNING_ITEM_UP:
                return Direction.up;
            default:
                return Direction.down;
        }
    }

    public static byte getHarvestWeedAniIndex(int actionIndex, InventoryItemGroups inventoryItemType, boolean isMoving, boolean isSeed) {
        byte direction = getDirectionByLastAction(actionIndex);

        if (isSeed) {
            if (isMoving) {
                switch (direction) {
                    case Direction.up:
                        return PlayerTextures.STATE_RUNNING_ITEM_UP;
                    case Direction.right:
                        return PlayerTextures.STATE_RUNNING_ITEM_RIGHT;
                    case Direction.down:
                        return PlayerTextures.STATE_RUNNING_ITEM_DOWN;
                    case Direction.left:
                        return PlayerTextures.STATE_RUNNING_ITEM_LEFT;
                    default:
                        return Direction.down;
                }
            }
            switch (direction) {
                case Direction.up:
                    return PlayerTextures.STATE_IDLE_ITEM_UP;
                case Direction.right:
                    return PlayerTextures.STATE_IDLE_ITEM_RIGHT;
                case Direction.down:
                    return PlayerTextures.STATE_IDLE_ITEM_DOWN;
                case Direction.left:
                    return PlayerTextures.STATE_IDLE_ITEM_LEFT;
                default:
                    return Direction.down;
            }
        }

        if (inventoryItemType == InventoryItemGroups.tool) {
            switch (direction) {
                case Direction.up:
                    return PlayerTextures.STATE_MINE_UP;
                case Direction.right:
                    return PlayerTextures.STATE_MINE_RIGHT;
                case Direction.down:
                    return PlayerTextures.STATE_MINE_DOWN;
                case Direction.left:
                    return PlayerTextures.STATE_MINE_LEFT;
                default:
                    return Direction.down;
            }
        }
        switch (direction) {
            case Direction.up:
                return PlayerTextures.STATE_HARVEST_UP;
            case Direction.right:
                return PlayerTextures.STATE_HARVEST_RIGHT;
            case Direction.down:
                return PlayerTextures.STATE_HARVEST_DOWN;
            case Direction.left:
                return PlayerTextures.STATE_HARVEST_LEFT;
            default:
                return Direction.down;
        }

    }

    public static byte getMineAniIndex(int actionIndex) {
        byte direction = getDirectionByLastAction(actionIndex);
        switch (direction) {
            case Direction.up:
                return PlayerTextures.STATE_MINE_UP;
            case Direction.right:
                return PlayerTextures.STATE_MINE_RIGHT;
            case Direction.down:
                return PlayerTextures.STATE_MINE_DOWN;
            case Direction.left:
                return PlayerTextures.STATE_MINE_LEFT;
            default:
                return Direction.down;
        }
    }
}
