package constants.actors.staticDefaultActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import engine.Textures;
import utils.vectors.DimensionCordVector;
import utils.vectors.Vector;

import static engine.utils.PositionUtils.convertTilePosition;

public class StaticDefaultActor extends DefaultActor {
    private final StaticDefaultActorConfig.Config config;

    public StaticDefaultActor(String id, Vector<Integer> position) {
        super(ActorTypes.STATIC, convertTilePosition(position));
        config = StaticDefaultActorConfig.getData(id);
        setActorGroundCheckbox();
    }

    private void setActorGroundCheckbox() {
        setGroundCheckbox(new DimensionCordVector(11, 12, 3, 3));
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(Textures.checkbox, position.x, position.y, config.getTxt().getRegionWidth(), config.getTxt().getRegionHeight());
        sb.draw(config.getTxt(), position.x, position.y);
    }
}
