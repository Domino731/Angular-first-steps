package environment.resources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.ActionCollision;
import engine.actors.DefaultActor;
import engine.actors.constants.ActorTypes;
import engine.actors.groundItem.GroundItem;
import engine.actorsManager.ActorsManager;
import engine.items.DropItemData;
import engine.items.Items;
import engine.utils.Action;
import engine.utils.Draw;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

import static engine.utils.PositionUtils.convertTilePosition;
import static environment.resources.ResourceUtils.*;

public class Resource extends DefaultActor {
    private ResourcesConfig.Config config;
    private ActorsManager actorsManager;
    private ArrayList<GroundItem> items = new ArrayList<>();
    private Draw draw;
    private boolean isDestroyed = false;
    private ArrayList<ActionCollision> itemsCollisions = new ArrayList<>();

    public Resource(String id, final Vector<Integer> position, ActorsManager actorsManager) {
        super(
                ActorTypes.STATIC,
                convertTilePosition(position),
                "sprites/trees/oak_spring.png",
                new DimensionVector<>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.actorsManager = actorsManager;
        config = ResourcesConfig.get(id);
        setGroundCheckboxByResSize();
        hp = 100;
        setActionsCollisions();
        setDraw();
    }

    private void setDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawResource(sb);
            }
        };
    }

    private void drawResource(SpriteBatch sb) {
        sb.draw(config.txt, position.x, position.y);
    }

    @Override
    public void update(double delta) {
        for (GroundItem item : items) {
            item.update(delta);
        }
    }

    private void drawItems(SpriteBatch sb) {
        for (GroundItem item : items) {
            item.draw(sb);
        }
    }

    public ArrayList<ActionCollision> getItemsCollisions() {
        return itemsCollisions;
    }

    @Override
    public void draw(SpriteBatch sb) {
        draw.draw(sb);
    }

    private void showGroundItems() {
        if (isDestroyed) {
            return;
        }

        for (DropItemData data: config.getDrop() ) {
            String itemId = data.getItemId();
            items.add(new GroundItem(position.x, position.y, Items.getData(itemId).getTxt(), createItemActionCollision(itemId)));
        }


        for (GroundItem item : items) {
            itemsCollisions.add(item.getActionCollision());
        }

        actorsManager.addGroundItems(itemsCollisions);

        setIsDestroyed(true);
        setGroundItemsDraw();
    }

    private void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    private void setGroundItemsDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawItems(sb);
            }
        };
    }

    private void removeResource() {
        actorsManager.removeResourceObject(this);
    }

    private Action createItemActionCollision(final String itemId) {
        return new Action() {
            @Override
            public void action() {
                actorsManager.addItemToPlayerInventory(itemId, (byte) 1);
                removeResource();
            }
        };
    }

    private void setGroundCheckboxByResSize() {
        setGroundCheckbox(getDimCordVectorBySize(config.getIsBig()));
    }


    private void setActionsCollisions() {
        final Resource resource = this;

        actionCollisions.add(
                new ActionCollision(
                        config.getActionType(),
                        id,
                        getPositionForActionCollision(config.getIsBig(), position),
                        getDimensionVectorForActionCollision(config.getIsBig()),
                        new Vector<>(0, 0),
                        new ResourceAction() {
                            @Override
                            public void action() {
                                actorsManager.removeResourceObjectItems(resource);
                                showGroundItems();
                            }
                        }
                ));
    }
}
