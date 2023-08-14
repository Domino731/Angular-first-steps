package game.entities.player;

import utils.TextureData;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class PlayerConstants {
    public static Vector<Integer> position = new Vector<>(100, 100);
    public static ArrayList<DimensionCordVector> checkboxArray = getCheckboxArray();
    public static final String textureSrc = "sprites/entities/player.png";
    public static final TextureData textureData = new TextureData((short) 9, (short) 6, (short) 64, (short) 40, textureSrc);
    public static final DimensionVector<Integer> dim = new DimensionVector<>(64, 40);
    public static final byte hairXOffset = -2;
    public static final byte hairYOffset = 17;
    public static byte hatTextureIndex = 2;
    public static final DimensionVector<Byte> shirtDim = new DimensionVector<>((byte) 8, (byte) 8);
    public static final int[] skinColors = {-106001921, -529832449, 1795177215};

    public static void setHatTextureIndex(byte value) {
        hatTextureIndex = value;
    }

    private static ArrayList<DimensionCordVector> getCheckboxArray() {
        ArrayList<DimensionCordVector> payload = new ArrayList<>();
        payload.add(new DimensionCordVector(10, 10, 10, 10));
        return payload;
    }
}
