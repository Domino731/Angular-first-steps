package game.entities.player;

import engine.actionCollision.ActionTypes;
import utils.Direction;
import utils.TextureData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;
import java.util.HashMap;

import static constants.Urls.SPRITE_HATS;
import static game.entities.player.Utils.getCheckboxArray;

public class PlayerConstants {
    public static Vector<Integer> position = new Vector<>(100, 100);
    public static ArrayList<DimensionCordVector> checkboxArray = getCheckboxArray();
    public static final TextureData textureData = new TextureData((short) 9, (short) 6, (short) 64, (short) 40, SPRITE_HATS);
    public static final DimensionVector<Integer> dim = new DimensionVector<>(64, 40);
    public static final byte hairXOffset = -2;
    public static final DimensionVector<Byte> shirtDim = new DimensionVector<>((byte) 8, (byte) 8);
    public static final int[] skinColors = {-106001921, -529832449, 1795177215};

    // ANIMATIONS GENERAL DATA
    public static final int ANI_MAX_FRAMES = 8;
    public static final byte ANI_AMOUNT = 24;

    // ANIMATION INDICES

    // IDLE
    public static final int ANI_IDLE_UP = 0;
    public static final int ANI_IDLE_RIGHT = 1;
    public static final int ANI_IDLE_DOWN = 2;
    public static final int ANI_IDLE_LEFT = 3;
    // RUNNING
    public static final int ANI_RUNNING_UP = 4;
    public static final int ANI_RUNNING_RIGHT = 5;
    public static final int ANI_RUNNING_DOWN = 6;
    public static final int ANI_RUNNING_LEFT = 7;
    // MINE
    public static final byte ANI_MINE_UP = 8;
    public static final byte ANI_MINE_RIGHT = 9;
    public static final byte ANI_MINE_LEFT = 10;
    public static final byte ANI_MINE_DOWN = 11;
    // HARVEST
    public static final byte ANI_HARVEST_UP = 12;
    public static final byte ANI_HARVEST_RIGHT = 13;
    public static final byte ANI_HARVEST_LEFT = 14;
    public static final byte ANI_HARVEST_DOWN = 15;
    // IDLE WITH ITEM
    public static final byte ANI_IDLE_ITEM_UP = 16;
    public static final byte ANI_IDLE_ITEM_RIGHT = 17;
    public static final byte ANI_IDLE_ITEM_DOWN = 18;
    public static final byte ANI_IDLE_ITEM_LEFT = 19;
    // RUNNING WITH ITEM
    public static final byte ANI_RUNNING_ITEM_UP = 20;
    public static final byte ANI_RUNNING_ITEM_RIGHT = 21;
    public static final byte ANI_RUNNING_ITEM_DOWN = 22;
    public static final byte ANI_RUNNING_ITEM_LEFT = 23;

    public static final byte[] REVERSED_TEXTURES_INDICES = new byte[]{ANI_IDLE_LEFT, ANI_RUNNING_LEFT, ANI_MINE_LEFT, ANI_HARVEST_LEFT, ANI_IDLE_ITEM_LEFT, ANI_RUNNING_ITEM_LEFT};

    // ANIMATION ACTION CONSTANTS - when action need to trigger (not animation length)?
    public static final byte ANI_ACTION_MINE_ACTION = 5;

    public static final HashMap<ActionTypes, Byte> fireActionIndices = createFireActionIndices();

    //  Array with animation indices sorted by direction
    public static final byte[][] ANI_INDICES_BY_DIRECTION = createAniIndicesByDirection();

    ////////////////////////////////////////
    //// METHODS FOR CREATING CONSTANTS ////
    ////////////////////////////////////////

    private static byte[][] createAniIndicesByDirection() {
        // 4 - amount of directions - up, right, down, left
        // 6 - amount of available animations - idle, running, mine, harvest, idle with item, running with item...
        byte[][] data = new byte[4][6];

        data[Direction.up] = new byte[]{ANI_IDLE_UP, ANI_RUNNING_UP, ANI_MINE_UP, ANI_HARVEST_UP, ANI_IDLE_ITEM_UP, ANI_RUNNING_ITEM_UP};
        data[Direction.right] = new byte[]{ANI_IDLE_RIGHT, ANI_RUNNING_RIGHT, ANI_MINE_RIGHT, ANI_HARVEST_RIGHT, ANI_IDLE_ITEM_RIGHT, ANI_RUNNING_ITEM_RIGHT};
        data[Direction.down] = new byte[]{ANI_IDLE_DOWN, ANI_RUNNING_DOWN, ANI_MINE_DOWN, ANI_HARVEST_DOWN, ANI_IDLE_ITEM_DOWN, ANI_RUNNING_ITEM_DOWN};
        data[Direction.left] = new byte[]{ANI_IDLE_LEFT, ANI_RUNNING_LEFT, ANI_MINE_LEFT, ANI_HARVEST_LEFT, ANI_IDLE_ITEM_LEFT, ANI_RUNNING_ITEM_LEFT};

        return data;
    }

    private static HashMap<ActionTypes, Byte> createFireActionIndices() {
        HashMap<ActionTypes, Byte> data = new HashMap<>();

        data.put(ActionTypes.CUT_TREE, ANI_ACTION_MINE_ACTION);

        return data;
    }


}
