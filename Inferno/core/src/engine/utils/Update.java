package engine.utils;

import engine.actionCollision.actorsManager.GameTime;

public interface Update {
    void update(float delta, GameTime gameTime);
}
