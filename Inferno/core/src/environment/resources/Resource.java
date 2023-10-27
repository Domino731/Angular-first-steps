package environment.resources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import constants.actors.groundItem.GroundItem;
import engine.Textures;
import engine.actionCollision.ActionCollision;
import engine.actionCollision.actorsManager.ActorsManager;
import engine.actionCollision.actorsManager.GameTime;
import engine.items.DropItemData;
import engine.items.Items;
import engine.utils.Action;
import engine.utils.Draw;
import utils.EngineLog;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

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
                position.x, position.y,
                null,
                new DimensionVector<>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.actorsManager = actorsManager;
        config = ResourcesConfig.get(id);
        setGroundCheckboxByResSize();
        setActionsCollisions();
        hp = 100;

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
        sb.draw(Textures.checkbox, position.x, position.y, config.txt.getRegionWidth(), config.txt.getRegionHeight());
        sb.draw(config.txt, position.x, position.y);
        sb.draw(Textures.frameTxt, actionCollisions.get(0).position.x, actionCollisions.get(0).position.y, actionCollisions.get(0).dim.width, actionCollisions.get(0).dim.height);
    }

    @Override
    public void update(float delta, GameTime dateTime) {
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


    private Action createItemActionCollision(final String itemId, final GroundItem groundItem) {
        return new Action() {
            @Override
            public void action() {
                actorsManager.addItemToPlayerInventory(itemId, (byte) 1);
                actorsManager.removeGroundItem(groundItem);
                items.remove(groundItem);
                if (items.size() == 0) {
                    EngineLog.print("Resource removed");
                    removeResource();
                }
            }
        };
    }

    private void showGroundItems() {
        if (isDestroyed) {
            return;
        }

        int i = 0;
        for (DropItemData data : config.getDrop()) {
            String itemId = data.getItemId();
            i++;
            GroundItem groundItem = new GroundItem(position.x + (i * 8), position.y, Items.getData(itemId).getTxt());
            groundItem.setActionCollision(createItemActionCollision(itemId, groundItem));
            items.add(groundItem);
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

    private void setGroundCheckboxByResSize() {
        setGroundCheckbox(getDimCordVectorBySize(config.getGroundCheckboxId()));
    }


    private void setActionsCollisions() {
        final Resource resource = this;

        actionCollisions.add(
                new ActionCollision(
                        config.getActionType(),
                        id,
                        getPositionForActionCollision(config.getActionCollisionId(), position),
                        getDimensionVectorForActionCollision(config.getActionCollisionId()),
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
