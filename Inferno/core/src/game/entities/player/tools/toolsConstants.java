package game.entities.player.tools;

public class toolsConstants {
    public static byte[][] rightAxeAnimation = createRightAxeAnimation();


    private static byte[][] createRightAxeAnimation() {
        byte[][] rightAxeAnimation = new byte[5][3];
        rightAxeAnimation[0][1] = -8;
        rightAxeAnimation[0][2] = 0;
        rightAxeAnimation[0][3] = 15;
        rightAxeAnimation[1][1] = 5;
        rightAxeAnimation[1][2] = 0;
        rightAxeAnimation[1][3] = -15;
        rightAxeAnimation[2][1] = 16;
        rightAxeAnimation[2][2] = -5;
        rightAxeAnimation[2][3] = -45;
        rightAxeAnimation[3][1] = 21;
        rightAxeAnimation[3][2] = -23;
        rightAxeAnimation[3][3] = -105;
        rightAxeAnimation[4][1] = 21;
        rightAxeAnimation[4][2] = -25;
        rightAxeAnimation[4][3] = -105;

        return rightAxeAnimation;
    }
}
