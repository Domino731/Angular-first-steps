package engine.actorsManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import engine.actors.DefaultActor;
import environment.resources.Resource;
import environment.trees.ExampleTree;
import game.entities.player.Player;
import utils.Checkbox;
import utils.vectors.Vector;
import world.trees.NewTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ActorsManager {
    private ArrayList<DefaultActor> allActors = new ArrayList<>();
    public Player player = new Player();
    private ArrayList<Checkbox> checkboxes = new ArrayList<>();
    private ArrayList<Checkbox> groundCheckboxes = new ArrayList<>();
    NewTree newTree;

    public ActorsManager() {

        ExampleTree exampleTree = new ExampleTree(150, 150);
        ExampleTree exampleTree2 = new ExampleTree(150, 200);
        newTree = new NewTree(new Vector<Integer>(5 * 16, 5 * 16));
        Resource rsc = new Resource(new Vector<Integer>(2, 2));
        Resource rsc2 = new Resource(new Vector<Integer>(6, 2));

        allActors.add(player);

        allActors.add(exampleTree);
        allActors.add(exampleTree2);
        allActors.add(newTree);
        allActors.add(rsc);
        allActors.add(rsc2);

        checkboxes.add(player.getGroundCheckbox());
        checkboxes.add(exampleTree.getGroundCheckbox());
        checkboxes.add(rsc.getGroundCheckbox());
        checkboxes.add(rsc2.getGroundCheckbox());

//        checkboxes.addAll(player.getCheckboxArray());
        groundCheckboxes.add(exampleTree.getGroundCheckbox());
        groundCheckboxes.add(exampleTree2.getGroundCheckbox());
        groundCheckboxes.add(player.getGroundCheckbox());
        groundCheckboxes.add(rsc.getGroundCheckbox());
        groundCheckboxes.add(rsc2.getGroundCheckbox());
    }

    public void draw(SpriteBatch sb) {
        for (DefaultActor actor : allActors) {
            actor.draw(sb);
        }
    }

    public void update() {
        newTree.update();
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

        player.update();
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
        for (Checkbox cb : checkboxes) {
            sr.begin(ShapeRenderer.ShapeType.Line);
            sr.setColor(1, 0, 0, 1); // Red color
            sr.rect(cb.position.x, cb.position.y, cb.dim.width, cb.dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
            sr.end();
        }
        for (Checkbox cb : groundCheckboxes) {
            sr.begin(ShapeRenderer.ShapeType.Line);
            sr.setColor(0, 0, 1, 1); // Red color
            sr.rect(cb.position.x, cb.position.y, cb.dim.width, cb.dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
            sr.end();
        }
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
