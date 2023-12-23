package game.player.animations.utils;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

// TODO make this static
public class AnimationAmount {
    private byte[][] animations = new byte[4][4];

    public AnimationAmount(TextureRegion[][] textures) {
        setAnimations(textures);
    }

    private void setAnimations(TextureRegion[][] textures) {
        byte[][] data = new byte[textures.length][1];

        for (int i = 0; i < textures.length; i++) {
            TextureRegion[] txt = textures[i];
            byte value = 0;

            for (int j = 0; j < txt.length; j++) {
                if (txt[j] != null) {
                    value++;
                }
            }

            data[i][0] = value;
        }


        animations = data;
    }

    public int getAmount(int playerIndex) {
        return animations[playerIndex][0];
    }

}
