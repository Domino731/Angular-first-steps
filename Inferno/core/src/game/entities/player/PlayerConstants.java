package game.entities.player;

import utils.TextureData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class PlayerConstants {
    public static Vector<Integer> position = new Vector<>(100, 100);
    public static ArrayList<DimensionCordVector> checkboxArray = getCheckboxArray();
    public static final String textureSrc = "sprites/entities/player_new_1.png";
    public static final TextureData textureData = new TextureData((short) 9, (short) 6, (short) 64, (short) 40, textureSrc);
    public static final DimensionVector<Integer> dim = new DimensionVector<>(64, 40);
    public static final byte hairXOffset = -2;
    public static final DimensionVector<Byte> shirtDim = new DimensionVector<>((byte) 8, (byte) 8);
    public static final int[] skinColors = {-106001921, -529832449, 1795177215};

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
    // HARVEST
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


    // ANIMATION CONSTANTS - LENGTH
    public static final byte ANI_CUT_TREE_LENGTH = 5;


    private static ArrayList<DimensionCordVector> getCheckboxArray() {
        ArrayList<DimensionCordVector> payload = new ArrayList<>();
        payload.add(new DimensionCordVector(10, 5, 3, 0));
        return payload;
    }
}
