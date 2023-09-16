package environment.resources;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.Textures;
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

import static engine.Textures.woodTxtRg;
import static engine.utils.PositionUtils.convertTilePosition;
import static environment.resources.ResourceUtils.*;

public class Resource extends DefaultActor {
    private ResourcesConfig.Config config;
    private ActorsManager actorsManager;
    private ArrayList<GroundItem> items = new ArrayList<>();
    private Draw draw;
    private boolean isDestroyed = false;
    private ArrayList<ActionCollision> itemsCollisions = new ArrayList<>();
    private TextureRegion testTxt;
    private ArrayList<DropItemData> drop;
    public Resource(String id, final Vector<Integer> position, ActorsManager actorsManager) {
        super(
                ActorTypes.STATIC,
                convertTilePosition(position),
                "sprites/trees/oak_spring.png",
                new DimensionVector<Integer>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.actorsManager = actorsManager;
        config = ResourcesConfig.get(id);
        setGroundCheckboxByResSize();
        hp = 100;
        setActionsCollisions();
        setDraw();
        testTxt = Items.getData("wood").getTxt();
        showGroundItemsTest();
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
        sb.draw(Textures.frameTxt, actionCollisions.get(0).position.x, actionCollisions.get(0).position.y, actionCollisions.get(0).dim.width, actionCollisions.get(0).dim.height);
        sb.draw(Textures.slotTxt, position.x, position.y, 16,16);
        sb.draw(config.txt, position.x, position.y);
        int i = 0;
        for (DropItemData itemData: drop) {
            i++;
            sb.draw(itemData.getTxt(), position.x + (i * 16), position.y);
        }
//        sb.draw(Textures.checkbox, position.x, position.y, 16, 16);
//        sb.draw(testTxt, position.x, position.y);
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

    // TODO test purpose only, remove later
    private void showGroundItemsTest() {
         drop = config.getDrop();
    }


    private void showGroundItems() {
        if (isDestroyed) {
            return;
        }
        isDestroyed = true;
        items.add(new GroundItem(position.x, position.y, woodTxtRg, createItemActionCollision()));
        for (GroundItem item : items) {
            itemsCollisions.add(item.getActionCollision());
        }

        actorsManager.addGroundItems(itemsCollisions);

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

    private Action createItemActionCollision() {
        return new Action() {
            @Override
            public void action() {
                actorsManager.addItemToPlayerInventory("wood", (byte) 1);
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
