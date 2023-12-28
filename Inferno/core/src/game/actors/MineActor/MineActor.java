package game.actors.MineActor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import constants.actors.groundItem.GroundItem;
import engine.Textures;
import engine.fonts.actionCollision.ActionCollision;
import engine.fonts.actionCollision.actorsManager.ActorsManager;
import engine.fonts.actionCollision.actorsManager.GameTime;
import engine.items.DropItemData;
import engine.items.Items;
import engine.utils.Draw;
import utils.Action;
import utils.EngineLog;
import utils.vectors.DimensionCordVector;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class MineActor extends DefaultActor {
    private final MineActorConfig config;
    private final ActorsManager actorsManager;
    private ArrayList<GroundItem> items = new ArrayList<>();
    private Draw draw;
    private boolean isDestroyed = false;
    private ArrayList<ActionCollision> itemsCollisions = new ArrayList<>();
    private final TextureRegion txt;

    public MineActor(String actorId, int positionX, int positionY, ActorsManager actorsManager) {
        super(
                ActorTypes.STATIC,
                positionX, positionY,
                null,
                new DimensionVector<>(20, 20),
                new ArrayList<DimensionCordVector>(),
                new DimensionCordVector(32, 32, 0, 0)
        );
        this.config = MineActorConfigsManager.get(actorId);
        txt = config.getTxt();
        this.actorsManager = actorsManager;
        hp = 100;
        setGroundCollision();
        setActionsCollisions();
        setDraw();
    }

    private void setGroundCollision() {
        setGroundCheckbox(config.getGroundCollision());
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
//        sb.draw(Textures.checkbox, position.x, position.y, txt.getRegionWidth(), txt.getRegionHeight());
        sb.draw(txt, position.x, position.y);
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


    private engine.utils.Action createItemActionCollision(final String itemId, final GroundItem groundItem) {
        return new engine.utils.Action() {
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
        actorsManager.removeMineActor(this);
    }


    private void setActionsCollisions() {
        final MineActor resource = this;

        actionCollisions.add(
                new ActionCollision(
                        config.getActionType(),
                        id,
                        config.getActionCollision(position.x, position.y),
                        new Vector<>(0, 0),
                        new Action() {
                            @Override
                            public void action() {
                                actorsManager.removeMineActorItems(resource);
                                showGroundItems();
                            }
                        }
                ));
    }
}
