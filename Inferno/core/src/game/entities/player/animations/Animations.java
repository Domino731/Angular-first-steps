package game.entities.player.animations;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Animations {
    public void drawUp(SpriteBatch sb);

    public void drawRight(SpriteBatch sb);

    public void drawDown(SpriteBatch sb);

    public void drawLeft(SpriteBatch sb);
}

