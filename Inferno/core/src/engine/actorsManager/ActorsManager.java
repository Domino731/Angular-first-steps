package engine.actorsManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import engine.actionCollision.ActionCollision;
import engine.actors.DefaultActor;
import engine.items.Items;
import environment.resources.Resource;
import game.entities.player.Player;
import utils.Checkbox;
import utils.vectors.Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ActorsManager {
    private ArrayList<DefaultActor> allActors = new ArrayList<>();
    private ArrayList<Checkbox> checkboxes = new ArrayList<>();
    private ArrayList<Checkbox> groundCheckboxes = new ArrayList<>();
    private ArrayList<ActionCollision> actionCollisions = new ArrayList<>();
    private ArrayList<ActionCollision> groundItems = new ArrayList<>();
    private ArrayList<Items.Render> itemsList = new ArrayList<>();

    public Player player;

    public ActionCollision currentAction = null;

    public ActorsManager() {
        // TODO: spawdzic czy jak dwa obiekty sa w tym samym miejscu to czy nie blokuje player'a
        createPlayer();
        Resource rsc = new Resource("trunk_big", new Vector<>(2, 2), this);
        addActor(rsc);
        Resource rsc2 = new Resource("amethyst_ore", new Vector<>(2, 6), this);
        addActor(rsc2);
        Resource rsc3 = new Resource("aquamarine_ore", new Vector<>(4, 6), this);
        addActor(rsc3);
        Resource rsc4 = new Resource("copper_ore", new Vector<>(6, 6), this);
        addActor(rsc4);
        Resource rsc5 = new Resource("diamond_ore", new Vector<>(8, 6), this);
        addActor(rsc5);
        Resource rsc6 = new Resource("emerald_ore", new Vector<>(10, 6), this);
        addActor(rsc6);
        Resource rsc7 = new Resource("gem_ore", new Vector<>(12, 6), this);
        addActor(rsc7);
        Resource rsc8 = new Resource("gold_ore", new Vector<>(2, 8), this);
        addActor(rsc8);
        Resource rsc9 = new Resource("iridium_ore", new Vector<>(4, 8), this);
        addActor(rsc9);
        Resource rsc10 = new Resource("iron_ore", new Vector<>(6, 8), this);
        addActor(rsc10);
        Resource rsc11 = new Resource("jade_ore", new Vector<>(8, 8), this);
        addActor(rsc11);
        Resource rsc12 = new Resource("mystic_stone", new Vector<>(10, 8), this);
        addActor(rsc12);
        Resource rsc13 = new Resource("ruby_ore", new Vector<>(12, 8), this);
        addActor(rsc13);
        Resource rsc14 = new Resource("topaz_ore", new Vector<>(2, 1), this);
        addActor(rsc14);
        Resource rsc15 = new Resource("geode_ore", new Vector<>(4, 1), this);
        addActor(rsc15);
        Resource rsc16 = new Resource("frozen_geode_ore", new Vector<>(6, 1), this);
        addActor(rsc16);
        Resource rsc17 = new Resource("magma_geode_ore", new Vector<>(8, 1), this);
        addActor(rsc17);
        Resource rsc18 = new Resource("bone_ore", new Vector<>(10, 1), this);
        addActor(rsc18);
        Resource rsc19 = new Resource("cinder_shard_ore", new Vector<>(12, 1), this);
        addActor(rsc19);
        Resource rsc20 = new Resource("clay_ore", new Vector<>(14, 1), this);
        addActor(rsc20);
        Resource rsc21 = new Resource("omni_geode_ore", new Vector<>(6, 3), this);
        addActor(rsc21);
        Resource rsc22 = new Resource("radioactive_ore", new Vector<>(8, 3), this);
        addActor(rsc22);
        Resource rsc23 = new Resource("mussel_ore", new Vector<>(10, 3), this);
        addActor(rsc23);


    }


    private void createPlayer() {
        player = new Player(this);
        allActors.add(player);
        checkboxes.addAll(player.getCheckboxArray());
        groundCheckboxes.add(player.getGroundCheckbox());
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
    }

    public void update(double delta) {
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
            actor.update(delta);
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

    public void addGroundItem(ActionCollision groundItems) {
        this.groundItems.add(groundItems);
    }

    public void removeResourceObjectItems(Resource rsc) {
        checkboxes.remove(rsc.getGroundCheckbox());
        groundCheckboxes.remove(rsc.getGroundCheckbox());
        actionCollisions.removeAll(rsc.getActionCollisions());
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

    public static boolean checkCollision(Checkbox checkbox1, Checkbox checkbox2) {
        // Calculate the coordinates of the bounding boxes
        int x1 = checkbox1.position.x;
        int y1 = checkbox1.position.y;
        int width1 = checkbox1.dim.width;
        int height1 = checkbox1.dim.height;
        int x2 = checkbox2.position.x;
        int y2 = checkbox2.position.y;
        int width2 = checkbox2.dim.width;
        int height2 = checkbox2.dim.height;
        if (x1 < x2 + width2 && x1 + width1 > x2 && y1 < y2 + height2 && y1 + height1 > y2) {
            return true;
        }
        return false;
    }
}
