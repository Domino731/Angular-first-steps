package engine.actorsManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import engine.actors.DefaultActor;
import environment.trees.ExampleTree;
import game.entities.player.NewPlayer;
import utils.Checkbox;

import java.util.ArrayList;

public class ActorsManager {
    private ArrayList<DefaultActor> allActors = new ArrayList<>();
    public NewPlayer player = new NewPlayer();

    public ActorsManager() {
        ExampleTree exampleTree = new ExampleTree();

        allActors.add(player);
        allActors.add(exampleTree);
    }

    public void draw(SpriteBatch sb) {
        for (DefaultActor actor : allActors) {
            actor.draw(sb);
        }
    }

    public void renderCheckboxes(ShapeRenderer sr) {
        for (DefaultActor actor : allActors) {
            for (Checkbox cb : actor.getCheckboxArray()) {
                sr.begin(ShapeRenderer.ShapeType.Line);
                sr.setColor(1, 0, 0, 1); // Red color
                sr.rect(cb.position.x, cb.position.y, cb.dim.width, cb.dim.height); // Draw the border of a rectangle at (100, 100) with width 200 and height 100
                sr.end();
            }

        }
    }
}
