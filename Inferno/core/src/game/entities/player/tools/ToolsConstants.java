package game.entities.player.tools;

import utils.Direction;

public class ToolsConstants {
    public static final byte[][] rightAxeAnimation = createRightAxeAnimation();
    public static final byte[][][] animations = createToolAnimationArray();
    private static final byte xIndex = 0;
    private static final byte yIndex = 1;
    private static final byte rotateIndex = 2;

    private static byte[][] createRightAxeAnimation() {
        byte[][] rightAxeAnimation = new byte[5][3];
        rightAxeAnimation[0][xIndex] = -8;
        rightAxeAnimation[0][yIndex] = -2;
        rightAxeAnimation[0][rotateIndex] = 15;

        rightAxeAnimation[1][xIndex] = 5;
        rightAxeAnimation[1][yIndex] = -1;
        rightAxeAnimation[1][rotateIndex] = -15;

        rightAxeAnimation[2][xIndex] = 16;
        rightAxeAnimation[2][yIndex] = -6;
        rightAxeAnimation[2][rotateIndex] = -45;

        rightAxeAnimation[3][xIndex] = 21;
        rightAxeAnimation[3][yIndex] = -24;
        rightAxeAnimation[3][rotateIndex] = -105;

        rightAxeAnimation[4][xIndex] = 21;
        rightAxeAnimation[4][yIndex] = -26;
        rightAxeAnimation[4][rotateIndex] = -105;

        return rightAxeAnimation;
    }

    private static byte[][] createLeftAxeAnimation() {
        byte[][] rightAxeAnimation = new byte[5][3];
        rightAxeAnimation[0][xIndex] = 8;
        rightAxeAnimation[0][yIndex] = -2;
        rightAxeAnimation[0][rotateIndex] = -15;

        rightAxeAnimation[1][xIndex] = -5;
        rightAxeAnimation[1][yIndex] = -1;
        rightAxeAnimation[1][rotateIndex] = 15;

        rightAxeAnimation[2][xIndex] = -16;
        rightAxeAnimation[2][yIndex] = -6;
        rightAxeAnimation[2][rotateIndex] = 45;

        rightAxeAnimation[3][xIndex] = -21;
        rightAxeAnimation[3][yIndex] = -24;
        rightAxeAnimation[3][rotateIndex] = 105;

        rightAxeAnimation[4][xIndex] = -21;
        rightAxeAnimation[4][yIndex] = -26;
        rightAxeAnimation[4][rotateIndex] = 105;

        return rightAxeAnimation;
    }

    private static byte[][][] createToolAnimationArray() {
        byte[][][] payload = new byte[4][5][3];
        payload[Direction.up] = createRightAxeAnimation();
        payload[Direction.right] = createRightAxeAnimation();
        payload[Direction.down] = createRightAxeAnimation();
        payload[Direction.left] = createLeftAxeAnimation();
        return payload;
    }

}
