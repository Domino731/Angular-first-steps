package game.player.animations.config;

import utils.Direction;

public class ToolAnimationConfig {
    public static final byte[][][] animations = createToolAnimationArray();
    // Array config
    public static final byte aniAmount = 4;
    public static final byte aniLength = 6;
    public static final byte aniDataLength = 5;

    private static byte[][] createUpAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][AniConfigConstants.xIndex] = 0;
        payload[0][AniConfigConstants.yIndex] = 25;
        payload[0][AniConfigConstants.rotateIndex] = 0;
        payload[0][AniConfigConstants.txtIndex] = 0;
        payload[0][AniConfigConstants.zIndex] = 0;

        payload[1][AniConfigConstants.xIndex] = 0;
        payload[1][AniConfigConstants.yIndex] = 22;
        payload[1][AniConfigConstants.rotateIndex] = 0;
        payload[1][AniConfigConstants.txtIndex] = 0;
        payload[1][AniConfigConstants.zIndex] = 0;

        payload[2][AniConfigConstants.xIndex] = 0;
        payload[2][AniConfigConstants.yIndex] = 16;
        payload[2][AniConfigConstants.rotateIndex] = 0;
        payload[2][AniConfigConstants.txtIndex] = 1;
        payload[2][AniConfigConstants.zIndex] = 0;

        payload[3][AniConfigConstants.xIndex] = 0;
        payload[3][AniConfigConstants.yIndex] = 10;
        payload[3][AniConfigConstants.rotateIndex] = 0;
        payload[3][AniConfigConstants.txtIndex] = 1;
        payload[3][AniConfigConstants.zIndex] = 0;

        payload[4][AniConfigConstants.xIndex] = 0;
        payload[4][AniConfigConstants.yIndex] = 1;
        payload[4][AniConfigConstants.rotateIndex] = 0;
        payload[4][AniConfigConstants.txtIndex] = 1;
        payload[4][AniConfigConstants.zIndex] = 0;

        payload[5][AniConfigConstants.xIndex] = 0;
        payload[5][AniConfigConstants.yIndex] = 1;
        payload[5][AniConfigConstants.rotateIndex] = 0;
        payload[5][AniConfigConstants.txtIndex] = 1;
        payload[5][AniConfigConstants.zIndex] = 0;

        return payload;
    }

    private static byte[][] createDownAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][AniConfigConstants.xIndex] = -5;
        payload[0][AniConfigConstants.yIndex] = 21;
        payload[0][AniConfigConstants.rotateIndex] = 0;
        payload[0][AniConfigConstants.txtIndex] = 0;
        payload[0][AniConfigConstants.zIndex] = 1;

        payload[1][AniConfigConstants.xIndex] = -3;
        payload[1][AniConfigConstants.yIndex] = 16;
        payload[1][AniConfigConstants.rotateIndex] = 10;
        payload[1][AniConfigConstants.txtIndex] = 0;
        payload[1][AniConfigConstants.zIndex] = 1;

        payload[2][AniConfigConstants.xIndex] = 0;
        payload[2][AniConfigConstants.yIndex] = 2;
        payload[2][AniConfigConstants.rotateIndex] = 0;
        payload[2][AniConfigConstants.txtIndex] = 1;
        payload[2][AniConfigConstants.zIndex] = 1;

        payload[3][AniConfigConstants.xIndex] = 0;
        payload[3][AniConfigConstants.yIndex] = 0;
        payload[3][AniConfigConstants.rotateIndex] = 0;
        payload[3][AniConfigConstants.txtIndex] = 1;
        payload[3][AniConfigConstants.zIndex] = 1;

        payload[4][AniConfigConstants.xIndex] = 0;
        payload[4][AniConfigConstants.yIndex] = 0;
        payload[4][AniConfigConstants.rotateIndex] = 0;
        payload[4][AniConfigConstants.txtIndex] = 1;
        payload[4][AniConfigConstants.zIndex] = 1;
        return payload;
    }

    private static byte[][] createRightAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][AniConfigConstants.xIndex] = -8;
        payload[0][AniConfigConstants.yIndex] = 18;
        payload[0][AniConfigConstants.rotateIndex] = 15;
        payload[0][AniConfigConstants.txtIndex] = 0;
        payload[0][AniConfigConstants.zIndex] = 1;

        payload[1][AniConfigConstants.xIndex] = 5;
        payload[1][AniConfigConstants.yIndex] = 19;
        payload[1][AniConfigConstants.rotateIndex] = -15;
        payload[1][AniConfigConstants.txtIndex] = 0;
        payload[1][AniConfigConstants.zIndex] = 1;

        payload[2][AniConfigConstants.xIndex] = 16;
        payload[2][AniConfigConstants.yIndex] = 14;
        payload[2][AniConfigConstants.rotateIndex] = -45;
        payload[2][AniConfigConstants.txtIndex] = 0;
        payload[2][AniConfigConstants.zIndex] = 1;

        payload[3][AniConfigConstants.xIndex] = 21;
        payload[3][AniConfigConstants.yIndex] = -4;
        payload[3][AniConfigConstants.rotateIndex] = -105;
        payload[3][AniConfigConstants.txtIndex] = 0;
        payload[3][AniConfigConstants.zIndex] = 1;

        payload[4][AniConfigConstants.xIndex] = 21;
        payload[4][AniConfigConstants.yIndex] = -6;
        payload[4][AniConfigConstants.rotateIndex] = -105;
        payload[4][AniConfigConstants.txtIndex] = 0;
        payload[4][AniConfigConstants.zIndex] = 1;
        return payload;
    }

    private static byte[][] createLeftAxeAnimation() {
        byte[][] payload = new byte[aniLength][aniDataLength];

        payload[0][AniConfigConstants.xIndex] = 8;
        payload[0][AniConfigConstants.yIndex] = 18;
        payload[0][AniConfigConstants.rotateIndex] = -15;
        payload[0][AniConfigConstants.txtIndex] = 0;
        payload[0][AniConfigConstants.zIndex] = 1;

        payload[1][AniConfigConstants.xIndex] = -5;
        payload[1][AniConfigConstants.yIndex] = 19;
        payload[1][AniConfigConstants.rotateIndex] = 15;
        payload[1][AniConfigConstants.txtIndex] = 0;
        payload[1][AniConfigConstants.zIndex] = 1;

        payload[2][AniConfigConstants.xIndex] = -16;
        payload[2][AniConfigConstants.yIndex] = 14;
        payload[2][AniConfigConstants.rotateIndex] = 45;
        payload[2][AniConfigConstants.txtIndex] = 0;
        payload[2][AniConfigConstants.zIndex] = 1;

        payload[3][AniConfigConstants.xIndex] = -21;
        payload[3][AniConfigConstants.yIndex] = -4;
        payload[3][AniConfigConstants.rotateIndex] = 105;
        payload[3][AniConfigConstants.txtIndex] = 0;
        payload[3][AniConfigConstants.zIndex] = 1;

        payload[4][AniConfigConstants.xIndex] = -21;
        payload[4][AniConfigConstants.yIndex] = -6;
        payload[4][AniConfigConstants.rotateIndex] = 105;
        payload[4][AniConfigConstants.txtIndex] = 0;
        payload[4][AniConfigConstants.zIndex] = 1;
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
