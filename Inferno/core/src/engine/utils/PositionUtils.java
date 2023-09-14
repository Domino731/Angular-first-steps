package engine.utils;

import utils.vectors.Vector;

public class PositionUtils {
    public static Vector<Integer> convertTilePosition(int x, int y) {
        return new Vector<>(x * 16, y * 16);
    }
    public static Vector<Integer> convertTilePosition(Vector<Integer> position) {
        return new Vector<>(position.x * 16, position.y * 16);
    }
}
