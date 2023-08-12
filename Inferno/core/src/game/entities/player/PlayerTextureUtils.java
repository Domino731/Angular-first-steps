package game.entities.player;

public class PlayerTextureUtils {
    public static byte getShirtYOffset(int playerAction, int aniIndex) {
        if (playerAction == PlayerTextures.STATE_IDLE_UP || playerAction == PlayerTextures.STATE_IDLE_RIGHT || playerAction == PlayerTextures.STATE_IDLE_DOWN || playerAction == PlayerTextures.STATE_IDLE_LEFT) {
            return 8;
        }
        // handle running horizontally
        if (playerAction == PlayerTextures.STATE_RUNNING_LEFT || playerAction == PlayerTextures.STATE_RUNNING_RIGHT || playerAction == PlayerTextures.STATE_RUNNING_UP) {
            switch (aniIndex) {
                case 0:
                case 1:
                case 3:
                case 4:
                    return 7;
                default:
                    return 8;
            }
        }
        // handle running down
        if (playerAction == PlayerTextures.STATE_RUNNING_DOWN) {
            switch (aniIndex) {
                case 1:
                case 4:
                    return 6;
                case 0:
                case 3:
                    return 7;
                default:
                    return 8;
            }
        }

        return 8;
    }

    public static byte getHairYOffset(int playerAction, int aniIndex) {
        // handle idle state;
        if (playerAction == PlayerTextures.STATE_IDLE_UP || playerAction == PlayerTextures.STATE_IDLE_RIGHT || playerAction == PlayerTextures.STATE_IDLE_DOWN || playerAction == PlayerTextures.STATE_IDLE_LEFT) {
            return -3;
        }
        // handle running horizontally
        if (playerAction == PlayerTextures.STATE_RUNNING_LEFT || playerAction == PlayerTextures.STATE_RUNNING_RIGHT) {
            switch (aniIndex) {
                case 0:
                    return -4;
                case 1:
                    return -4;
                case 2:
                    return -3;
                case 3:
                    return -4;
                case 4:
                    return -4;
                case 5:
                    return -3;

            }
        }

        if (playerAction == PlayerTextures.STATE_RUNNING_DOWN) {
            switch (aniIndex) {
                case 0:
                    return -4;
                case 1:
                    return -5;
                case 2:
                    return -3;
                case 3:
                    return -4;
                case 4:
                    return -5;
                case 5:
                    return -3;

            }
        }
        if (playerAction == PlayerTextures.STATE_RUNNING_UP) {
            switch (aniIndex) {
                case 0:
                    return -4;
                case 1:
                    return -4;
                case 2:
                    return -3;
                case 3:
                    return -4;
                case 4:
                    return -4;
                case 5:
                    return -3;

            }
        }
        return 0;
    }
}
