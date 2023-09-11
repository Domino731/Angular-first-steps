package engine.actorsManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import engine.actionCollision.ActionCollision;
import engine.actors.DefaultActor;
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

    public Player player;

    public ActionCollision currentAction = null;

    public ActorsManager() {
        createPlayer();
        Resource rsc = new Resource("trunk_big", new Vector<>(2, 2), this);
        addActor(rsc);
        Resource rsc2 = new Resource("log_large", new Vector<>(2, 6), this);
        addActor(rsc2);
        Resource rsc3 = new Resource("volcano_rock_large", new Vector<>(6, 2), this);
        addActor(rsc3);
        Resource rsc4 = new Resource("coal_rock_large", new Vector<>(6, 6), this);
        addActor(rsc4);
        Resource rsc5 = new Resource("blue_gem_large", new Vector<>(10, 2), this);
        addActor(rsc5);
        Resource rsc6 = new Resource("blue_gem_active_large", new Vector<>(10, 6), this);
        addActor(rsc6);
        Resource rsc7 = new Resource("stone_large", new Vector<>(14, 2), this);
        addActor(rsc7);
        Resource rsc8 = new Resource("alien_stone_large", new Vector<>(14, 6), this);
        addActor(rsc8);
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

    public void renderCheckboxes(ShapeRenderer sr) {
//        for (Checkbox cb : checkboxes) {
//            sr.begin(ShapeRenderer.ShapeType.Line);
//            sr.setColor(1, 0, 0, 1); // Red color
//            sr.rect(cb.position.x, cb.position.y, cb.dim.width, cb.dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
//            sr.end();
//        }
//        for (Checkbox cb : checkboxes) {
//            sr.begin(ShapeRenderer.ShapeType.Line);
//            sr.setColor(1, 0, 0, 1); // Red color
//            sr.rect(cb.position.x, cb.position.y, cb.dim.width, cb.dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
//            sr.end();
//        }
//        for (Checkbox cb : groundCheckboxes) {
//            sr.begin(ShapeRenderer.ShapeType.Line);
//            sr.setColor(0, 0, 1, 1); // Red color
//            sr.rect(cb.position.x, cb.position.y, cb.dim.width, cb.dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
//            sr.end();
//        }
//        sr.begin(ShapeRenderer.ShapeType.Line);
//        sr.setColor(0, 0, 1, 1); // Red color
//        sr.rect(player.getCheckboxArray().get(0).position.x, player.getCheckboxArray().get(0).position.y, player.getCheckboxArray().get(0).dim.width, player.getCheckboxArray().get(0).dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
//        sr.end();
//        Vector<Integer> position = player.getFinalPosition();
//        sr.begin(ShapeRenderer.ShapeType.Line);
//        sr.setColor(0, 0, 1, 1); // Red color
//        sr.rect(position.x, position.y, player.getDim().width, player.getDim().height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
//        sr.end();
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
