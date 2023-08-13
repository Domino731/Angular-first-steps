package game.entities.player.tools;

public class toolsConstants {
    public static byte[][] rightAxeAnimation = createRightAxeAnimation();


    private static byte[][] createRightAxeAnimation() {
        byte[][] rightAxeAnimation = new byte[5][3];
        rightAxeAnimation[0][0] = -8;
        rightAxeAnimation[0][1] = 0;
        rightAxeAnimation[0][2] = 15;
        rightAxeAnimation[1][0] = 5;
        rightAxeAnimation[1][1] = 0;
        rightAxeAnimation[1][2] = -15;
        rightAxeAnimation[2][0] = 16;
        rightAxeAnimation[2][1] = -5;
        rightAxeAnimation[2][2] = -45;
        rightAxeAnimation[3][0] = 21;
        rightAxeAnimation[3][1] = -23;
        rightAxeAnimation[3][2] = -105;
        rightAxeAnimation[4][0] = 21;
        rightAxeAnimation[4][1] = -25;
        rightAxeAnimation[4][2] = -105;

        return rightAxeAnimation;
    }
}
