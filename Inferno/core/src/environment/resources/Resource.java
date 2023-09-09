package environment.resources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.ActionTypes;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.actorsManager.ActorsManager;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class Resource extends DefaultActor {
    private ResourcesConfig.Config config;
    private ActorsManager actorsManager;

    public Resource(String id, Vector<Integer> position, ActorsManager actorsManager) {
        super(
                ActorTypes.STATIC,
                new Vector<Integer>(position.x * 16, position.y * 16),
                "sprites/trees/oak_spring.png",
                new DimensionVector<Integer>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.actorsManager = actorsManager;
        config = ResourcesConfig.get(id);
        hp = 100;
        setActionsCollisions();
    }


    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(config.txt, position.x, position.y);
//        sb.draw(ResourceTextures.txtTest, actionCollisions.get(0).position.x, actionCollisions.get(0).position.y, actionCollisions.get(0).dim.width, actionCollisions.get(0).dim.height);
    }

    private void setActionsCollisions() {
        final Resource resource = this;

        actionCollisions.add(
                new ActionCollision(
                        ActionTypes.MINE_RESOURCE,
                        id,
                        new Vector<>(position.x - 5, position.y - 5),
                        new DimensionVector<>(40, 40),
                        new Vector<>(0, 0),
                        new ResourceAction() {
                            @Override
                            public void action() {
                                actorsManager.removeActor(resource);
                            }
                        }
                ));
    }
}
