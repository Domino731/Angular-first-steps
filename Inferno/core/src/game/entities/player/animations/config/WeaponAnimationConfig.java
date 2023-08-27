package game.entities.player.animations.config;

import utils.Direction;

public class WeaponAnimationConfig {
    public static final short[][] rightAxeAnimation = createRightAxeAnimation();
    public static final short[][][] animations = createToolAnimationArray();
    // Array indices
    public static final byte xIndex = 0;
    public static final byte yIndex = 1;
    public static final byte rotateIndex = 2;
    public static final byte txtIndex = 3;
    // Array config
    public static final byte aniAmount = 4;
    public static final byte aniLength = 6;
    public static final byte aniDataLength = 4;

    private static short[][] createUpAxeAnimation() {
        short[][] payload = new short[aniLength][aniDataLength];

        payload[0][xIndex] = -10;
        payload[0][yIndex] = 7;
        payload[0][rotateIndex] = 135;
        payload[0][txtIndex] = 0;

        payload[1][xIndex] = -6;
        payload[1][yIndex] = 16;
        payload[1][rotateIndex] = 70;
        payload[1][txtIndex] = 0;

        payload[2][xIndex] = -1;
        payload[2][yIndex] = 20;
        payload[2][rotateIndex] = 50;
        payload[2][txtIndex] = 1;

        payload[3][xIndex] = 8;
        payload[3][yIndex] = 20;
        payload[3][rotateIndex] = 26;
        payload[3][txtIndex] = 1;

        payload[4][xIndex] = 14;
        payload[4][yIndex] = 18;
        payload[4][rotateIndex] = 3;
        payload[4][txtIndex] = 1;

        payload[5][xIndex] = 17;
        payload[5][yIndex] = 12;
        payload[5][rotateIndex] = -27;
        payload[5][txtIndex] = 1;
        return payload;
    }

    private static short[][] createDownAxeAnimation() {
        short[][] payload = new short[aniLength][aniDataLength];

        payload[0][xIndex] = 16;
        payload[0][yIndex] = 6;
        payload[0][rotateIndex] = -28;
        payload[0][txtIndex] = 0;

        payload[1][xIndex] = 11;
        payload[1][yIndex] = -6;
        payload[1][rotateIndex] = -90;
        payload[1][txtIndex] = 0;

        payload[2][xIndex] = 8;
        payload[2][yIndex] = -8;
        payload[2][rotateIndex] = -100;
        payload[2][txtIndex] = 1;

        payload[3][xIndex] = -3;
        payload[3][yIndex] = -11;
        payload[3][rotateIndex] = -130;
        payload[3][txtIndex] = 1;

        payload[4][xIndex] = -11;
        payload[4][yIndex] = -11;
        payload[4][rotateIndex] = -170;
        payload[4][txtIndex] = 1;

        payload[5][xIndex] = -11;
        payload[5][yIndex] = -11;
        payload[5][rotateIndex] = -170;
        payload[5][txtIndex] = 1;
        return payload;
    }

    private static short[][] createRightAxeAnimation() {
        short[][] payload = new short[aniLength][aniDataLength];

        payload[0][xIndex] = -8;
        payload[0][yIndex] = -2;
        payload[0][rotateIndex] = 15;
        payload[0][txtIndex] = 0;

        payload[1][xIndex] = 5;
        payload[1][yIndex] = -1;
        payload[1][rotateIndex] = -15;
        payload[1][txtIndex] = 0;

        payload[2][xIndex] = 16;
        payload[2][yIndex] = -6;
        payload[2][rotateIndex] = -45;
        payload[2][txtIndex] = 0;

        payload[3][xIndex] = 21;
        payload[3][yIndex] = -24;
        payload[3][rotateIndex] = -105;
        payload[3][txtIndex] = 0;

        payload[4][xIndex] = 21;
        payload[4][yIndex] = -26;
        payload[4][rotateIndex] = -105;
        payload[4][txtIndex] = 0;

        return payload;
    }

    private static short[][] createLeftAxeAnimation() {
        short[][] payload = new short[aniLength][aniDataLength];

        payload[0][xIndex] = 8;
        payload[0][yIndex] = -2;
        payload[0][rotateIndex] = -15;
        payload[0][txtIndex] = 0;

        payload[1][xIndex] = -5;
        payload[1][yIndex] = -1;
        payload[1][rotateIndex] = 15;
        payload[1][txtIndex] = 0;

        payload[2][xIndex] = -16;
        payload[2][yIndex] = -6;
        payload[2][rotateIndex] = 45;
        payload[2][txtIndex] = 0;

        payload[3][xIndex] = -21;
        payload[3][yIndex] = -24;
        payload[3][rotateIndex] = 105;
        payload[3][txtIndex] = 0;

        payload[4][xIndex] = -21;
        payload[4][yIndex] = -26;
        payload[4][rotateIndex] = 105;
        payload[4][txtIndex] = 0;

        return payload;
    }

    private static short[][][] createToolAnimationArray() {
        short[][][] payload = new short[aniAmount][aniLength][aniDataLength];

        payload[Direction.up] = createUpAxeAnimation();
        payload[Direction.right] = createRightAxeAnimation();
        payload[Direction.down] = createDownAxeAnimation();
        payload[Direction.left] = createLeftAxeAnimation();

        return payload;
    }
}
