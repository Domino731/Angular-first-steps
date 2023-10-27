package constants.actors.staticDefaultActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import engine.Textures;
import utils.vectors.Vector;

public class StaticDefaultActor extends DefaultActor {
    private final StaticDefaultActorConfig.Config config;

    public StaticDefaultActor(String id, Vector<Integer> position) {
        super(ActorTypes.STATIC, position.x, position.y);
        config = StaticDefaultActorConfig.getData(id);
        setGroundCheckbox(config.getGroundDimensionVector());
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(Textures.checkbox, position.x, position.y, config.getTxt().getRegionWidth(), config.getTxt().getRegionHeight());
        sb.draw(config.getTxt(), position.x, position.y);
        sb.draw(Textures.frameTxt, groundCheckbox.position.x, groundCheckbox.position.y, groundCheckbox.dim.width, groundCheckbox.dim.height);
    }
}
