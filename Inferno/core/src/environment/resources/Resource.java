package environment.resources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.ActionCollision;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.actors.groundItem.GroundItem;
import engine.actorsManager.ActorsManager;
import engine.utils.Draw;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

import static engine.Textures.woodTxtRg;

public class Resource extends DefaultActor {
    private ResourcesConfig.Config config;
    private ActorsManager actorsManager;
    private ArrayList<GroundItem> items = new ArrayList<>();
    private Draw draw;

    public Resource(String id, final Vector<Integer> position, ActorsManager actorsManager) {
        super(
                ActorTypes.STATIC,
                new Vector<>(position.x * 16, position.y * 16),
                "sprites/trees/oak_spring.png",
                new DimensionVector<Integer>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.actorsManager = actorsManager;
        config = ResourcesConfig.get(id);
        hp = 100;
        setActionsCollisions();

        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawResource(sb);
            }
        };

    }

    private void drawResource(SpriteBatch sb) {
        sb.draw(config.txt, position.x, position.y);
        sb.draw(woodTxtRg, position.x, position.y);
    }

    @Override
    public void update() {
        for (GroundItem item : items) {
            item.update();
        }
    }

    private void drawItems(SpriteBatch sb) {
        for (GroundItem item : items) {
            item.draw(sb);
        }
    }


    @Override
    public void draw(SpriteBatch sb) {
        draw.draw(sb);
    }

    private void showGroundItems() {
        items.add(new GroundItem(position.x, position.y, woodTxtRg));
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawItems(sb);
            }
        };
    }

    private void setActionsCollisions() {
        final Resource resource = this;

        actionCollisions.add(
                new ActionCollision(
                        config.getActionType(),
                        id,
                        new Vector<>(position.x - 5, position.y - 5),
                        new DimensionVector<>(40, 40),
                        new Vector<>(0, 0),
                        new ResourceAction() {
                            @Override
                            public void action() {
//                                actorsManager.removeActor(resource);
                                showGroundItems();
                            }
                        }
                ));
    }
}
