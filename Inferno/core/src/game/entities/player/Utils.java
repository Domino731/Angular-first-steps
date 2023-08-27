package game.entities.player;

import utils.Direction;

public class Utils {
    public static byte getDirectionByLastAction(byte actionIndex) {
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
}
