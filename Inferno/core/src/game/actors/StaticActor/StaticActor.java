package game.actors.StaticActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;

public class StaticActor extends DefaultActor {
    private final StaticActorConfig config;

    public StaticActor(String actorId, int positionX, int positionY) {
        super(ActorTypes.STATIC, positionX, positionY);
        config = StaticActorConfigManager.get(actorId);
        setGroundCheckbox(config.getGroundCheckbox());
    }

    @Override
    public void draw(SpriteBatch sb) {
//        sb.draw(Textures.checkbox, position.x, position.y, config.getTxt().getRegionWidth(), config.getTxt().getRegionHeight());
        sb.draw(config.getTxt(), position.x, position.y);
//        sb.draw(Textures.frameTxt, groundCheckbox.position.x, groundCheckbox.position.y, groundCheckbox.dim.width, groundCheckbox.dim.height);
    }
}
