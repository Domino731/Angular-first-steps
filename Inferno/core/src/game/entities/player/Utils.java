package game.entities.player;

import utils.Direction;

public class Utils {
    public static byte getDirectionByLastAction(int actionIndex) {
        switch (actionIndex) {
            case PlayerTextures.STATE_HARVEST_WEED_LEFT:
            case PlayerTextures.STATE_IDLE_LEFT:
            case PlayerTextures.STATE_RUNNING_LEFT:
            case PlayerTextures.STATE_HARVEST_LEFT:
                return Direction.left;
            case PlayerTextures.STATE_HARVEST_WEED_RIGHT:
            case PlayerTextures.STATE_IDLE_RIGHT:
            case PlayerTextures.STATE_RUNNING_RIGHT:
            case PlayerTextures.STATE_HARVEST_RIGHT:
                return Direction.right;
            case PlayerTextures.STATE_HARVEST_WEED_DOWN:
            case PlayerTextures.STATE_IDLE_DOWN:
            case PlayerTextures.STATE_RUNNING_DOWN:
            case PlayerTextures.STATE_MINE_RES:
                return Direction.down;
            case PlayerTextures.STATE_HARVEST_WEED_UP:
            case PlayerTextures.STATE_IDLE_UP:
            case PlayerTextures.STATE_RUNNING_UP:
            case PlayerTextures.STATE_HARVEST_UP:
                return Direction.up;
            default:
                return Direction.down;
        }
    }

    public static byte getHarvestWeedAniIndex(int actionIndex) {
        byte direction = getDirectionByLastAction(actionIndex);
        switch (direction) {
            case Direction.up:
                return PlayerTextures.STATE_HARVEST_WEED_UP;
            case Direction.right:
                return PlayerTextures.STATE_HARVEST_WEED_RIGHT;
            case Direction.down:
                return PlayerTextures.STATE_HARVEST_WEED_DOWN;
            case Direction.left:
                return PlayerTextures.STATE_HARVEST_WEED_LEFT;
            default:
                return Direction.down;
        }
    }

}
