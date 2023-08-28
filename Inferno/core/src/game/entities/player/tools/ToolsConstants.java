package game.entities.player.tools;

import utils.Direction;

public class ToolsConstants {
    public static final byte[][] rightAxeAnimation = createRightAxeAnimation();
    public static final byte[][][] animations = createToolAnimationArray();
    // Array indices
    public static final byte xIndex = 0;
    public static final byte yIndex = 1;
    public static final byte rotateIndex = 2;
    public static final byte txtIndex = 3;
    public static final byte zIndex = 4;
    // Array config
    public static final byte aniAmount = 4;
    public static final byte aniLength = 5;
    public static final byte aniDataLength = 5;

    private static byte[][] createUpAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][xIndex] = 0;
        payload[0][yIndex] = 25;
        payload[0][rotateIndex] = 0;
        payload[0][txtIndex] = 0;
        payload[0][zIndex] = 0;

        payload[1][xIndex] = 0;
        payload[1][yIndex] = 22;
        payload[1][rotateIndex] = 0;
        payload[1][txtIndex] = 0;
        payload[1][zIndex] = 0;

        payload[2][xIndex] = 0;
        payload[2][yIndex] = 16;
        payload[2][rotateIndex] = 0;
        payload[2][txtIndex] = 1;
        payload[2][zIndex] = 0;

        payload[3][xIndex] = 0;
        payload[3][yIndex] = 10;
        payload[3][rotateIndex] = 0;
        payload[3][txtIndex] = 1;
        payload[3][zIndex] = 0;

        payload[4][xIndex] = 0;
        payload[4][yIndex] = 1;
        payload[4][rotateIndex] = 0;
        payload[4][txtIndex] = 1;
        payload[4][zIndex] = 0;

        return payload;
    }

    private static byte[][] createDownAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][xIndex] = -5;
        payload[0][yIndex] = 21;
        payload[0][rotateIndex] = 0;
        payload[0][txtIndex] = 0;
        payload[0][zIndex] = 1;

        payload[1][xIndex] = -3;
        payload[1][yIndex] = 16;
        payload[1][rotateIndex] = 10;
        payload[1][txtIndex] = 0;
        payload[1][zIndex] = 1;

        payload[2][xIndex] = 0;
        payload[2][yIndex] = 2;
        payload[2][rotateIndex] = 0;
        payload[2][txtIndex] = 1;
        payload[2][zIndex] = 1;

        payload[3][xIndex] = 0;
        payload[3][yIndex] = 0;
        payload[3][rotateIndex] = 0;
        payload[3][txtIndex] = 1;
        payload[3][zIndex] = 1;

        payload[4][xIndex] = 0;
        payload[4][yIndex] = 0;
        payload[4][rotateIndex] = 0;
        payload[4][txtIndex] = 1;
        payload[4][zIndex] = 1;
        return payload;
    }

    private static byte[][] createRightAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][xIndex] = -8;
        payload[0][yIndex] = 18;
        payload[0][rotateIndex] = 15;
        payload[0][txtIndex] = 0;
        payload[0][zIndex] = 1;

        payload[1][xIndex] = 5;
        payload[1][yIndex] = 19;
        payload[1][rotateIndex] = -15;
        payload[1][txtIndex] = 0;
        payload[1][zIndex] = 1;

        payload[2][xIndex] = 16;
        payload[2][yIndex] = 14;
        payload[2][rotateIndex] = -45;
        payload[2][txtIndex] = 0;
        payload[2][zIndex] = 1;

        payload[3][xIndex] = 21;
        payload[3][yIndex] = -4;
        payload[3][rotateIndex] = -105;
        payload[3][txtIndex] = 0;
        payload[3][zIndex] = 1;

        payload[4][xIndex] = 21;
        payload[4][yIndex] = -6;
        payload[4][rotateIndex] = -105;
        payload[4][txtIndex] = 0;
        payload[4][zIndex] = 1;
        return payload;
    }

    private static byte[][] createLeftAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][xIndex] = 8;
        payload[0][yIndex] = 18;
        payload[0][rotateIndex] = -15;
        payload[0][txtIndex] = 0;
        payload[0][zIndex] = 1;

        payload[1][xIndex] = -5;
        payload[1][yIndex] = 19;
        payload[1][rotateIndex] = 15;
        payload[1][txtIndex] = 0;
        payload[1][zIndex] = 1;

        payload[2][xIndex] = -16;
        payload[2][yIndex] = 14;
        payload[2][rotateIndex] = 45;
        payload[2][txtIndex] = 0;
        payload[2][zIndex] = 1;

        payload[3][xIndex] = -21;
        payload[3][yIndex] = -4;
        payload[3][rotateIndex] = 105;
        payload[3][txtIndex] = 0;
        payload[3][zIndex] = 1;

        payload[4][xIndex] = -21;
        payload[4][yIndex] = -6;
        payload[4][rotateIndex] = 105;
        payload[4][txtIndex] = 0;
        payload[4][zIndex] = 1;
        return payload;
    }

    private static byte[][][] createToolAnimationArray() {
        byte[][][] payload = new byte[aniAmount][aniLength][aniDataLength];

        payload[Direction.up] = createUpAxeAnimation();
        payload[Direction.right] = createRightAxeAnimation();
        payload[Direction.down] = createDownAxeAnimation();
        payload[Direction.left] = createLeftAxeAnimation();

        return payload;
    }
}
