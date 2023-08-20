package game.entities.player.tools;

import utils.Direction;

public class ToolsConstants {
    public static final byte[][] rightAxeAnimation = createRightAxeAnimation();
    public static final byte[][][] animations = createToolAnimationArray();

    /**
     * 0 - x offset
     * 1 - y offset
     * 3 - rotation angle
     */

    private static byte[][] createRightAxeAnimation() {
        byte[][] rightAxeAnimation = new byte[5][3];
        rightAxeAnimation[0][0] = -8;
        rightAxeAnimation[0][1] = -2;
        rightAxeAnimation[0][2] = 15;

        rightAxeAnimation[1][0] = 5;
        rightAxeAnimation[1][1] = -1;
        rightAxeAnimation[1][2] = -15;

        rightAxeAnimation[2][0] = 16;
        rightAxeAnimation[2][1] = -6;
        rightAxeAnimation[2][2] = -45;

        rightAxeAnimation[3][0] = 21;
        rightAxeAnimation[3][1] = -24;
        rightAxeAnimation[3][2] = -105;

        rightAxeAnimation[4][0] = 21;
        rightAxeAnimation[4][1] = -26;
        rightAxeAnimation[4][2] = -105;

        return rightAxeAnimation;
    }

    private static byte[][] createLeftAxeAnimation() {
        byte[][] rightAxeAnimation = new byte[5][3];
        rightAxeAnimation[0][0] = 8;
        rightAxeAnimation[0][1] = -2;
        rightAxeAnimation[0][2] = -15;

        rightAxeAnimation[1][0] = -5;
        rightAxeAnimation[1][1] = -1;
        rightAxeAnimation[1][2] = 15;

        rightAxeAnimation[2][0] = -16;
        rightAxeAnimation[2][1] = -6;
        rightAxeAnimation[2][2] = 45;

        rightAxeAnimation[3][0] = -21;
        rightAxeAnimation[3][1] = -24;
        rightAxeAnimation[3][2] = 105;

        rightAxeAnimation[4][0] = -21;
        rightAxeAnimation[4][1] = -26;
        rightAxeAnimation[4][2] = 105;

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
