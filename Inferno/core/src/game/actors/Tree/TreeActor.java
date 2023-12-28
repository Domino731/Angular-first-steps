package game.actors.Tree;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.constants.ActorTypes;
import constants.actors.groundItem.GroundItem;
import engine.Textures;
import engine.fonts.actionCollision.ActionCollision;
import engine.fonts.actionCollision.actorsManager.ActorsManager;
import engine.fonts.actionCollision.actorsManager.ActorsUtils;
import engine.fonts.actionCollision.actorsManager.GameTime;
import engine.fonts.actionCollision.actorsManager.GameTimeNewMinute;
import engine.items.DropItemData;
import engine.items.Items;
import engine.utils.Action;
import engine.utils.Draw;
import engine.utils.Update;
import environment.resources.ResourceAction;
import utils.Checkbox;
import utils.EngineLog;
import utils.vectors.Vector;

import java.util.ArrayList;

public class TreeActor extends DefaultActor {
    private boolean isDestroyed = false;
    private final ActorsManager actorsManager;
    private final ArrayList<GroundItem> items = new ArrayList<>();
    private final ArrayList<ActionCollision> itemsCollisions = new ArrayList<>();
    private boolean isCollisionWithNextStage = false;
    private final TreeConfig config;
    private Update update;
    private int stageMinutes;
    private byte currentIndex = 0;
    GameTimeNewMinute gameTimeNewMinute;

    Draw draw;
    private TreeStageConfig currentStage;

    public TreeActor(String actorId, Vector<Integer> position, ActorsManager actorsManager) {
        super(ActorTypes.DYNAMIC, position.x, position.y);
        this.actorsManager = actorsManager;
        config = TreeConfigManager.get(actorId);
        currentStage = config.getStages()[currentIndex];
        stageMinutes = currentStage.getNextStage();
        setUpdate(currentIndex);
        setTreeGroundCheckbox();
        setActionCollision();
        setMinuteActions();
        setStageDraw();
    }

    public TreeActor(String actorId, Vector<Integer> position, ActorsManager actorsManager, byte stageIndex) {
        super(ActorTypes.DYNAMIC, position.x, position.y);
        this.currentIndex = stageIndex;
        this.actorsManager = actorsManager;
        config = TreeConfigManager.get(actorId);
        currentStage = config.getStages()[currentIndex];
        stageMinutes = currentStage.getNextStage();
        setUpdate(currentIndex);
        setTreeGroundCheckbox();
        setActionCollision();
        setStageDraw();

        if (getIsFinalStage()) {
            setFinalStageDraw();
            setCurrentGroundCollision();
            setActionCollisionByStage();
            clearUpdate();
        }
    }

    public void setTreeGroundCheckbox() {
        setGroundCheckbox(currentStage.getGroundCollision());
    }

    private boolean getAreItemsEmpty() {
        return items.size() == 0;
    }

    private Action createItemActionCollision(final String itemId, final GroundItem groundItem) {
        return new Action() {
            @Override
            public void action() {
                actorsManager.addItemToPlayerInventory(itemId, (byte) 1);
                actorsManager.removeGroundItem(groundItem);
                items.remove(groundItem);
                if (getAreItemsEmpty()) {
                    EngineLog.print("Resource removed");
                    removeResource();
                }
            }
        };
    }

    public ArrayList<ActionCollision> getItemsCollisions() {
        return itemsCollisions;
    }

    private void removeResource() {
        actorsManager.removeTreeObject(this);
    }

    private void showGroundItems() {
        if (isDestroyed) {
            return;
        }

        int i = 0;
        for (DropItemData data : currentStage.getDrop()) {
            String itemId = data.getItemId();
            System.out.print("ITEM ID: ");
            System.out.print(itemId);
            i++;
            GroundItem groundItem = new GroundItem(position.x + (i * 8), position.y, Items.getData(itemId).getTxt());
            groundItem.setActionCollision(createItemActionCollision(itemId, groundItem));
            items.add(groundItem);
        }


        for (GroundItem item : items) {
            itemsCollisions.add(item.getActionCollision());
        }

        actorsManager.addGroundItems(itemsCollisions);

        isDestroyed = true;
        setGroundItemsDraw();
    }

    private void setGroundItemsDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                drawItems(sb);
            }
        };
    }

    private void drawItems(SpriteBatch sb) {
        for (GroundItem item : items) {
            item.draw(sb);
        }
    }

    public void setActionCollision() {
        final TreeActor tree = this;

        ResourceAction resourceAction = new ResourceAction() {
            @Override
            public void action() {
                actorsManager.removeTreeObjectItems(tree);
                showGroundItems();
            }
        };

        ActionCollision actionCollision = currentStage.getActionCollision(resourceAction, id, position);
        actionCollisions.add(actionCollision);
    }

    public void setActionCollisionByStage() {
        actorsManager.removeActionCollisions(actionCollisions);
        actionCollisions.clear();
        setActionCollision();
        actorsManager.addActionCollisions(actionCollisions);
    }

    private void setMinuteActions() {
        gameTimeNewMinute = new GameTimeNewMinute() {
            @Override
            public void action(int minute, int minuteAbsolute) {
                if (isCollisionWithNextStage) {
                    return;
                }
                stageMinutes--;
                update.update(0, null);
            }
        };


        addMinuteAction(gameTimeNewMinute);
    }

    @Override
    public void update(float delta, GameTime gameTime) {

    }


    private void setUpdate(int stageIndex) {
        // TODO: move to GameTime handlers
        if (stageIndex >= config.getStages().length) {
            return;
        }
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
                if (stageMinutes == 0) {
                    if (currentIndex != config.getStages().length - 1) {
                        TreeStageConfig nextStage = config.getStages()[currentIndex + 1];
                        Checkbox nextStageChekbox = getGroundCheckboxTest(nextStage.getGroundCollision());
                        isCollisionWithNextStage = ActorsUtils.checkCollision(nextStageChekbox, actorsManager.getPlayerCheckboxArray().get(0));
                        if (isCollisionWithNextStage) {
                            return;
                        }
                    }

                    currentIndex++;
                    currentStage = config.getStages()[currentIndex];
                    stageMinutes = currentStage.getNextStage();
                    setUpdate(currentIndex);
                    setCurrentGroundCollision();
                    setActionCollisionByStage();

                    // check if it's last stage
                    if (getIsFinalStage()) {
                        setFinalStageDraw();
                        setCurrentGroundCollision();
                        setActionCollisionByStage();
                        clearUpdate();
                    }
                }
            }
        };
    }

    public boolean getIsFinalStage() {
        return currentIndex == config.getStages().length - 1;
    }

    public void setCurrentGroundCollision() {
        actorsManager.removeGroundCheckbox(groundCheckbox);
        setGroundCheckbox(currentStage.getGroundCollision());
        actorsManager.addGroundCheckbox(groundCheckbox);
    }


    private void setFinalStageDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(config.getTrunkTxt(), position.x, position.y, config.getTrunkTxt().getRegionWidth(), config.getTrunkTxt().getRegionHeight());
                sb.draw(currentStage.getTxt(), position.x - 16, position.y, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
            }
        };
    }

    private void clearUpdate() {
        // TODO later: remove action from gameTime
//        actorsManager.removeNewMinuteAction(gameTimeNewMinute);
        update = new Update() {
            @Override
            public void update(float delta, GameTime gameTime) {
//                System.out.println("TEST_123");
            }
        };
    }

    private void setStageDraw() {
        draw = new Draw() {
            @Override
            public void draw(SpriteBatch sb) {
                sb.draw(Textures.checkbox, groundCheckbox.position.x, groundCheckbox.position.y, groundCheckbox.dim.width, groundCheckbox.dim.height);
                sb.draw(currentStage.getTxt(), position.x, position.y, currentStage.getTxt().getRegionWidth(), currentStage.getTxt().getRegionHeight());
            }
        };
    }


    @Override
    public void draw(SpriteBatch sb) {
        draw.draw(sb);
    }
}
