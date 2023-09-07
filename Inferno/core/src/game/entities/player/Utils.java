package game.entities.player;

import game.entities.player.inventory.InventoryItemGroups;
import utils.Direction;

public class Utils {
    public static byte getDirectionByLastAction(int actionIndex) {
        switch (actionIndex) {
            case PlayerTextures.ANI_HARVEST_LEFT:
            case PlayerTextures.ANI_IDLE_LEFT:
            case PlayerTextures.ANI_RUNNING_LEFT:
            case PlayerTextures.ANI_MINE_LEFT:
            case PlayerTextures.ANI_IDLE_ITEM_LEFT:
            case PlayerTextures.ANI_RUNNING_ITEM_LEFT:
                return Direction.left;
            case PlayerTextures.ANI_HARVEST_RIGHT:
            case PlayerTextures.ANI_IDLE_RIGHT:
            case PlayerTextures.ANI_RUNNING_RIGHT:
            case PlayerTextures.ANI_MINE_RIGHT:
            case PlayerTextures.ANI_IDLE_ITEM_RIGHT:
            case PlayerTextures.ANI_RUNNING_ITEM_RIGHT:
                return Direction.right;
            case PlayerTextures.ANI_HARVEST_DOWN:
            case PlayerTextures.ANI_IDLE_DOWN:
            case PlayerTextures.ANI_RUNNING_DOWN:
            case PlayerTextures.ANI_MINE_DOWN:
            case PlayerTextures.ANI_IDLE_ITEM_DOWN:
            case PlayerTextures.ANI_RUNNING_ITEM_DOWN:
                return Direction.down;
            case PlayerTextures.ANI_HARVEST_UP:
            case PlayerTextures.ANI_IDLE_UP:
            case PlayerTextures.ANI_RUNNING_UP:
            case PlayerTextures.ANI_MINE_UP:
            case PlayerTextures.ANI_IDLE_ITEM_UP:
            case PlayerTextures.ANI_RUNNING_ITEM_UP:
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
                        return PlayerTextures.ANI_RUNNING_ITEM_UP;
                    case Direction.right:
                        return PlayerTextures.ANI_RUNNING_ITEM_RIGHT;
                    case Direction.down:
                        return PlayerTextures.ANI_RUNNING_ITEM_DOWN;
                    case Direction.left:
                        return PlayerTextures.ANI_RUNNING_ITEM_LEFT;
                    default:
                        return Direction.down;
                }
            }
            switch (direction) {
                case Direction.up:
                    return PlayerTextures.ANI_IDLE_ITEM_UP;
                case Direction.right:
                    return PlayerTextures.ANI_IDLE_ITEM_RIGHT;
                case Direction.down:
                    return PlayerTextures.ANI_IDLE_ITEM_DOWN;
                case Direction.left:
                    return PlayerTextures.ANI_IDLE_ITEM_LEFT;
                default:
                    return Direction.down;
            }
        }

        if (inventoryItemType == InventoryItemGroups.tool) {
            switch (direction) {
                case Direction.up:
                    return PlayerTextures.ANI_MINE_UP;
                case Direction.right:
                    return PlayerTextures.ANI_MINE_RIGHT;
                case Direction.down:
                    return PlayerTextures.ANI_MINE_DOWN;
                case Direction.left:
                    return PlayerTextures.ANI_MINE_LEFT;
                default:
                    return Direction.down;
            }
        }
        switch (direction) {
            case Direction.up:
                return PlayerTextures.ANI_HARVEST_UP;
            case Direction.right:
                return PlayerTextures.ANI_HARVEST_RIGHT;
            case Direction.down:
                return PlayerTextures.ANI_HARVEST_DOWN;
            case Direction.left:
                return PlayerTextures.ANI_HARVEST_LEFT;
            default:
                return Direction.down;
        }

    }

    public static byte getMineAniIndex(int actionIndex) {
        byte direction = getDirectionByLastAction(actionIndex);
        switch (direction) {
            case Direction.up:
                return PlayerTextures.ANI_MINE_UP;
            case Direction.right:
                return PlayerTextures.ANI_MINE_RIGHT;
            case Direction.down:
                return PlayerTextures.ANI_MINE_DOWN;
            case Direction.left:
                return PlayerTextures.ANI_MINE_LEFT;
            default:
                return Direction.down;
        }
    }
}
