package engine.actionCollision.actorsManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import constants.actors.DefaultActor;
import constants.actors.EnvironmentActor.EnvironmentActor;
import constants.actors.groundItem.GroundItem;
import engine.actionCollision.ActionCollision;
import engine.items.Items;
import environment.resources.Resource;
import environment.trees.Tree;
import game.entities.player.Player;
import hud.clock.Clock;
import utils.Checkbox;
import utils.vectors.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

import static engine.actionCollision.actorsManager.ActorsUtils.checkCollision;


public class ActorsManager {
    private final ArrayList<DefaultActor> allActors = new ArrayList<>();
    private final ArrayList<Checkbox> checkboxes = new ArrayList<>();
    private final ArrayList<Checkbox> groundCheckboxes = new ArrayList<>();
    private final ArrayList<ActionCollision> actionCollisions = new ArrayList<>();
    private final ArrayList<ActionCollision> groundItems = new ArrayList<>();
    private final ArrayList<Items.Render> itemsList = new ArrayList<>();
    private final GameTime gameTime = new GameTime();
    private final Clock clock = new Clock();

    public Player player;

    public ActionCollision currentAction = null;

    public ActorsManager() {
        // TODO: spawdzic czy jak dwa obiekty sa w tym samym miejscu to czy nie blokuje player'a
        createPlayer();
        EnvironmentActor newActor = new EnvironmentActor("maple", new Vector<Integer>(4, 5), this);
        addActor(newActor);
        setGameTimeMinuteAction();
        ;
    }

    private void setGameTimeMinuteAction() {
        for (DefaultActor actor : allActors) {
            gameTime.addNewMinuteActions(actor.getMinuteActions());
        }
    }

    public void drawClock() {
        clock.draw();
    }

    public void addActionCollisions(ArrayList<ActionCollision> actions) {
        actionCollisions.addAll(actions);
    }

    private void createPlayer() {
        player = new Player(this);
        allActors.add(player);
        checkboxes.addAll(player.getCheckboxArray());
        groundCheckboxes.add(player.getGroundCheckbox());
    }

    public ArrayList<Checkbox> getPlayerCheckboxArray() {
        return player.getCheckboxArray();
    }

    private void addActor(DefaultActor actor) {
        allActors.add(actor);
        checkboxes.add(actor.getGroundCheckbox());
        groundCheckboxes.add(actor.getGroundCheckbox());
        actionCollisions.addAll(actor.getActionCollisions());
    }

    public void removeActor(DefaultActor actor) {
        allActors.remove(actor);
        checkboxes.remove(actor.getGroundCheckbox());
        groundCheckboxes.remove(actor.getGroundCheckbox());
        actionCollisions.removeAll(actor.getActionCollisions());
        currentAction = null;
    }

    public void draw(SpriteBatch sb) {
        for (DefaultActor actor : allActors) {
            actor.draw(sb);
        }
        // TODO remove later
        for (Items.Render render : itemsList
        ) {
            render.draw(sb);
        }
    }

    public void update(float delta) {
        gameTime.update(delta);
        clock.setTime(gameTime.getDays(), gameTime.getHours(), gameTime.getMinutes());

        sortCheckboxesByPosition();
        player.setIsCollision(false);
        player.updatePos();

        // Loop to check collisions
        for (int i = 0; i < checkboxes.size(); i++) {
            Checkbox checkbox1 = checkboxes.get(i);
            for (int j = i + 1; j < checkboxes.size(); j++) {
                Checkbox checkbox2 = checkboxes.get(j);
                if (checkCollision(checkbox1, checkbox2)) {
                    player.setIsCollision(true);
                    player.resetPosition();
                }
            }
        }

        // check if player is already in collision area
        if (currentAction != null) {
            if (!checkCollision(currentAction, player.getActionCollisions().get(0))) {
                currentAction = null;
            }
        } else {
            // Loop to check action collisions
            for (int i = 0; i < actionCollisions.size(); i++) {
                ActionCollision checkbox = actionCollisions.get(i);
                if (checkCollision(checkbox, player.getActionCollisions().get(0))) {
                    currentAction = checkbox;
                }
            }
        }

        for (int i = 0; i < groundItems.size(); i++) {
            ActionCollision checkbox = groundItems.get(i);
            if (checkCollision(checkbox, player.getActionCollisions().get(0))) {
                checkbox.action();
            }
        }


        for (DefaultActor actor : allActors
        ) {
            actor.update(delta, gameTime);
        }
    }

    public void sortCheckboxesByPosition() {
        // Implement custom comparator to sort checkboxes by 'y' position in ascending order
        Comparator<DefaultActor> checkboxComparator = new Comparator<DefaultActor>() {
            @Override
            public int compare(DefaultActor checkbox1, DefaultActor checkbox2) {
                return Integer.compare(checkbox2.getPosition().y, checkbox1.getPosition().y);
            }
        };

        Collections.sort(allActors, checkboxComparator);
    }

    public void addGroundItems(ArrayList<ActionCollision> groundItems) {
        this.groundItems.addAll(groundItems);
    }

    public void removeGroundItem(GroundItem groundItem) {
        this.groundItems.remove(groundItem.getActionCollision());
    }

    public void addGroundItem(ActionCollision groundItems) {
        this.groundItems.add(groundItems);
    }

    public void removeGroundCheckbox(Checkbox checkbox) {
        groundCheckboxes.remove(checkbox);
        checkboxes.remove(checkbox);
    }

    public void removeActionCollisions(ArrayList<ActionCollision> actions) {
        for (ActionCollision actionCollision : actions) {
            if (currentAction != null && Objects.equals(currentAction.id, actionCollision.id)) {
                currentAction = null;
                break;
            }
        }
        actionCollisions.removeAll(actions);
    }

    public void addGroundCheckbox(Checkbox checkbox) {
        if (!groundCheckboxes.contains(checkbox)) {
            groundCheckboxes.add(checkbox);
            checkboxes.add(checkbox);
        }
    }

    // TODO merge
    public void removeResourceObjectItems(Resource rsc) {
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
        currentAction = null;
    }

    public void removeTreeObjectItems(Tree rsc) {
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
        currentAction = null;
    }

    public void removeTreeObjectItems(EnvironmentActor rsc) {
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
        currentAction = null;
    }

    // TODO merge
    public void removeTreeObject(Tree rsc) {
        allActors.remove(rsc);
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
        groundItems.removeAll(rsc.getItemsCollisions());
        currentAction = null;
    }

    public void removeTreeObject(EnvironmentActor rsc) {
        allActors.remove(rsc);
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
        groundItems.removeAll(rsc.getItemsCollisions());
        currentAction = null;
    }

    public void removeResourceObject(Resource rsc) {
        allActors.remove(rsc);
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
        groundItems.removeAll(rsc.getItemsCollisions());
        currentAction = null;
    }

    public void addItemToPlayerInventory(String itemId, byte amount) {
        player.inventory.addItem(itemId, amount);
    }
}
