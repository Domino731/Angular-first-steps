package game.entities.player.animations.config;

import game.entities.player.PlayerTextures;

import static game.entities.player.PlayerTextures.ANIMATION_AMOUNT;
import static game.entities.player.PlayerTextures.MAX_ANIMATION_FRAMES;

public class ShirtOffset {
    public static final byte[][] shirtOffset = createOffsets();

    private static byte[][] createOffsets() {
        byte[][] data = new byte[ANIMATION_AMOUNT][MAX_ANIMATION_FRAMES];

        // IDLE
        data[PlayerTextures.ANI_IDLE_UP] = new byte[]{10};
        data[PlayerTextures.ANI_IDLE_RIGHT] = new byte[]{9};
        data[PlayerTextures.ANI_IDLE_DOWN] = new byte[]{-3};
        data[PlayerTextures.ANI_IDLE_LEFT] = new byte[]{9};
        // IDLE WITH ITEM
        data[PlayerTextures.ANI_IDLE_ITEM_UP] = new byte[]{10};
        data[PlayerTextures.ANI_IDLE_ITEM_RIGHT] = new byte[]{9};
        data[PlayerTextures.ANI_IDLE_ITEM_DOWN] = new byte[]{-3};
        data[PlayerTextures.ANI_IDLE_ITEM_LEFT] = new byte[]{9};

        // RUNNING
        data[PlayerTextures.ANI_RUNNING_UP] = new byte[]{9, 9, 10, 9, 9, 10};
        data[PlayerTextures.ANI_RUNNING_RIGHT] = new byte[]{8, 8, 9, 8, 8, 9};
        data[PlayerTextures.ANI_RUNNING_DOWN] = new byte[]{8, 7, 8, 9, -4, -5, -4, -3};
        data[PlayerTextures.ANI_RUNNING_LEFT] = new byte[]{8, 8, 9, 8, 8, 9};

        // RUNNING
        data[PlayerTextures.ANI_RUNNING_ITEM_UP] = new byte[]{9, 9, 10, 9, 9, 10};
        data[PlayerTextures.ANI_RUNNING_ITEM_RIGHT] = new byte[]{8, 8, 9, 8, 8, 9};
        data[PlayerTextures.ANI_RUNNING_ITEM_DOWN] = new byte[]{8, 7, 8, 9, -4, -5, -4, -3};
        data[PlayerTextures.ANI_RUNNING_ITEM_LEFT] = new byte[]{8, 8, 9, 8, 8, 9};

        return data;
    }
}
