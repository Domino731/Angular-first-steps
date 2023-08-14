package environment.resources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class Resource extends DefaultActor {
    private ResourcesConfig.Config config;

    public Resource(Vector<Integer> position) {
        super(
                ActorTypes.STATIC,
                new Vector<Integer>(position.x * 16, position.y * 16),
                "sprites/trees/oak_spring.png",
                new DimensionVector<Integer>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        config = ResourcesConfig.get("trunk_big");
    }


    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(config.txt, position.x, position.y);
        sb.draw(ResourceTextures.txtTest, position.x, position.y, 32, 32);
    }
}
